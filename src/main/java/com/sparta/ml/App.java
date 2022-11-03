package com.sparta.ml;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {

    //HttpRequest, HttpClient, HttpResponse
    public static void main( String[] args ) {

        HttpClient client = HttpClient.newHttpClient();
        //var client : HttpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://api.chucknorris.io/"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response);
            //System.out.println(response.statusCode());
            //System.out.println(response.headers().toString());

            System.out.println(response.body());
            //we need to convert JSON response to an object: First add a dependency (com.fasterxml.jackson.core)

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
