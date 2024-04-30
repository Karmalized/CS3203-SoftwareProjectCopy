package com.calorieminder.calorieminder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;
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
    void onWeightSliderChange()
    {
        double weight = Weight_lbs.getValue();
        System.out.println(weight);
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
        ObservableList<String> activityOptions = FXCollections.observableArrayList("test1","test2");
        activity.setItems(activityOptions);
    }

    @FXML
    void addSex()
    {
        ObservableList<String> sexOptions = FXCollections.observableArrayList("Male", "Female");
        sex.setItems(sexOptions);
    }
    //Possible transition function to cater to all pages rather than make multiple methods for one
    //protected void transitionToPage (ActionEvent event, String fxmlLink) throws IO Exception {}
}
