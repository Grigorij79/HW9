package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpStatusImageDownloader {
    public static void downloadStatusImage(int code){
        String imageUrl = HttpStatusChecker.getStatusImage(code);

            try {
            URL connection = new URL(imageUrl);
            HttpURLConnection url = (HttpURLConnection) connection.openConnection();
            url.setRequestMethod("GET");
            url.connect();

            InputStream in = url.getInputStream();

            File file = new File("src/main/java/org.example" + code + ".jpg");
            if (!file.exists()){
                file.createNewFile();
            }
            OutputStream writer = new FileOutputStream(file);
            int size = 1024;
            byte[] buffer = new byte[size];
            int reader = in.read(buffer);
            while (reader > 0) {
                writer.write(buffer, 0, reader);
                reader = in.read(buffer);
            }
            writer.flush();
            writer.close();
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
