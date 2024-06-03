package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    public static void askStatus(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter HTTP status code");
            int statusCode = Integer.parseInt(scanner.next());

            try {
                HttpStatusChecker.getStatusImage(statusCode);
                HttpStatusImageDownloader.downloadStatusImage(statusCode);
            } catch (IllegalArgumentException e){
                System.out.println("There is not image for HTTP status " + statusCode);
                scanner.reset();
                askStatus();
            }

        } catch (NumberFormatException e){
            System.out.println("Please enter valid number");
            scanner.reset();
            askStatus();
        }
    }
}
