package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.Micros;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class currentWeightFrame extends HelloController {

    @FXML
    private TextField weightInput;

    @FXML
    protected void onDone(ActionEvent event) throws IOException {
        double newWeight = Double.parseDouble(weightInput.getText());
        user.setWeight(newWeight);
        user.setWaterML(0);
        user.setProteinGrams(0);
        user.setCarbGrams(0);
        user.setFatGrams(0);
        Micros micros = new Micros();
        user.setMicronutrientData(micros);
        this.moveToMainPage(event);
    }

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }
}
