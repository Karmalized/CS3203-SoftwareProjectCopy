package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.Micros;
import com.calorieminder.calorieminder.Model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class microsFrame extends HelloController {
    //NUTRIENT TEXT VARIABLES
    @FXML
    private Text A;
    private double DailyA;
    @FXML
    private Text B1;
    private double DailyB1;
    @FXML
    private Text B2;
    private double DailyB2;
    @FXML
    private Text B3;
    private double DailyB3;
    @FXML
    private Text B5;
    private double DailyB5;
    @FXML
    private Text B6;
    private double DailyB6;
    @FXML
    private Text B9;
    private double DailyB9;
    @FXML
    private Text B12;
    private double DailyB12;
    @FXML
    private Text C;
    private double DailyC;
    @FXML
    private Text D;
    private double DailyD;
    @FXML
    private Text E;
    private double DailyE;
    @FXML
    private Text K;
    private double DailyK;
    @FXML
    private Text Calcium;
    private double DailyCalcium;
    @FXML
    private Text Phosphorus;
    private double DailyPhosphorus;
    @FXML
    private Text Magnesium;
    private double DailyMagnesium;
    @FXML
    private Text Iron;
    private double DailyIron;
    @FXML
    private Text Zinc;
    private double DailyZinc;
    @FXML
    private Text Copper;
    private double DailyCopper;
    @FXML
    private Text Potassium;
    private double DailyPotassium;
    @FXML
    private Text Sodium;
    private double DailySodium;

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }

    protected void updateInfo(User user){
        A.
    }
}
