package com.calorieminder.calorieminder.Model;

public class DeficiencyCalculator {

    // Function to calculate the Total Daily Energy Expenditure (TDEE) based on activity level
    double calculateTDEE(double weightLbs, int feet, int inches, int age, char gender, int activityLevel) {
        double weightKg = weightLbs * 0.453592; // Convert weight from lbs to kg
        double heightCm = (feet * 12 + inches) * 2.54; // Convert height from feet and inches to cm

        double bmr = 0;
        if (gender == 'M' || gender == 'm') {
            bmr = 10 * weightKg + 6.25 * heightCm - 5 * age + 5;
        } else {
            bmr = 10 * weightKg + 6.25 * heightCm - 5 * age - 161;
        }
        double[] activityFactors = {1.2, 1.375, 1.55, 1.725, 1.9};
        return bmr * activityFactors[activityLevel - 1];
    }

    //TODO
    // Function to calculate the recommended caloric intake
    double calculateCalories(double tdee) {
        // For simplicity, let's assume the same calorie intake for all individuals
        // You can modify this function to include more complex calculations
        return tdee;
    }

    //TODO return these values
    // Function to calculate the recommended intake of macronutrients
    void calculateMacronutrients(double calories) {
        // Assuming macronutrient distribution percentages
        double carbPercentage = 50;  // 50% of total calories
        double proteinPercentage = 20; // 20% of total calories
        double fatPercentage = 30; // 30% of total calories

        // Convert percentages to grams
        double carbGrams = (carbPercentage / 100) * calories / 4;  // 4 calories per gram of carbohydrate
        double proteinGrams = (proteinPercentage / 100) * calories / 4; // 4 calories per gram of protein
        double fatGrams = (fatPercentage / 100) * calories / 9; // 9 calories per gram of fat

        // Display macronutrient recommendations
        System.out.println("\nRecommended intake of macronutrients:");
        System.out.println("- Carbohydrates: " + carbGrams + " grams");
        System.out.println("- Protein: " + proteinGrams + " grams");
        System.out.println("- Fat: " + fatGrams + " grams");
    }


}
