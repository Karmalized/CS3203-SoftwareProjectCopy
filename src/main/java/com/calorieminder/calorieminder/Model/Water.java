package com.calorieminder.calorieminder.Model;

//class responsible for water tracking and input
public class Water {

    //ant volumes

    //updated variables
    public static float waterPerDay = 0;
   public static float waterConsumed = 0;
public static float weight = 0;
public static int activityLevel = 0;
    //inputs the user weight in lbs and activity level 1-5, outputs water consumption necessary in mL
    public static float waterPerDayCalc(float weight, int activityLevel) {
        return (float) ((0.453592 * weight) * 0.03 + activityLevel * 0.2) * 1000;
    }

    // inputs the water needed to consume a day and water already consumed, returns percent of daily intake completed
   public static float percentOfDailyWaterConsumed(float waterPerDay, float waterConsumed) {
        return 100 * (waterPerDay - waterConsumed) / waterPerDay;
    }

    //update the water consumed
   public void updateWaterConsumed(float volumeConsumed, String unit)
    {
        switch (unit) {
            case "mL":
                waterConsumed += volumeConsumed;
                break;
            case "oz":
                waterConsumed += volumeConsumed*29.5735;
        }
    }

    public static double getWaterConsumed()
    {
        return waterConsumed;
    }
    public static double getWaterPerDay()
    {
        return waterPerDay;
    }
    public static double getWeight()
    {
        return weight;

    }
    public static double getActivityLevel()
    {
        return activityLevel;
    }
}
