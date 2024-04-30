package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.DeficiencyCalculator;
import com.calorieminder.calorieminder.Model.User;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.io.IOException;

public class  welcomeFrame extends HelloController {
    private User user;
    private DeficiencyCalculator deficiencyCalculator;

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
        User newUser = new User();
        newUser.setWeight(weight);
        newUser.setHeight(height);
        newUser.setBirthday(birthdayIntArray);
        newUser.setActivityLevel(activityInt);
        newUser.setSex(sexChar);

        DeficiencyCalculator newUserCalc = new DeficiencyCalculator();
        newUserCalc.calculateTDEE(newUser.getWeight(), newUser.getHeight(), /*newUser.getBirthday() == NEEDS CONVERSION*/, newUser.getSex(), newUser.getActivityLevel());
    }

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        macrosFrame newFrame = new macrosFrame();
        newFrame.addInfo(user, deficiencyCalculator);
        super.moveToMainPage(event);
    }
}
