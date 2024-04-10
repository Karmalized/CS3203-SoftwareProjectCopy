Men: BMR = 88.362 + (13.397 x weight in kg) + (4.799 x height in cm) – (5.677 x age in years)
Women: BMR = 447.593 + (9.247 x weight in kg) + (3.098 x height in cm) – (4.330 x age in years)

#include <iostream>
using namespace std;

// Function to calculate BMR for men
double calculateBMRMen(double weight, double height, int age) {
    return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
}

// Function to calculate BMR for women
double calculateBMRWomen(double weight, double height, int age) {
    return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
}

int main() {
    double weight, height;
    int age;
    char gender;

    // Prompt user for input
    cout << "Enter your weight in kilograms: ";
    cin >> weight;

    cout << "Enter your height in centimeters: ";
    cin >> height;

    cout << "Enter your age in years: ";
    cin >> age;

    cout << "Enter your gender (M/F): ";
    cin >> gender;

    double bmr;

    // Calculate BMR based on gender
    if (gender == 'M' || gender == 'm') {
        bmr = calculateBMRMen(weight, height, age);
        cout << "Your Basal Metabolic Rate (BMR) for men is: " << bmr << " calories per day." << endl;
    } else if (gender == 'F' || gender == 'f') {
        bmr = calculateBMRWomen(weight, height, age);
        cout << "Your Basal Metabolic Rate (BMR) for women is: " << bmr << " calories per day." << endl;
    } else {
        cout << "Invalid gender entered. Please enter 'M' or 'F'." << endl;
    }

    return 0;
}
