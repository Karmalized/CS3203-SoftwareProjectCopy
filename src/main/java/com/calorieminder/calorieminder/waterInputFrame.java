package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.Water;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class waterInputFrame extends HelloController {

    @FXML
    private ComboBox<String> unitSelector;

    @FXML
    private TextField waterBox;

    @FXML
    void addUnits()
    {
        ObservableList<String> unitOptions = FXCollections.observableArrayList("oz", "mL");
        unitSelector.setItems(unitOptions);
    }

    @FXML
    protected void onAddClick(ActionEvent event) throws IOException
    {
        String consumedString = waterBox.getText();
        float consumed = Float.parseFloat(consumedString);
        Water water = new Water();
        water.updateWaterConsumed(0,"mL");
        water.updateWaterConsumed(consumed, unitSelector.getValue());
        user.setWaterML(water.getWaterConsumed());
        this.moveToMainPage(event);

    }

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }
}
