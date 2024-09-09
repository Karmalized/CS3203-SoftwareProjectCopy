package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.Micros;
import com.calorieminder.calorieminder.Model.User;
import com.opencsv.CSVWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        User user = new User();
        File newFile = new File("UserData.csv");
       // if(!newFile.exists()) {
            System.out.println(newFile.createNewFile());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CalorieMinderIntroPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 725);
            stage.setTitle("Welcome!");
            stage.setScene(scene);
            stage.setMinHeight(500);
            stage.setMinWidth(725);
            stage.setMaxHeight(500);
            stage.setMaxWidth(725);
            stage.show();
            welcomeFrame start = fxmlLoader.getController();
            start.addFt();
            start.addIn();
            start.addActivities();
            start.addSex(); //adds sex
        //} else {
            //Scanner fileScanner = new Scanner(newFile);
        //}
            // Set the close request handler
        stage.setOnCloseRequest(windowEvent -> {
            Micros writeMicros = user.getMicronutrientData();
            ArrayList<Double> microAmounts = new ArrayList<>();
            microAmounts.add(writeMicros.getVitaminA());
            microAmounts.add(writeMicros.getVitaminB1());
            microAmounts.add(writeMicros.getVitaminB2());
            microAmounts.add(writeMicros.getVitaminB3());
            microAmounts.add(writeMicros.getVitaminB5());
            microAmounts.add(writeMicros.getVitaminB6());
            microAmounts.add(writeMicros.getVitaminB9());
            microAmounts.add(writeMicros.getVitaminB12());
            microAmounts.add(writeMicros.getVitaminC());
            microAmounts.add(writeMicros.getVitaminD());
            microAmounts.add(writeMicros.getVitaminE());
            microAmounts.add(writeMicros.getVitaminK());
            microAmounts.add(writeMicros.getCalcium());
            microAmounts.add(writeMicros.getPhosphorus());
            microAmounts.add(writeMicros.getMagnesium());
            microAmounts.add(writeMicros.getIron());
            microAmounts.add(writeMicros.getZinc());
            microAmounts.add(writeMicros.getCopper());
            microAmounts.add(writeMicros.getPotassium());
            microAmounts.add(writeMicros.getSodium());
            ArrayList<Object> UserData = new ArrayList<>();
            UserData.add(microAmounts);
            ArrayList<Integer> birthdayArray = new ArrayList<>();
            for(int time : user.getBirthday()){
                birthdayArray.add(time);
            }
            UserData.add(birthdayArray);
            UserData.add(user.getWeight());
            UserData.add(user.getWeightList());
            UserData.add(user.getHeight());
            UserData.add(user.getSex());
            UserData.add(user.getActivityLevel());
            UserData.add(user.getBMR());
            UserData.add(user.getBMI());
            UserData.add(user.getAge());
            UserData.add(user.getProteinGrams());
            UserData.add(user.getFatGrams());
            UserData.add(user.getCarbGrams());
            UserData.add(user.getWaterML());

            try {
                FileWriter outputfile = new FileWriter(newFile);
                CSVWriter writer = new CSVWriter(outputfile);
                String[] array = UserData.toArray(new String[0]);
            } catch(Exception e){
                System.out.println("couldn't write to File!");
            }

            System.out.println("Closing main page...");
        });
    }

    @Override
    public void stop() throws Exception {
        BufferedOutputStream outFile = new BufferedOutputStream(new FileOutputStream(new File("UserData.csv")));

    }

    public static void main(String[] args) {
        launch();
    }
}