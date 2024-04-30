package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class macrosFrame extends HelloController {
    //ONPAGE VARIABLES
    @FXML
    private Text Protein;
    @FXML
    private Text Carbs;
    @FXML
    private Text Fat;
    @FXML
    private Text BMI;
    @FXML
    private Text BMR;
    @FXML
    private Text WaterLeft;

    //SUPERCLASS CALLS FOR TRANSITION PAGES (BUTTONS)
    @Override
    protected void moveToWaterPage(ActionEvent event) throws IOException {
        super.moveToWaterPage(event);
    }

    @Override
    protected void moveToMicrosPage(ActionEvent event) throws IOException {
        super.moveToMicrosPage(event);
    }

    @Override
    protected void moveToNewDayPage(ActionEvent event) throws IOException {
        super.moveToNewDayPage(event);
    }

    @Override
    protected void moveToFoodPage(ActionEvent event) throws IOException {
        super.moveToFoodPage(event);
    }

    @Override
    protected void moveToWeightTrendPage(ActionEvent event) throws IOException {
        super.moveToWeightTrendPage(event);
    }

    private void loadInfo(User user){
        //TAKE ALL TEXTS AND OBTAIN STRINGS FROM THEM
        String P = Protein.getText();
        String C = Carbs.getText();
        String F = Fat.getText();
        String BI = BMI.getText();
        String BR = BMR.getText();
        String WATER = WaterLeft.getText();

        String[] Pparse = P.split(":");
        String[] Cparse = C.split(":");
        String[] Fparse = F.split(":");
        String[] BIparse = BI.split(":");
        String[] BRparse = BR.split(":");
        String[] WATERparse = WATER.split(":");

        double storeProteins;
        double storeCarbs;
        double storeFats;
        double storeBMI;
        double storeBMR;
        double storeWaterLeft;

        if(!Pparse[1].isEmpty()){
            double proteins = Double.parseDouble(Pparse[1]);
            storeProteins = proteins + user.getProteinGrams();
        } else {
            storeProteins = user.getProteinGrams();
        }

        if(!Cparse[1].isEmpty()){
            double carbs = Double.parseDouble(Cparse[1]);
            storeCarbs = carbs + user.getCarbGrams();
        } else {
            storeCarbs = user.getCarbGrams();
        }

        if(!Fparse[1].isEmpty()){
            double fats = Double.parseDouble(Fparse[1]);
            storeFats = fats + user.getFatGrams();
        } else {
            storeFats = user.getFatGrams();
        }

        if(!BIparse[1].isEmpty()){
            double bmi = Double.parseDouble(BIparse[1]);
            //storeBMI = bmi + *Get BMI Calculation Function*;


        if(!BRparse[1].isEmpty()){
            double bmrs = Double.parseDouble(BRparse[1]);
            //storeBMI = bmi + *Get BMR Calculation Function*;
        }

        if(!WATERparse[1].isEmpty()){
            double waterLeft = Double.parseDouble(WATERparse[1]);
            storeWaterLeft = waterLeft + user.getWaterML();
        } else {
            storeWaterLeft = user.getWaterML();
        }

        Protein.setText(Pparse[0] + ": " + storeProteins);
        Carbs.setText(Cparse[0] + ": " + storeCarbs);
        Fat.setText(Fparse[0] + ": " + storeFats);
        BMI.setText(BIparse[0] + ": " + storeBMI);
        BMR.setText(BRparse[0] + ": " + storeBMR);
        WaterLeft.setText(WATERparse[0] + ": " + storeWaterLeft);
    }
}
