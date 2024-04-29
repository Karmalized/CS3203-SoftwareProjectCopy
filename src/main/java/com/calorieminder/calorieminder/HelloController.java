package com.calorieminder.calorieminder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to CalorieMinder!");
    }

    @FXML
    protected void moveToMainPage(ActionEvent event) throws IOException {
        FXMLLoader main = new FXMLLoader(getClass().getResource("CalorieMinderIntroPage.fxml"));
        Scene scene = new Scene(main.load(), 320, 240);
        Stage currentWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        currentWindow.setScene(scene);
        currentWindow.show();
    }

    //Possible transition function to cater to all pages rather than make multiple methods for one
    //protected void transitionToPage (ActionEvent event) throws IO Exception {}
}
