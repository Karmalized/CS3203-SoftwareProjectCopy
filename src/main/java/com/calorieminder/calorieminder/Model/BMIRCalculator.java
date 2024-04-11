package com.calorieminder.calorieminder.Model;

public class BMIRCalculator {

    //input weight in kg and height in meters; returns BMI
    double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    //calculates Basal Metabolic Rate for men
    double calculateBMRMen(double weight, double height, int age) {
        return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    }

    //calculates Basal Metabolic Rate for women
    double calculateBMRWomen(double weight, double height, int age) {
        return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }


}
