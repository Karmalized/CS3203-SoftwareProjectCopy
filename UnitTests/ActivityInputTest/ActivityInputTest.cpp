#include <iostream>
#include <math.h>
using namespace std;


// Function Placeholder
bool activityInput(int activityID, float duration)
{
    return true;
}

// If parameter is not true, test fails
// This check function would be provided by the test framework
#define IS_TRUE(x) { if (!(x)) std::cout << __FUNCTION__ << " failed on line " << __LINE__ << std::endl; }

// Tests each test case of the activity input function
// Activity input function should take activityID int and duration float and return true if the inputs are valid
void testActivityInput()
{
    //activityID tests
    IS_TRUE(activityInput(INT_MIN-1,1));
    IS_TRUE(activityInput(INT_MIN, 1));
    IS_TRUE(activityInput(-1, 1))
    IS_TRUE(activityInput(0, 1))
    IS_TRUE(activityInput(1, 1))
    IS_TRUE(activityInput(INT_MAX, 1))
    IS_TRUE(activityInput(INT_MAX+1, 1))

    //duration tests
    IS_TRUE(activityInput(1,pow(1.175494351, -39)));
    IS_TRUE(activityInput(1,pow(1.175494351, -38)));
    IS_TRUE(activityInput(1, -1));
    IS_TRUE(activityInput(1, 0));
    IS_TRUE(activityInput(1, 1));
    IS_TRUE(activityInput(1, pow(3.402823466, 38)));
    IS_TRUE(activityInput(1, pow(3.402823466, 38)+1));

    return;
}



int main(void)
{
    testActivityInput;
    return 0;
}
