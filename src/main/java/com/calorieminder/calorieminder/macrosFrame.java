package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.BMIRCalculator;
import com.calorieminder.calorieminder.Model.DeficiencyCalculator;
import com.calorieminder.calorieminder.Model.User;
import com.calorieminder.calorieminder.Model.Water;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class macrosFrame extends HelloController {
    private DeficiencyCalculator deficiencyCalculator;

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
    private Text WaterNeeded;

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
    @FXML
    private void initialize() {
        Protein.setText("Protein: " + user.getProteinGrams() + " g");
        Carbs.setText("Carbs: " + user.getCarbGrams() + " g");
        Fat.setText("Fat: " + user.getFatGrams() + " g");
        BMI.setText("BMI: " + String.format("%.2f", BMIRCalculator.calculateBMI(user.getWeight(), user.getHeight())));
        if (user.getSex() == 'M' || user.getSex() == 'm') {
            BMR.setText("BMR: " + BMIRCalculator.calculateBMRMen(user.getWeight(), user.getHeight(), user.getAge()));
        } else {
            BMR.setText("BMR: " + BMIRCalculator.calculateBMRWomen(user.getWeight(), user.getHeight(), user.getAge()));
        }
        WaterNeeded.setText("Water RDI: " + Water.waterPerDayCalc((float) Water.getWeight(), (int) Water.getActivityLevel()) + " ml");
    }


/*
    public void presetBMIR(User user){
        // Calculate BMI using BMIRCalculator
        BMIRCalculator bmirCalculator = new BMIRCalculator();
        String bmi = BMI.getText();
        String bmr = BMR.getText();
        BMI.setText(bmi + bmirCalculator.calculateBMI(user.getWeight(), user.getHeight()));
        System.out.println(bmi + bmirCalculator.calculateBMI(user.getWeight(), user.getHeight()));
        // Calculate BMR using BMIRCalculator
         if (user.getSex() == 'M' || user.getSex() == 'm') {
             BMR.setText(bmr + bmirCalculator.calculateBMRMen(user.getWeight(), user.getHeight(), user.getAge()));
          } else {
             BMR.setText(bmr + bmirCalculator.calculateBMRWomen(user.getWeight(), user.getHeight(), user.getAge()));
         }
    }



    //NOTE: USER CLASS IN THIS FUNCTION TBD (Probably going to be replaced with a Macros File)
    //THIS CLASS WILL BE USED IN TANDEM WHEN THE ADD BUTTON FUNCTION IS IMPLEMENTED
    public void addInfo(User user, DeficiencyCalculator deficiencyCalculator){
        this.user = user;
        this.deficiencyCalculator = deficiencyCalculator;
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

        // Calculate BMI using BMIRCalculator
        //BMIRCalculator bmirCalculator = new BMIRCalculator();
       // storeBMI = bmirCalculator.calculateBMI(user.getWeight(), user.getHeight());

        // Calculate BMR using BMIRCalculator
       // if (user.getSex() == 'M' || user.getSex() == 'm') {
       //     storeBMR = bmirCalculator.calculateBMRMen(user.getWeight(), user.getHeight(), user.getAge());
      //  } else {
       //     storeBMR = bmirCalculator.calculateBMRWomen(user.getWeight(), user.getHeight(), user.getAge());
       // }

        if(!WATERparse[1].isEmpty()){
            double waterLeft = Double.parseDouble(WATERparse[1]);
            storeWaterLeft = waterLeft + user.getWaterML();
        } else {
            storeWaterLeft = user.getWaterML();
        }
        double proteinPercent = (storeProteins/deficiencyCalculator.getProteins()) * 100;
        Protein.setText(Pparse[0] + ": " + storeProteins + "out of: " + deficiencyCalculator.getProteins() + " (" + storeProteins + "|" + deficiencyCalculator.getProteins() + ")" + "Percentage Reached: " + proteinPercent + "%");
        double carbsPercent = (storeCarbs/deficiencyCalculator.getCarbs()) * 100;
        Carbs.setText(Cparse[0] + ": " + storeCarbs + "out of: " + deficiencyCalculator.getCarbs() + " (" + storeCarbs + "|" + deficiencyCalculator.getCarbs() + ")" + "Percentage Reached: " + carbsPercent + "%");
        double fatPercent = (storeFats/deficiencyCalculator.getFats()) * 100;
        Fat.setText(Fparse[0] + ": " + storeFats + "out of: " + deficiencyCalculator.getFats() + " (" + storeFats + "|" + deficiencyCalculator.getFats() + ")" + "Percentage Reached: " + fatPercent + "%");
        BMI.setText(BIparse[0] + ": ");
        BMR.setText(BRparse[0] + ": ");
        WaterLeft.setText(WATERparse[0] + ": " + storeWaterLeft);
    }
    */
}

