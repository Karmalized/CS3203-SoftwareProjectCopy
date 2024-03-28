#include "pch.h"
#include "CppUnitTest.h"
#include <BMI_Input_Lib.h>

using namespace Microsoft::VisualStudio::CppUnitTestFramework;

namespace BMIInputUnitTest
{
	TEST_CLASS(BMIInputUnitTest)
	{
	public:

		TEST_METHOD(TestWeightGetSet) //Testing the Weight Section of inputs for the BMI & BMR Calculator
		{
			double normalWeight = 125.6; //a normal weight
			double slimmerWeight = 96.6; //a weight which normally slimmer people carry
			double intricateWeight = 130.123657820; //a pretty nuanced weight
			double noWeight = 0.0; //a weight which isn't technically possible as you can't have no weight
			double impossibleWeight = -150.5; //a weight that can't be entered as this weight shouldn't be possible
			int differentWeight = 126; //A weight which should probably be converted to conform to the standard of a visualized double as weight info

			BMI_Input Weight;
			Weight.Set_Weight(normalWeight);
			Assert::AreEqual(normalWeight, Weight.Get_Weight());

			Weight.Set_Weight(slimmerWeight);
			Assert::AreEqual(slimmerWeight, Weight.Get_Weight());

			Weight.Set_Weight(intricateWeight);
			Assert::AreEqual(intricateWeight, Weight.Get_Weight());

			Weight.Set_Weight(noWeight);
			Assert::AreNotEqual(noWeight, Weight.Get_Weight());

			Weight.Set_Weight(impossibleWeight);
			Assert::AreEqual(impossibleWeight, Weight.Get_Weight());

			Weight.Set_Weight(differentWeight);
			double convert = differentWeight;
			Assert::AreEqual(convert, Weight.Get_Weight());

		}

		TEST_METHOD(TestHeightGetSet) { //Testing the Height Section of inputs for the BMI & BMR Calculator

			double AvgMaleHeight = 5.9; //Average Male Height in the United States (in Feet)
			double AvgFemaleHeight = 5.4; //Average Female Height in the United States (in Feet)
			double MaleHeightCM = 175.36; //Average Male Height in a different system (in cm's)
			double NoHeight = 0.0; //A Height when entered that's not possible but can be entered
			double ImpossibleHeight = -3.5; //A Height that's not even possible to be reached, this value can't be entered
			int ConvertHeight = 6; //A Height which should be able to be converted from one data type to another (in this instance, a double)

			BMI_Input Height;
			std::string feetInput = "FEET";
			Height.Set_Height(AvgMaleHeight, feetInput);
			Assert::AreEqual(AvgMaleHeight * 12 * 2.54, Height.Get_Height());

			Height.Set_Height(AvgFemaleHeight, feetInput);
			Assert::AreEqual(AvgFemaleHeight * 12 * 2.54, Height.Get_Height());

			Height.Set_Height(MaleHeightCM, "CM");
			Assert::AreEqual(MaleHeightCM, Height.Get_Height());

			Height.Set_Height(NoHeight, feetInput);
			Assert::AreNotEqual(AvgFemaleHeight, Height.Get_Height());

			Height.Set_Height(ImpossibleHeight, feetInput);
			Assert::AreNotEqual(ImpossibleHeight, Height.Get_Height());

			//Height.Set_Height(ConvertHeight, feetInput);
			//double converted = ConvertHeight;
			//Assert::AreEqual(converted, Height.Get_Height());

		}

		TEST_METHOD(TestAgeGetSet) { //Testing the Age Section of inputs for the BMI & BMR Calculator...TODO: Implement entering in a birthday in order to track age on program

			int StandardAgeMillenial = 27; //The Age of standard Millenial who may end up using the Calorie Tracking Program
			int AgeGenZ = 18; //Age of GenZer who may end up using this app
			double differentDataType = 25.6; //Age Data Type in the form of a double which should undergo a conversion process to int
			int ImpossibleAge = -1; //An Age Value which shouldn't be possible to enter into the system
			int zeroAge = 0; //An Age which shouldn't be possible to enter into the system

			BMI_Input Age;
			Age.Set_Age(StandardAgeMillenial);
			Assert::AreEqual(StandardAgeMillenial, Age.Get_Age());

			Age.Set_Age(AgeGenZ);
			Assert::AreEqual(AgeGenZ, Age.Get_Age());

			Age.Set_Age(differentDataType);
			int convertedCorrect = std::floor(differentDataType);
			Assert::AreEqual(convertedCorrect, Age.Get_Age());

			Age.Set_Age(ImpossibleAge);
			Assert::AreNotEqual(ImpossibleAge, Age.Get_Age());

			Age.Set_Age(zeroAge);
			Assert::AreNotEqual(zeroAge, Age.Get_Age());
		}
	};
}
