#include <iostream>
using namespace std;

class BMI_Weight {
private:
	double weight_input; //weight of the person in lbs

public:
	void Set_Weight(double weightInput); //sets the Weight section of the user profile
	double Get_Weight(); //obtains the Weight information of the user
	void CalculateBMI_Index(double index); //calculates the user's BMI using user weight data and a BMI algo
	bool isHealthyRange(); //determines whether the user's BMI is healthy; NOTE: OTHER CLASSIFICATIONS OF BMI WILL BE FURTHER SPECIFIFED

};
void BMI_Weight::CalculateBMI_Index(double index) {

}