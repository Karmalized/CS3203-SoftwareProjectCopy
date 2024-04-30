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
        Micros currentIntake = user.getMicronutrientData(); //This Micros section references the current cumulative micronutrient intake of the individual (IT WILL BE COMPARED TO THE RECOMMENDED DAILY INTAKE)
        String[] Alist = A.getText().split(":");
        String[] B1list = B1.getText().split(":");
        String[] B2list = B2.getText().split(":");
        String[] B3list = B3.getText().split(":");
        String[] B5list = B5.getText().split(":");
        String[] B6list = B6.getText().split(":");
        String[] B9list = B9.getText().split(":");
        String[] B12list = B12.getText().split(":");
        String[] Clist = C.getText().split(":");
        String[] Dlist = D.getText().split(":");
        String[] Elist = E.getText().split(":");
        String[] Klist = K.getText().split(":");
        String[] Calciumlist = Calcium.getText().split(":");
        String[] Phosphoruslist = Phosphorus.getText().split(":");
        String[] Magnesiumlist = Magnesium.getText().split(":");
        String[] Ironlist = Iron.getText().split(":");
        String[] Zinclist = Zinc.getText().split(":");
        String[] Copperlist = Copper.getText().split(":");
        String[] Potassiumlist = Potassium.getText().split(":");
        String[] Sodiumlist = Sodium.getText().split(":");

        double ARatio = (currentIntake.getVitaminA()/currentIntake.DailyGoal().get("vitaminA")) * 100;
        double B1Ratio = (currentIntake.getVitaminB1()/currentIntake.DailyGoal().get("vitaminB1")) * 100;
        double B2Ratio = (currentIntake.getVitaminB2()/currentIntake.DailyGoal().get("vitaminB2")) * 100;
        double B3Ratio = (currentIntake.getVitaminB3()/currentIntake.DailyGoal().get("vitaminB3")) * 100;
        double B5Ratio = (currentIntake.getVitaminB5()/currentIntake.DailyGoal().get("vitaminB5")) * 100;
        double B6Ratio = (currentIntake.getVitaminB6()/currentIntake.DailyGoal().get("vitaminB6")) * 100;
        double B9Ratio = (currentIntake.getVitaminB9()/currentIntake.DailyGoal().get("vitaminB9")) * 100;
        double B12Ratio = (currentIntake.getVitaminB12()/currentIntake.DailyGoal().get("vitaminB12")) * 100;
        double CRatio = (currentIntake.getVitaminC()/currentIntake.DailyGoal().get("vitaminC")) * 100;
        double DRatio = (currentIntake.getVitaminD()/currentIntake.DailyGoal().get("vitaminD")) * 100;
        double ERatio = (currentIntake.getVitaminE()/currentIntake.DailyGoal().get("vitaminE")) * 100;
        double KRatio = (currentIntake.getVitaminK()/currentIntake.DailyGoal().get("vitaminK")) * 100;
        double CalciumRatio = (currentIntake.getCalcium()/currentIntake.DailyGoal().get("Calcium")) * 100;
        double PhosphorusRatio = (currentIntake.getPhosphorus()/currentIntake.DailyGoal().get("Phosphorus")) * 100;
        double MagnesiumRatio = (currentIntake.getMagnesium()/currentIntake.DailyGoal().get("Magnesium")) * 100;
        double IronRatio = (currentIntake.getIron()/currentIntake.DailyGoal().get("Iron")) * 100;
        double ZincRatio = (currentIntake.getZinc()/currentIntake.DailyGoal().get("Zinc")) * 100;
        double CopperRatio = (currentIntake.getCopper()/currentIntake.DailyGoal().get("Copper")) * 100;
        double PotassiumRatio = (currentIntake.getPotassium()/currentIntake.DailyGoal().get("Potassium")) * 100;
        double SodiumRatio = (currentIntake.getSodium()/currentIntake.DailyGoal().get("Sodium")) * 100;

        A.setText(Alist[0] + ": " + currentIntake.getVitaminA() +  ", Percent Daily: " + ARatio + "%");
        B1.setText(B1list[0] + ": " + currentIntake.getVitaminB1() +  ", Percent Daily: " + B1Ratio + "%");
        B2.setText(B2list[0] + ": " + currentIntake.getVitaminB2() +  ", Percent Daily: " + B2Ratio + "%");
        B3.setText(B3list[0] + ": " + currentIntake.getVitaminB3() +  ", Percent Daily: " + B3Ratio + "%");
        B5.setText(B5list[0] + ": " + currentIntake.getVitaminB5() +  ", Percent Daily: " + B5Ratio + "%");
        B6.setText(B6list[0] + ": " + currentIntake.getVitaminB6() +  ", Percent Daily: " + B6Ratio + "%");
        B9.setText(B9list[0] + ": " + currentIntake.getVitaminB9() +  ", Percent Daily: " + B9Ratio + "%");
        B12.setText(B12list[0] + ": " + currentIntake.getVitaminB12() +  ", Percent Daily: " + B12Ratio + "%");
        C.setText(Clist[0] + ": " + currentIntake.getVitaminC() +  ", Percent Daily: " + CRatio + "%");
        D.setText(Dlist[0] + ": " + currentIntake.getVitaminD() +  ", Percent Daily: " + DRatio + "%");
        E.setText(Elist[0] + ": " + currentIntake.getVitaminE() +  ", Percent Daily: " + ERatio + "%");
        K.setText(Klist[0] + ": " + currentIntake.getVitaminK() +  ", Percent Daily: " + KRatio + "%");
        Calcium.setText(Calciumlist[0] + ": " + currentIntake.getCalcium() + ", Percent Daily: " + CalciumRatio + "%");
        Phosphorus.setText(Phosphoruslist[0] + ": " + currentIntake.getPhosphorus() +  ", Percent Daily: " + PhosphorusRatio + "%");
        Magnesium.setText(Magnesiumlist[0] + ": " + currentIntake.getMagnesium() +  ", Percent Daily: " + MagnesiumRatio + "%");
        Iron.setText(Ironlist[0] + ": " + currentIntake.getIron() +  ", Percent Daily: " + IronRatio + "%");
        Zinc.setText(Zinclist[0] + ": " + currentIntake.getZinc() +  ", Percent Daily: " + ZincRatio + "%");
        Copper.setText(Copperlist[0] + ": " + currentIntake.getCopper() +  ", Percent Daily: " + CopperRatio + "%");
        Potassium.setText(Potassiumlist[0] + ": " + currentIntake.getPotassium() + ", Percent Daily: " + PotassiumRatio + "%");
        Sodium.setText(Sodiumlist[0] + ": " + currentIntake.getSodium() +  ", Percent Daily: " + SodiumRatio + "%");
    }
}
