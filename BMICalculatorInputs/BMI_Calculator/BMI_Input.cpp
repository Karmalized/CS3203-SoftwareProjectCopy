//BMI_Weight.cpp
#include "../BMI_Calculator/BMI_Input.h"
#include <iostream>

using namespace N;
using namespace std;

void BMI_Input::Set_Weight(double weightInput){
	BMI_Input::Weight = weightInput;
}

double BMI_Input::Get_Weight() {
	return BMI_Input::Weight;
}

void BMI_Input::Set_Height(double heightInput, string measurement) {
	if(measurement == "FEET")
		BMI_Input::Height = heightInput * 12 * 2.54;
	else {
		BMI_Input::Height = heightInput;
	}
}

double BMI_Input::Get_Height() {
	return BMI_Input::Height;
}

void BMI_Input::Set_Age(int ageInput) {
	BMI_Input::Age = ageInput;
}

int BMI_Input::Get_Age() {
	return BMI_Input::Age;
}

//NOTE: MORE FUNCTIONS TO BE ADDED
