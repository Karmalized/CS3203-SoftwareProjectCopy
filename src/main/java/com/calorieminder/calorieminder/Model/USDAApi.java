package com.calorieminder.calorieminder.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

//class for making API calls to USDA and retrieving data
public class USDAApi {
    public Micros searchForFoodById(int ID) {
        StringBuilder nutrients = new StringBuilder();
        for (int nutrient : Arrays.asList((new Micros()).nutrientNumbers)) {
            nutrients.append(nutrient).append(",");
        }
        // remove the last comma
        nutrients = new StringBuilder(nutrients.substring(0, nutrients.length() - 1));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.nal.usda.gov/fdc/v1/food/" + ID + "?api_key=DEMO_KEY&nutrients=" + nutrients + "&format=abridged"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response;


        //Parser test
        try {
                response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
                ;
                System.out.println(jsonObject.get("foodNutrients"));
                JSONArray nestedObject = (JSONArray) jsonObject.get("foodNutrients");

                for (int i = 0; i < nestedObject.size(); i++) {
                    JSONObject foodNutrient = (JSONObject) nestedObject.get(i);
                    System.out.println(foodNutrient.get("name") + " " + foodNutrient.get("amount") + foodNutrient.get("unitName"));
                    System.out.println();

                }



        } catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }



        return new Micros();
    }

     //FOR TESTING
    public static void main(String[] args) {
        USDAApi api = new USDAApi();
        api.searchForFoodById(2262074);
    }

}
