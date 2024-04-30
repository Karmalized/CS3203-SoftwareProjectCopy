package com.calorieminder.calorieminder;

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
        this.moveToMainPage(event);
    }

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }
}
