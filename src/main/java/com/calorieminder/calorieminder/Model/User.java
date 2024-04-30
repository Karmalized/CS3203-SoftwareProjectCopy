package com.calorieminder.calorieminder.Model;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalDateTime.*;
import java.text.DateFormat;

//This class stores all relevant user data for the app (in the scope of 1 day)
public class User {
    //stores every micronutrient for the user
    private Micros micronutrientData;

    //stores an array containing Month, Day, Year of birthday
    private int[] Birthday = {1,1,1999};

    //weight of the user in pounds
    private double weight;

    //height of the user in inches
    private double height;

    //contains the sex of the user (either M or F)
    private char sex;

    //contains the activity level of the user from 1 to 5
    private int ActivityLevel;

    //calories that the user burns without moving
    private double BMR;

    //Body Mass Index of the User
    private double BMI;


    //Macronutrient intake of the User
    private double proteinGrams = 0;
    private double fatGrams = 0;
    private double  carbGrams = 0;

    //water intake of the user in milliliters
    private double waterML = 0;

    //Empty Constructor
    public User() {
        micronutrientData = new Micros();
        weight = 0;
        height = 0;
        sex = 'M';
        ActivityLevel = 1;
        BMR = 0;
        BMI = 0;
        proteinGrams = 0;
        carbGrams = 0;
        fatGrams = 0;
        waterML = 0;



    }

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
//NOTE: THIS GETTER WILL CONVERT BIRTHDAY INTO AN ACTUAL AGE AMOUNT FOR MANIPULATION FROM THE CALCULATORS
    public double getAge(){
        LocalDateTime currentSystemTime = LocalDateTime.now();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentSystemTime);
        int[] currentTime = new int[3];
        String[] currentTimeText = formattedDate.split("-");
        currentTime[0] = Integer.parseInt(currentTimeText[0]);
        currentTime[1] = Integer.parseInt(currentTimeText[1]);
        currentTime[2] = Integer.parseInt(currentTimeText[2]);
        int ageDays = ((currentTime[0]-Birthday[0]) * 365) + Math.abs((currentTime[1]-Birthday[1])* 30) + Math.abs((currentTime[2]-Birthday[2]));
        double ageYears = ageDays / 365;
        return ageYears;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }
    public void setHeight(double height) {this.height = height; }
    public double getHeight() { return height;}
    public int getActivityLevel() {return ActivityLevel;}
    public void setActivityLevel(int ActivityLevel) {this.ActivityLevel = ActivityLevel;}
    public void setSex(char sex) {this.sex = sex;}
    public char getSex() {return sex;}
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

    //this method adds the micros from a new micros object to the current user's total micros
    public void updateMicros(Micros micronutrientData) {
        this.micronutrientData.setVitaminA(this.micronutrientData.getVitaminA() + micronutrientData.getVitaminA());
        this.micronutrientData.setVitaminB1(this.micronutrientData.getVitaminB1() + micronutrientData.getVitaminB1());
        this.micronutrientData.setVitaminB2(this.micronutrientData.getVitaminB2() + micronutrientData.getVitaminB2());
        this.micronutrientData.setVitaminB3(this.micronutrientData.getVitaminB3() + micronutrientData.getVitaminB3());
        this.micronutrientData.setVitaminB5(this.micronutrientData.getVitaminB5() + micronutrientData.getVitaminB5());
        this.micronutrientData.setVitaminB6(this.micronutrientData.getVitaminB6() + micronutrientData.getVitaminB6());
        this.micronutrientData.setVitaminB9(this.micronutrientData.getVitaminB9() + micronutrientData.getVitaminB9());
        this.micronutrientData.setVitaminB12(this.micronutrientData.getVitaminB12() + micronutrientData.getVitaminB12());
        this.micronutrientData.setSodium(this.micronutrientData.getSodium() + micronutrientData.getSodium());
        this.micronutrientData.setVitaminC(this.micronutrientData.getVitaminC() + micronutrientData.getVitaminC());
        this.micronutrientData.setVitaminD(this.micronutrientData.getVitaminD() + micronutrientData.getVitaminD());
        this.micronutrientData.setVitaminE(this.micronutrientData.getVitaminE() + micronutrientData.getVitaminE());
        this.micronutrientData.setVitaminK(this.micronutrientData.getVitaminK() + micronutrientData.getVitaminK());
        this.micronutrientData.setCalcium(this.micronutrientData.getCalcium() + micronutrientData.getCalcium());
        this.micronutrientData.setPhosphorus(this.micronutrientData.getPhosphorus() + micronutrientData.getPhosphorus());
        this.micronutrientData.setMagnesium(this.micronutrientData.getMagnesium() + micronutrientData.getMagnesium());
        this.micronutrientData.setIron(this.micronutrientData.getIron() + micronutrientData.getIron());
        this.micronutrientData.setZinc(this.micronutrientData.getZinc() + micronutrientData.getZinc());
        this.micronutrientData.setCopper(this.micronutrientData.getCopper() + micronutrientData.getCopper());
        this.micronutrientData.setPotassium(this.micronutrientData.getPotassium() + micronutrientData.getPotassium());
    }

    //Prints all values for testing
    public void printAll()
    {
        System.out.println("Birthyear: " + Birthday[0]);
        System.out.println("Birthmonth: " + Birthday[1]);
        System.out.println("Birthday: " + Birthday[2]);
        System.out.println("Weight: " + weight);
        System.out.println("Height: " + height);
        System.out.println("Sex: " + sex);
        System.out.println("ActivityLevel: " + ActivityLevel);
        Micros.PrintAllMicros(micronutrientData);
        System.out.println("Protein: " + getProteinGrams());
        System.out.println("Carb: " + getCarbGrams());
        System.out.println("Fat: " + getFatGrams());
        System.out.println("Water Consumed: " + getWaterML());
    }



}
