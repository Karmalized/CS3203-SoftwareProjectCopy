package com.calorieminder.calorieminder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class microsFrame extends HelloController {
    @FXML
    private Text A;
    @FXML
    private Text B1;
    @FXML
    private Text B2;
    @FXML
    private Text B3;
    @FXML
    private Text B5;
    @FXML
    private Text B6;
    @FXML
    private Text B9;
    @FXML
    private Text B12;
    @FXML
    private Text C;
    @FXML
    private Text D;
    @FXML
    private Text E;
    @FXML
    private Text K;
    @FXML
    private Text Calcium;
    @FXML
    private Text Phosphorus;
    @FXML
    private Text Magnesium;
    @FXML
    private Text Iron;
    @FXML
    private Text Zinc;
    @FXML
    private Text Copper;
    @FXML
    private Text Potassium;
    @FXML
    private Text Sodium;

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }


}
