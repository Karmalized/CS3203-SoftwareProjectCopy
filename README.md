## CalorieMinder

CalorieMinder is a health and fitness application designed to help users track their caloric and nutrient intake. Whether you're trying to lose weight, gain muscle, or simply maintain a healthy lifestyle, CalorieMinder provides you with the tools you need to monitor your dietary habits and make informed decisions about your nutrition.

## Features
- **Food Diary**: Keep a detailed record of everything you eat and drink throughout the day.
- **Calorie Tracking**: Monitor your daily calorie intake and compare it to your goals.
- **Nutrient Analysis**: Track essential nutrients such as protein, carbohydrates, fats, vitamins, and minerals.
- **Custom Food Entries**: Add custom foods and recipes to accurately reflect your meals.
- **Meal Planning**: Plan your meals in advance to ensure you meet your nutritional targets.
- **Progress Monitoring**: Visualize your progress over time with graphs and charts.

Extra Features:
- **Water Intake Tracking**: Monitor your hydration levels by logging your water consumption.

## Getting Started
The application is still in its prototyping phase, we will be issuing beta testing for a few select individuals to monitor system function. To be apart of the testing process email us here with an application: support@calorieminder.com, selection of applicants is TBD.

## How to Use
- Sign Up or Log In: Create a new account or log in with your existing credentials.
- Set Your Goals: Input your personal information and health objectives to generate custom targets.
- Track Your Food Intake: Use the food diary feature to log everything you eat and drink throughout the day.
- Monitor Your Progress: Review your daily and weekly summaries to see how your actual intake compares to your goals.
- Adjust as Needed: Modify your diet and activity levels as necessary to stay on track and reach your targets.
Support
If you encounter any issues or have any questions about using CalorieMinder, please don't hesitate to contact our support team at support@calorieminder.com. We're here to help you make the most of your health and fitness journey.

# Feedback
We're constantly working to improve CalorieMinder and would love to hear your feedback. Whether it's a feature request, bug report, or general suggestion, please feel free to reach out to us at feedback@calorieminder.com. Your input helps us make CalorieMinder the best it can be.

# Privacy Policy
Your privacy is important to us. To learn more about how we collect, use, and protect your personal information, please review our Privacy Policy.

# Terms of Service
By using CalorieMinder, you agree to our Terms of Service. Please read these terms carefully before accessing or using the application.

## Current Progress
**Java Integration for App Optimization**

buildNutrientFile.java: Adapts input2txt.cpp into an optimized Java environment with functions taking system input for nutrients and building upon values until a full day has elapsed (and the file information is exported into a database)

Water.java: Adapts Water.h into an optimized Java environment using functions that keeps track of water consumption and the total amount of intake from the user against recommended values

BMI/BMRCalculator.java & DeficiencyCalculator.java: adapts the cpp files of the same name in a java environment

Micros.java: function call to USDA database of vitamins and their levels onto a nutrientMap

USDAapi.java: API calls to the USDA database
