package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpStatusChecker {
    public  static String getStatusImage(int code)  {
        String result = "";
        try {
            URI uri = new URI("https", "http.cat", "/" + code, null);

            URL url = uri.toURL();

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == 200){
                result =  uri + ".jpg";
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return result;
    }
}
