package com.calorieminder.calorieminder.Model;

//class responsible for water tracking and input
public class Water {

    //ant volumes
    final float cup = 240;
    final float plasticWaterBottle = 500;
    final float waterBottle1 = 750;
    final float waterBottle2 = 1000;
    //updated variables
    float waterPerDay = 0;
    float waterConsumed = 0;

    //inputs the user weight in lbs and activity level 1-5
    void waterPerDayCalc(float weight, int activityLevel) {
        waterPerDay = (float) ((0.6 * weight + 8 * activityLevel) * 29.5735);
    }

    // inputs the water needed to consume a day and water already consumed, returns percent of daily intake completed
    float percentOfDailyWaterConsumed(float waterPerDay, float waterConsumed) {
        return 100 * (waterPerDay - waterConsumed) / waterPerDay;
    }

    //update the water consumed
    void updateWaterConsumed(float volumeConsumed) {
        waterConsumed += volumeConsumed;
    }
}
