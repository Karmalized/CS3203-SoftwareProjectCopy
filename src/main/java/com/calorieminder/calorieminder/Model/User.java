package com.calorieminder.calorieminder.Model;

//This class stores all relevant user data for the app (in the scope of 1 day)
public class User {
    //stores every micronutrient for the user
    private Micros micronutrientData;

    //stores an array containing Month, Day, Year of birthday
    private int[] Birthday = {1,1,1999};

    //weight of the user in pounds
    private double weight;

    //contains the sex of the user (either M or F)
    private char sex;

    //contains the activity level of the user from 1 to 5
    private int ActivityLevel;

    //calories that the user burns without moving
    private double BMR;

    //Body Mass Index of the User
    private double BMI;

    //Height in inches
    private double height;

    //Macronutrient intake of the User
    private double proteinGrams = 0;
    private double fatGrams = 0;
    private double  carbGrams = 0;

    //water intake of the user in milliliters
    private double waterML = 0;

    public void setMicronutrientData(Micros micronutrientData) {
        this.micronutrientData = micronutrientData;
    }
    public Micros getMicronutrientData() {
        return micronutrientData;
    }
    public void setBirthday(int[] birthday) {
        Birthday = birthday;
    }
    public int[] getBirthday() {
        return Birthday;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public double getProteinGrams() {
        return proteinGrams;
    }
    public void setProteinGrams(double proteinGrams) {
        this.proteinGrams = proteinGrams;
    }
    public double getFatGrams() {
        return fatGrams;
    }
    public void setFatGrams(double fatGrams) {
        this.fatGrams = fatGrams;
    }
    public double getCarbGrams() {
        return carbGrams;
    }
    public void setCarbGrams(double carbGrams) {
        this.carbGrams = carbGrams;
    }
    public double getWaterML() {
        return waterML;
    }
    public void setWaterML(double waterML) {
        this.waterML = waterML;
    }





}
