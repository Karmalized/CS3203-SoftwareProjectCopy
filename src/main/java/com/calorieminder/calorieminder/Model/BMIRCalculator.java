package com.calorieminder.calorieminder.Model;

public class BMIRCalculator {

    //input weight in kg and height in meters; returns BMI
    public static double calculateBMI(double weight, double height) {
        return ((weight * 703) / (height * height));
    }
    //USES MIFFLIN-ST JEOR EQUATION
    //calculates Basal Metabolic Rate for men
    public static double calculateBMRMen(double weight, double height, double age) {
        return (4.536 * weight) + (15.88 * height) - (5 * age) + 5;
    }

    //calculates Basal Metabolic Rate for women
    public static double calculateBMRWomen(double weight, double height, double age) {
        return (4.536 * weight) + (15.88 * height) - (5 * age) + 161;
    }


}
