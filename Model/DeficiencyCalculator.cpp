#include <iostream>
#include <cmath>

using namespace std;

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
    double activityFactors[] = {1.2, 1.375, 1.55, 1.725, 1.9};
    return bmr * activityFactors[activityLevel - 1];
}

// Function to calculate the recommended caloric intake
double calculateCalories(double tdee) {
    // For simplicity, let's assume the same calorie intake for all individuals
    // You can modify this function to include more complex calculations
    return tdee;
}

// Function to calculate the recommended intake of micronutrients
void calculateMicronutrients(double calories) {
    // Recommended intake of vitamins
    cout << "Recommended intake of vitamins:\n";
    cout << "- Vitamin A: 900 µg\n";
    cout << "- Vitamin B1 (Thiamine): 1.2 mg\n";
    cout << "- Vitamin B2 (Riboflavin): 1.3 mg\n";
    cout << "- Vitamin B3 (Niacin): 16 mg\n";
    cout << "- Vitamin B5 (Pantothenic Acid): 5 mg\n";
    cout << "- Vitamin B6: 1.7 mg\n";
    cout << "- Vitamin B7 (Biotin): 30 µg\n";
    cout << "- Vitamin B9 (Folate): 400 µg\n";
    cout << "- Vitamin B12: 2.4 µg\n";
    cout << "- Vitamin C: 90 mg\n";
    cout << "- Vitamin D: 15 µg\n";
    cout << "- Vitamin E: 15 mg\n";
    cout << "- Vitamin K: 120 µg\n";
    cout << "- Choline: 550 mg\n";
    cout << "- Vitamin K: 120 µg\n";

    // Recommended intake of minerals
    cout << "\nRecommended intake of minerals:\n";
    cout << "- Calcium: 1000 mg\n";
    cout << "- Phosphorus: 700 mg\n";
    cout << "- Magnesium: 400 mg\n";
    cout << "- Iron: 8 mg\n";
    cout << "- Zinc: 11 mg\n";
    cout << "- Copper: 900 µg\n";
    cout << "- Manganese: 2.3 mg\n";
    cout << "- Selenium: 55 µg\n";
    cout << "- Chromium: 35 µg\n";
    cout << "- Molybdenum: 45 µg\n";
    cout << "- Iodine: 150 µg\n";
    cout << "- Potassium: 4700 mg\n";
    cout << "- Sodium: 1500 mg\n";
    cout << "- Chloride: 2300 mg\n";
    cout << "- Fluoride: 3.4 mg\n";

    // Recommended intake of non-essential minerals
    cout << "\nRecommended intake of non-essential minerals:\n";
    cout << "- Silicon: 20-50 mg\n";
    cout << "- Boron: 1-13 mg\n";
    cout << "- Vanadium: 10-20 µg\n";
    cout << "- Nickel: 0.3-0.5 mg\n";
    cout << "- Cobalt: 5 µg\n";
    cout << "- Aluminum: 0.6-10 mg\n";
}

int main() {
    int age, feet, inches, activityLevel;
    double weightLbs;
    char gender;

    cout << "Welcome to the CalorieMinder DRI Calculator\n";
    cout << "Please enter your age: ";
    cin >> age;

    cout << "Please enter your weight (in lbs): ";
    cin >> weightLbs;

    cout << "Please enter your height - feet: ";
    cin >> feet;

    cout << "Please enter your height - inches: ";
    cin >> inches;

    cout << "Please enter your gender (M/F): ";
    cin >> gender;

    cout << "Please enter your activity level (1 for sedentary, 2 for lightly active, 3 for moderately active, 4 for very active, and 5 for extra active): ";
    cin >> activityLevel;

    double tdee = calculateTDEE(weightLbs, feet, inches, age, gender, activityLevel);
    double calories = calculateCalories(tdee);

    cout << "\nYour Total Daily Energy Expenditure (TDEE) is: " << tdee << " calories/day" << endl;

    calculateMicronutrients(calories);

    return 0;
}

