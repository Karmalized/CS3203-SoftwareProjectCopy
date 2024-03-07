#include <iostream>
#include <math.h>
using namespace std;

//function placeholder
//array should be size 33 for relevant vitamins/minerals + 3 macronutrients, FIRST ELEMENT IS SIZE OF ARRAY
void InitializeNutrients(float* a) 
{
    //set the initial values of the array
    return;
}
float* getCurrentNutrientArray(){
    //get the current values in the nutrient araray
    static float bruh[33] = {};
    bruh[0] = 32;
    float* DeleteThisLater = bruh;
    return  DeleteThisLater;

}

// If parameter is not true, test fails
#define IS_TRUE(x) { if (!(x)) cout << __FUNCTION__ << " failed on line " << __LINE__ << endl; }
// If parameter is true, test fails
#define IS_FALSE(x) { if ((x)) cout << __FUNCTION__ << " failed on line " << __LINE__ << endl; }

// Test for InitializeInput
void test_InitializeInput()
{
    //TEST NEGATIVE VALUES
    //Test all negative values
    static float testA[32] = {-100.454};
    float* test1 = testA;
    InitializeNutrients(test1);
    for (int i = 0; i < 32; i++) {
        IS_TRUE(getCurrentNutrientArray()[i] >= 0.0);
    }
    //Test only 1 negative value
    static float testB[32] = {};
    testB[15] = -0.9;
    float*test2 = testB;
    InitializeNutrients(test2);
    for (int i = 0; i < 32; i++) {
        IS_TRUE(getCurrentNutrientArray()[i] >= 0.0);
    }

    //TEST NULL POINTER
    float* test3 = nullptr;
    InitializeNutrients(test3);
    IS_FALSE(getCurrentNutrientArray() == nullptr);
    IS_TRUE(getCurrentNutrientArray()[0] == 32);

    //TEST INCORRECT ARRAY SIZE
    //test too large
    static float testC[33] = {};
    float*test4 = testC;
    InitializeNutrients(test4);
    IS_TRUE(getCurrentNutrientArray()[0] == 32);

    //test too small
    static float testD[31] = {};
    float*test5 = testD;
    InitializeNutrients(test5);
    IS_TRUE(getCurrentNutrientArray()[0] == 32);
}

int main(void) {
    // Call Test
    test_InitializeInput();
    return 0;
}
