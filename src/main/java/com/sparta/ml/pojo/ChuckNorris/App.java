package com.sparta.ml.pojo.ChuckNorris;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ChuckNorrisPojo chuckNorrisPojo = mapper.readValue(new URL("https://api.chucknorris.io/jokes/random"), ChuckNorrisPojo.class);
            //System.out.println(chuckNorrisPojo.toString());

            JsonNode jsonNode = mapper.readTree(new URL("https://pokeapi.co/api/v2/pokemon/charizard"));

            //System.out.println(jsonNode.getClass());
            System.out.println(Arrays.toString(chuckNorrisPojo.getClass().getDeclaredFields()));

            System.out.println(jsonNode
                    .get("abilities")
                    .get(0)
                    .get("ability")
                    .get("name")
                    .asText());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
