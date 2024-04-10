#include <iostream>
using namespace std;

// Function to calculate BMI
double calculateBMI(double weight, double height) {
    double height_m = height / 100.0; // Convert height to meters
    return weight / (height_m * height_m);
}

// Function to calculate BMR for men
double calculateBMRMen(double weight, double height, int age) {
    return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
}

// Function to calculate BMR for women
double calculateBMRWomen(double weight, double height, int age) {
    return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
}

int main() {
    double weight_lb, height_ft, height_in;
    int age;
    char gender;
    int activityLevel;

    // Prompt user for input
    cout << "Enter your weight in pounds: ";
    cin >> weight_lb;

    cout << "Enter your height in feet and inches (e.g., 5 7 for 5 feet 7 inches): ";
    cin >> height_ft >> height_in;

    cout << "Enter your age in years: ";
    cin >> age;

    cout << "Enter your gender (M/F): ";
    cin >> gender;

    cout << "Enter your activity level (1-Sedentary, 2-Lightly active, 3-Moderately active, 4-Very active, 5-Extra active): ";
    cin >> activityLevel;

    double height_cm = (height_ft * 12 + height_in) * 2.54; // Convert height to centimeters
    double bmr;

    // Calculate BMI
    double bmi = calculateBMI(weight_lb, height_cm);
    cout << "Your Body Mass Index (BMI) is: " << bmi << endl;

    // Calculate BMR based on gender
    if (gender == 'M' || gender == 'm') {
        bmr = calculateBMRMen(weight_lb, height_cm, age);
        cout << "Your Basal Metabolic Rate (BMR) for men is: " << bmr << " calories per day." << endl;
    } else if (gender == 'F' || gender == 'f') {
        bmr = calculateBMRWomen(weight_lb, height_cm, age);
        cout << "Your Basal Metabolic Rate (BMR) for women is: " << bmr << " calories per day." << endl;
    } else {
        cout << "Invalid gender entered. Please enter 'M' or 'F'." << endl;
        return 1; // Return error code
    }

    // Adjust BMR based on activity level
    switch (activityLevel) {
        case 1:
            bmr *= 1.2; // Sedentary
            break;
        case 2:
            bmr *= 1.375; // Lightly active
            break;
        case 3:
            bmr *= 1.55; // Moderately active
            break;
        case 4:
            bmr *= 1.725; // Very active
            break;
        case 5:
            bmr *= 1.9; // Extra active
            break;
        default:
            cout << "Invalid activity level entered. Please enter a number from 1 to 5." << endl;
            return 1; // Return error code
    }

    cout << "Your Adjusted Basal Metabolic Rate (BMR) is: " << bmr << " calories per day." << endl;

    return 0;
}
