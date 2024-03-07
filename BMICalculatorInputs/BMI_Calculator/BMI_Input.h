//BMI_Input.h
#pragma once
namespace N {
	class BMI_Input {
	private:
		double Weight; //stored weight of the user in lbs
		double Height; //stored height of the user in ft
		int Age; //stored age of the user in years...TODO: Convert this to it's own class to factor in different ways to enter in an Age
		double BMI; //calculated BMI of the user
		double BMR; //calculated BMR of the user
	public:
		void Set_Weight(double weightInput); //sets the Weight section of the user profile
		double Get_Weight(); //obtains the Weight information of the user
		void Set_Height(double heightInput, std::string measurement); //sets Height section of the user profile
		double Get_Height(); //obtains the Height information of the user
		void Set_Age(int ageInput); //sets the Age section of the user profile
		int Get_Age(); //obtains the Age information of the user
		double CalculateBMI_Index(double index); //calculates the user's BMI using user weight data and a BMI algo
		string Determine_WeightType(double BMI); //determines the weight type of the user
	};
}
