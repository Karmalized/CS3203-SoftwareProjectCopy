
#include <iostream>
#include <math.h>
using namespace std;

//the function placeholder

bool WeightInput(float a) 
{
    return true;
}

// If parameter is not true, test fails
#define IS_TRUE(x) { if (!(x)) std::cout << __FUNCTION__ << " failed on line " << __LINE__ << std::endl; }

// Test for WeightInput
// Testing the WeightInput function, which takes in a float value of the user's weight returns true if the data input is successful/valid
void test_WeightInputTest()
{
    IS_TRUE(WeightInput(pow(1.175494351, -39)));
    IS_TRUE(WeightInput(pow(1.175494351, -38)));
    IS_TRUE(!WeightInput(-1));
    IS_TRUE(!WeightInput(0));
    IS_TRUE(WeightInput(1));
    IS_TRUE(WeightInput(pow(3.402823466, 38)));
    IS_TRUE(WeightInput(pow(3.402823466, 38)+1));
    return;
}

int main(void) {
    // Call all tests
    test_WeightInputTest();
    return 0;
}
