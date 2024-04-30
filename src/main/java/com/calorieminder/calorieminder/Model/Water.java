package com.calorieminder.calorieminder.Model;

//class responsible for water tracking and input
public class Water {

    //ant volumes

    //updated variables
    float waterPerDay = 0;
    float waterConsumed = 0;

    //inputs the user weight in lbs and activity level 1-5, outputs water consumption necessary in mL
    void waterPerDayCalc(float weight, int activityLevel) {
        waterPerDay = (float) ((0.453592 * weight) * 0.03 + activityLevel*0.2)*1000;
    }

    // inputs the water needed to consume a day and water already consumed, returns percent of daily intake completed
    float percentOfDailyWaterConsumed(float waterPerDay, float waterConsumed) {
        return 100 * (waterPerDay - waterConsumed) / waterPerDay;
    }

    //update the water consumed
    void updateWaterConsumed(float volumeConsumed, String unit)
    {
        switch (unit) {
            case "mL":
                waterConsumed += volumeConsumed;
                break;
            case "oz":
                waterConsumed += volumeConsumed*29.5735;
        }
    }
}
