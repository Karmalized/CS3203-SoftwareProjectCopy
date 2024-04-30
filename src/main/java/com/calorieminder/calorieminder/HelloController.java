package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    User newUser = new User();

    //micronutrient labels
    @FXML
    private Label vitaminALabel, vitaminB1Label, vitaminB2Label, vitaminB3Label, vitaminB5Label, vitaminB6Label, vitaminB9Label, vitaminB12Label, vitaminCLabel, vitaminDLabel, vitaminELabel, vitaminKLabel, calciumLabel, phosphorusLabel, magnesiumLabel, ironLabel, zincLabel, copperLabel, potassiumLabel, sodiumLabel;

    //OUTDATED
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to CalorieMinder!");
    }

    //BUTTON TRANSITION FUNCTIONS
    @FXML
    protected void moveToMainPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("macrosFrame.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToMicrosPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("microsFrame.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToWaterPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("WaterInput.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToFoodPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("foodPage.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToIntroPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("CalorieMinderIntroPage.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToNewDayPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("Newday.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToWeightTrendPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("WeightTrend.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    @FXML
    protected void moveToFoodSearchResultsPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    // INTRO PAGE FUNCTIONS
    @FXML
    private Slider Weight_lbs;
    @FXML
    private Label weightLabel;

    @FXML
    void onWeightSliderChange()
    {
        double weight = Weight_lbs.getValue();
        double roundedWeight = Math.floor(weight * 100) / 100;
        String weightLabelString = Double.toString(roundedWeight);
        weightLabel.setText(weightLabelString);
    }

    @FXML
    private ComboBox<String> heightFt;
    @FXML
    private ComboBox<String> heightIn;
    @FXML
    private ComboBox<String> activity;
    @FXML
    private ComboBox<String> sex; //adds sex
    @FXML
    private DatePicker Birthday;

    @FXML
    void addFt()
    {
        ObservableList<String> ftOptions = FXCollections.observableArrayList("1","2","3","4","5","6","7");
        heightFt.setItems(ftOptions);
    }

    @FXML
    void addIn()
    {
        ObservableList<String> inOptions = FXCollections.observableArrayList("0","1","2","3","4","5","6","7","8","9","10","11");
        heightIn.setItems(inOptions);
    }

    @FXML
    void addActivities()
    {
        ObservableList<String> activityOptions = FXCollections.observableArrayList("1","2","3","4","5");
        activity.setItems(activityOptions);
    }

    @FXML
    void addSex()
    {
        ObservableList<String> sexOptions = FXCollections.observableArrayList("M", "F");
        sex.setItems(sexOptions);
    }

    @FXML
    void onIntroPageLeave(ActionEvent event) throws IOException {

        //Save data currently on intro page
        //Weight
        double weight = Weight_lbs.getValue();
        //Height
        String ftString = heightFt.getValue();
        int ft = Integer.parseInt(ftString);
        ft = ft * 12;
        String inString = heightIn.getValue();
        int in = Integer.parseInt(inString);
        double height = ft + in;

        //Birthday
        String birthday = String.valueOf(Birthday.getValue());
        String[] birthdayStringArray = birthday.split("-");
        int[] birthdayIntArray = new int[3];
        birthdayIntArray[0] = Integer.parseInt(birthdayStringArray[0]);
        birthdayIntArray[1] = Integer.parseInt(birthdayStringArray[1]);
        birthdayIntArray[2] = Integer.parseInt(birthdayStringArray[2]);

        //Activity
        String activityString = activity.getValue();
        int activityInt = Integer.parseInt(activityString);

        //Sex
        String sexString = sex.getValue();
        char sexChar = sexString.charAt(0);

        //Save everything to User class
        newUser.setWeight(weight);
        newUser.setHeight(height);
        newUser.setBirthday(birthdayIntArray);
        newUser.setActivityLevel(activityInt);
        newUser.setSex(sexChar);

        //Go to main page
        FXMLLoader main = new FXMLLoader(getClass().getResource("macrosFrame.fxml"));
        Scene scene = new Scene(main.load(), 600, 400);
        Stage currentWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    //Possible transition function to cater to all pages rather than make multiple methods for one
    //protected void transitionToPage (ActionEvent event, String fxmlLink) throws IO Exception {}
}
