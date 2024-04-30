package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.USDAApi;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class foodSearchResultsFrame extends HelloController {

    @FXML
    private TextField weightInputFood;
    @FXML
    private ComboBox<String> SearchChoices;

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }

    @FXML
    protected void updateInfo(ActionEvent event) throws IOException {
        String choice = SearchChoices.getValue();
        double weight = Double.parseDouble(weightInputFood.getText());
        USDAApi usdaApi = new USDAApi();
        usdaApi.addFoodById(usdaApi.getFoodsIDByName(choice)[0],user,weight);
        moveToMainPage(event);
    }

    public void initialize() {
        for (int i = 0; i < searchResults.length; i++) {
            SearchChoices.getItems().add(searchResults[i]);
        }
    }
}
