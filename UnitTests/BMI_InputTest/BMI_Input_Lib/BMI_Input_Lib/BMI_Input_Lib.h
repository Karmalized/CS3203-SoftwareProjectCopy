#pragma once
#include <string>
class BMI_Input {
private:
	double Weight; //stored weight of the user in lbs
	double Height; //stored height of the user in ft
	int Age; //stored age of the user in years...TODO: Convert this to it's own class to factor in different ways to enter in an Age
	double BMI; //calculated BMI of the user
	double BMR; //calculated BMR of the user
public:
	BMI_Input() { //Constructor for the BMI_Input class initializing all the variables
		BMI_Input::Age = 0;
		BMI_Input::Weight = 0.0;
		BMI_Input::Height = 0.0;
		BMI_Input::BMI = 0.0;
		BMI_Input::BMR = 0.0;
	}
	void Set_Weight(double weightInput) { //sets the weight section of the User Profile
		BMI_Input::Weight = weightInput;
	}
	double Get_Weight() { //obtains the Weight information of the user
		return BMI_Input::Weight;
	}
	void Set_Height(double heightInput, std::string measurement) { //sets Height section of the user profile
		if (measurement == "FEET")
			BMI_Input::Height = heightInput * 12 * 2.54;
		else {
			BMI_Input::Height = heightInput;
		}
	}
	double Get_Height() { //obtains the Height information of the user
		return BMI_Input::Height;
	}
	void Set_Age(int ageInput) { //sets the Age section of the user profile
		BMI_Input::Age = ageInput;
	}

	int Get_Age() { //obtains the Age information of the user
		return BMI_Input::Age;
	}
	double CalculateBMI_Index(double index); //calculates the user's BMI using user weight data and a BMI algo
	std::string Determine_WeightType(double BMI); //determines the weight type of the user
};