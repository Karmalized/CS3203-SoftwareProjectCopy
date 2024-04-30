package com.calorieminder.calorieminder;

import com.calorieminder.calorieminder.Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class microsFrame extends HelloController {
    //NUTRIENT TEXT VARIABLES
    @FXML
     private Label vitaminALabel;
    @FXML
     private Label vitaminB1Label;
    @FXML
     private Label vitaminB2Label ;
    @FXML
     private Label vitaminB3Label;
    @FXML
     private Label vitaminB5Label  ;
    @FXML
     private Label vitaminB6Label  ;
    @FXML
     private Label vitaminB9Label  ;
    @FXML
     private Label vitaminB12Label  ;
    @FXML
     private Label vitaminCLabel;
    @FXML
     private Label vitaminDLabel  ;
    @FXML
     private Label vitaminELabel  ;
    @FXML
     private Label vitaminKLabel  ;
    @FXML
     private Label calciumLabel  ;
    @FXML
     private Label phosphorusLabel  ;
    @FXML
     private Label magnesiumLabel  ;
    @FXML
     private Label ironLabel ;
    @FXML
     private Label zincLabel ;
    @FXML
     private Label copperLabel;
    @FXML
     private Label potassiumLabel ;
    @FXML
     private Label sodiumLabel ;

    @Override //SUPERCLASS CALL FOR TRANSITIONS
    protected void moveToMainPage(ActionEvent event) throws IOException {
        super.moveToMainPage(event);
    }

    @FXML
     private void initialize() {
        DecimalFormat df = new DecimalFormat("#.##");
        double ARatio = (user.getMicronutrientData().getVitaminA()/user.getMicronutrientData().getDailyGoal().get("vitaminA")) * 100;
        double B1Ratio = (user.getMicronutrientData().getVitaminB1()/user.getMicronutrientData().getDailyGoal().get("vitaminB1")) * 100;
        double B2Ratio = (user.getMicronutrientData().getVitaminB2()/user.getMicronutrientData().getDailyGoal().get("vitaminB2")) * 100;
        double B3Ratio = (user.getMicronutrientData().getVitaminB3()/user.getMicronutrientData().getDailyGoal().get("vitaminB3")) * 100;
        double B5Ratio = (user.getMicronutrientData().getVitaminB5()/user.getMicronutrientData().getDailyGoal().get("vitaminB5")) * 100;
        double B6Ratio = (user.getMicronutrientData().getVitaminB6()/user.getMicronutrientData().getDailyGoal().get("vitaminB6")) * 100;
        double B9Ratio = (user.getMicronutrientData().getVitaminB9()/user.getMicronutrientData().getDailyGoal().get("vitaminB9")) * 100;
        double B12Ratio = (user.getMicronutrientData().getVitaminB12()/user.getMicronutrientData().getDailyGoal().get("vitaminB12")) * 100;
        double CRatio = (user.getMicronutrientData().getVitaminC()/user.getMicronutrientData().getDailyGoal().get("vitaminC")) * 100;
        double DRatio = (user.getMicronutrientData().getVitaminD()/user.getMicronutrientData().getDailyGoal().get("vitaminD")) * 100;
        double ERatio = (user.getMicronutrientData().getVitaminE()/user.getMicronutrientData().getDailyGoal().get("vitaminE")) * 100;
        double KRatio = (user.getMicronutrientData().getVitaminK()/user.getMicronutrientData().getDailyGoal().get("vitaminK")) * 100;
        double CalciumRatio = (user.getMicronutrientData().getCalcium()/user.getMicronutrientData().getDailyGoal().get("calcium")) * 100;
        double PhosphorusRatio = (user.getMicronutrientData().getPhosphorus()/user.getMicronutrientData().getDailyGoal().get("phosphorus")) * 100;
        double MagnesiumRatio = (user.getMicronutrientData().getMagnesium()/user.getMicronutrientData().getDailyGoal().get("magnesium")) * 100;
        double IronRatio = (user.getMicronutrientData().getIron()/user.getMicronutrientData().getDailyGoal().get("iron")) * 100;
        double ZincRatio = (user.getMicronutrientData().getZinc()/user.getMicronutrientData().getDailyGoal().get("zinc")) * 100;
        double CopperRatio = (user.getMicronutrientData().getCopper()/user.getMicronutrientData().getDailyGoal().get("copper")) * 100;
        double PotassiumRatio = (user.getMicronutrientData().getPotassium()/user.getMicronutrientData().getDailyGoal().get("potassium")) * 100;
        double SodiumRatio = (user.getMicronutrientData().getSodium()/user.getMicronutrientData().getDailyGoal().get("sodium")) * 100;

        vitaminALabel.setText(" " + df.format(ARatio) + "% Daily Value");
        vitaminB1Label.setText(" " + df.format(B1Ratio) + "% Daily Value");
        vitaminB2Label.setText(" " + df.format(B2Ratio) + "% Daily Value");
        vitaminB3Label.setText(" " + df.format(B3Ratio) + "% Daily Value");
        vitaminB5Label.setText(" " + df.format(B5Ratio) + "% Daily Value");
        vitaminB6Label.setText(" " + df.format(B6Ratio) + "% Daily Value");
        vitaminB9Label.setText(" " + df.format(B9Ratio) + "% Daily Value");
        vitaminB12Label.setText(" " + df.format(B12Ratio) + "% Daily Value");
        vitaminCLabel.setText(" " + df.format(CRatio) + "% Daily Value");
        vitaminDLabel.setText(" " + df.format(DRatio) + "% Daily Value");
        vitaminELabel.setText(" " + df.format(ERatio) + "% Daily Value");
        vitaminKLabel.setText(" " + df.format(KRatio) + "% Daily Value");
        calciumLabel.setText(" " + df.format(CalciumRatio) + "% Daily Value");
        phosphorusLabel.setText(" " + df.format(PhosphorusRatio) + "% Daily Value");
        magnesiumLabel.setText(" " + df.format(MagnesiumRatio) + "% Daily Value");
        ironLabel.setText(" " + df.format(IronRatio) + "% Daily Value");
        zincLabel.setText(" " + df.format(ZincRatio) + "% Daily Value");
        copperLabel.setText(" " + df.format(CopperRatio) + "% Daily Value");
        potassiumLabel.setText(" " + df.format(PotassiumRatio) + "% Daily Value");
        sodiumLabel.setText(" " + df.format(SodiumRatio) + "% Daily Value");
     }


}
