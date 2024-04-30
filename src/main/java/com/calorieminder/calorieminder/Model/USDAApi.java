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

    //Gets every micronutrient & Macronutrient and updates User Info based on that data
    //This method adds the nutrition information for a specific food to a user object based on the FDIC ID
    public void addFoodById(int ID, User person, double weight) {


        StringBuilder nutrients = new StringBuilder();
        for (int nutrient : Arrays.asList((new Micros()).nutrientNumbers)) {
            nutrients.append(nutrient).append(",");
        }
        // remove the last comma
        nutrients = new StringBuilder(nutrients.substring(0, nutrients.length() - 1));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.nal.usda.gov/fdc/v1/food/" + ID + "?api_key=[INSERT_KEY]&nutrients=203,204,205," + nutrients + "&format=abridged"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response;

        Micros micros = new Micros();
        //JSON Return Parser
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //FOR TESTING
            //System.out.println(response.body());
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
            ;
            //FOR TESTING
            //System.out.println(jsonObject.get("foodNutrients"));

            JSONArray nestedObject = (JSONArray) jsonObject.get("foodNutrients");
            if (nestedObject != null) {
                for (int i = 0; i < nestedObject.size(); i++) {
                    JSONObject foodNutrient = (JSONObject) nestedObject.get(i);
                    int NutrientID = Integer.parseInt((foodNutrient.get("number").toString()));
                    //FOR TESTING
                    //System.out.println(foodNutrient.get("name") + " " + foodNutrient.get("amount") + foodNutrient.get("unitName") + " " + NutrientID);


                    if (micros.getNutrientMap().get(NutrientID) != null) {
                        //System.out.println(micros.getNutrientMap().get(NutrientID));
                        double amount = Double.parseDouble(foodNutrient.get("amount").toString());
                        Micros.addMicrosbyNutrientID(NutrientID, micros, amount * weight / 100.0);
                    }
                    //System.out.println();

                    switch(NutrientID) {
                        case 203:
                            person.setProteinGrams(person.getProteinGrams() + weight*Double.parseDouble(foodNutrient.get("amount").toString())/100.0);
                            break;
                        case 204:
                            person.setFatGrams(person.getFatGrams() + weight*Double.parseDouble(foodNutrient.get("amount").toString())/100.0);
                            break;
                        case 205:
                            person.setCarbGrams(person.getCarbGrams() + weight*Double.parseDouble(foodNutrient.get("amount").toString())/100.0);
                            break;
                    }


                }
            }
        }
        catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }
            person.updateMicros(micros);






        //THIS SECTION UPDATES MACRONUTRIENT DATA
        /*
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://api.nal.usda.gov/fdc/v1/food/" + ID + "?api_key=DEMO_KEY&nutrients=" + nutrients + "&format=abridged"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response2;
        try {
            response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());

        }
        catch (IOException | InterruptedException | ParseException e) {
            e.printStackTrace();
        }
        */

        return;
    }

    //Returns a JSON Object based on the search results for a food
    public JSONObject getFoodsJSONByName(String food) {
        //remove illegal characters from string
        food = food.replaceAll("[^a-zA-Z\\s]", "");
        food = food.replaceAll(" ","%20");
        HttpRequest request = HttpRequest.newBuilder()
                //  'https://api.nal.usda.gov/fdc/v1/foods/search?query=Cheddar%20Cheese&dataType=Foundation,SR%20Legacy&pageSize=5&pageNumber=1&api_key=DEMO_KEY' \
                .uri(URI.create("https://api.nal.usda.gov/fdc/v1/foods/search?query=" + food + "&dataType=Foundation,SR%20Legacy&pageSize=5&pageNumber=1&api_key=[INSERT_KEY]"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());
            //System.out.println("Total Hits: " + jsonObject.get("totalHits").toString());
            //System.out.println(response.body());
            return jsonObject;
        }
        catch (InterruptedException | IOException | ParseException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    //returns a string array containing the names of the first 5 search results for a string input
    public String[] getFoodsStringByName(String food) {
        JSONObject foodInformation = getFoodsJSONByName(food);
        //JSONObject -> foods (JSONArray) -> Description
        JSONArray foodsList = (JSONArray) foodInformation.get("foods");
        String[] foodNames = new String[foodsList.size()];

        //increment through foods list and add names of food to array of strings
        for (int i = 0; i < foodsList.size(); i++) {
            foodNames[i] = ((JSONObject)(foodsList.get(i))).get("description").toString();
        }
        return foodNames;
    }

    //returns an int list containing the FDIC IDs for the first 5 search results for a string input
    public int[] getFoodsIDByName(String food) {
        JSONObject foodInformation = getFoodsJSONByName(food);
        //JSONObject -> foods (JSONArray) -> fdcID
        JSONArray foodsList = (JSONArray) foodInformation.get("foods");
        int[] foodIDs = new int[foodsList.size()];
        for (int i = 0; i < foodsList.size(); i++) {
            foodIDs[i] = Integer.parseInt(((JSONObject)(foodsList.get(i))).get("fdcId").toString());
        }
        return foodIDs;
    }

     //FOR TESTING



    /*
    public static void main(String[] args) {
        USDAApi api = new USDAApi();
        User x = new User();
        api.addFoodById(1750342,x,100);
        api.addFoodById(2262074,x,100);

        x.printAll();
        }
    */


    }


