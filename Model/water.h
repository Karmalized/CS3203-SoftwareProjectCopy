using namespace std;
//class responsible for water tracking and input
class water{
public:
//constant volumes
const float cup = 240;
const float plasticWaterBottle = 500;
const float waterBottle1 = 750;
const float waterBottle2 = 1000;
//updated variables
float waterPerDay = 0;
float waterConsumed = 0;

//inputs the user weight in lbs and activity level 1-5
void waterPerDayCalc(float weight, int activityLevel)
{
    waterPerDay =  (0.6 * weight + 8 * activityLevel) * 29.5735;
}

// inputs the water needed to consumed a day and water already consumed, returns percent of daily intake completed
float percentOfDailyWaterConsumed(float waterPerDay, float waterConsumed)
{
    float percentConsumed = 100*(waterPerDay - waterConsumed)/waterPerDay;
    return waterConsumed;
}

//update the water consumed
void updateWaterConsumed(float volumeConsumed)
{
    waterConsumed += volumeConsumed;
}
}; 


