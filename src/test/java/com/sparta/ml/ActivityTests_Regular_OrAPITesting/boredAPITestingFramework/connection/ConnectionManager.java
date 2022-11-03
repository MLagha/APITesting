package com.sparta.ml.ActivityTests_Regular_OrAPITesting.boredAPITestingFramework.connection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Responsible for creating a connection to the endpoint
public class ConnectionManager {

    //if the tester passes xxxxx!!!, they get:
    private static final String BASEURL = "http://www.boredapi.com/api/activity";
    public static String getConnection() {
        return BASEURL;
    }

    //if the tester passes a key with a String value, they get:
    public static String getConnection(String key, String value) {
        return BASEURL + "?" + key + "=" + value;
    }

    //if the tester passes a key with an int value, they get:
    public static String getConnection(String key, int value) {
        return BASEURL + "?" + key + "=" + value;
    }

    private static HttpResponse<String> getResponse() {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(URI.create(BASEURL))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }

    public static int getStatusCode() {
        return getResponse().statusCode();
    }

    public static String getHeader(String key) {
        return getResponse()
                .headers()
                .firstValue(key)
                .orElse("Key not found");
    }
}
