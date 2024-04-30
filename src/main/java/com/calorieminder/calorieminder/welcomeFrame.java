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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

public class  welcomeFrame extends HelloController {
    @FXML
    public Text ErrorIntro;
    private DeficiencyCalculator deficiencyCalculator;

    // INTRO PAGE FUNCTIONS
    @FXML
    private Slider Weight_lbs;
    @FXML
    private Label weightLabel;

    @FXML
    void onWeightSliderChange()
    {
        DecimalFormat df = new DecimalFormat("#.##");
        double weight = Weight_lbs.getValue();
        weightLabel.setText(df.format(weight));
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
        try {

            //Save data currently on intro page
            //Weight
            user.setWeight(Weight_lbs.getValue());
            //Height
            String ftString = heightFt.getValue();
            String inString = heightIn.getValue();
            int ft = Integer.parseInt(ftString);
            ft = ft * 12;
            int in = Integer.parseInt(inString);
            double height = ft + in;
            user.setHeight(height);


            //Birthday
            String birthday = String.valueOf(Birthday.getValue());
            String[] birthdayStringArray = birthday.split("-");
            int[] birthdayIntArray = new int[3];
            birthdayIntArray[0] = Integer.parseInt(birthdayStringArray[0]);
            birthdayIntArray[1] = Integer.parseInt(birthdayStringArray[1]);
            birthdayIntArray[2] = Integer.parseInt(birthdayStringArray[2]);
            user.setBirthday(birthdayIntArray);

            //Activity
            String activityString = activity.getValue();
            int activityInt = Integer.parseInt(activityString);
            user.setActivityLevel(activityInt);

            //Sex
            String sexString = sex.getValue();
            char sexChar = sexString.charAt(0);
            user.setSex(sexChar);

            moveToMainPage(event);
        }
        catch (Exception e) {
            ErrorIntro.setFill(Color.RED);
            ErrorIntro.setText("INPUT ERROR");
        }
        //For Testing
        /*
        System.out.println("Weight " + user.getWeight());
        System.out.println("Sex " + user.getSex());
        System.out.println("Height " + user.getHeight());
        System.out.println("Birthday " + Arrays.toString(user.getBirthday()));
        System.out.println("ActivityLevel " + user.getActivityLevel());
        */

    }

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        macrosFrame newFrame = new macrosFrame();
        super.moveToMainPage(event);
    }
}
