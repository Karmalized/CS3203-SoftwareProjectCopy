package com.calorieminder.calorieminder.Model;

import java.util.*;

//object for storing micronutrient values
//ALL UNITS STORED IN MG or UG, based on recommended daily intake from USDA


public class Micros {
    private double vitaminA = 0;
    private double vitaminB1 = 0;
    private double vitaminB2 = 0;
    private double vitaminB3 = 0;
    private double vitaminB5 = 0;
    private double vitaminB6 = 0;
    private double vitaminB9 = 0;
    private double vitaminB12 = 0;
    private double vitaminC = 0;
    private double vitaminD = 0;
    private double vitaminE = 0;
    private double vitaminK = 0;
    private double calcium = 0;
    private double phosphorus = 0;
    private double magnesium = 0;
    private double iron = 0;
    private double zinc = 0;
    private double copper = 0;
    private double potassium = 0;
    private double sodium = 0;

    //USDA number corresponding to each nutrient for the API call
    public final Integer[] nutrientNumbers = {320,404,405,406,410,415,417,418,401,328,573,430,301,305,304,303,309,312,306,307};

    private final Map<Integer, String> nutrientMap;

    public Map<Integer, String> getNutrientMap() {
        return Collections.unmodifiableMap(nutrientMap);
    }

    private final Map<String, Double> DailyGoal;

    public Map<String, Double> DailyGoal() {
        return Collections.unmodifiableMap(DailyGoal);
    }

    public Micros() {
        nutrientMap = new HashMap<>();
        nutrientMap.put(320,"vitaminA");
        nutrientMap.put(404,"vitaminB1");
        nutrientMap.put(405,"vitaminB2");
        nutrientMap.put(406,"vitaminB3");
        nutrientMap.put(410,"vitaminB5");
        nutrientMap.put(415,"vitaminB6");
        nutrientMap.put(417,"vitaminB9");
        nutrientMap.put(418,"vitaminB12");
        nutrientMap.put(307,"sodium");
        nutrientMap.put(401,"vitaminC");
        nutrientMap.put(328,"vitaminD");
        nutrientMap.put(573,"vitaminE");
        nutrientMap.put(430,"vitaminK");
        nutrientMap.put(301,"calcium");
        nutrientMap.put(305,"phosphorus");
        nutrientMap.put(304,"magnesium");
        nutrientMap.put(303,"iron");
        nutrientMap.put(309,"zinc");
        nutrientMap.put(312,"copper");
        nutrientMap.put(306,"potassium");

        DailyGoal = new HashMap<>();
        DailyGoal.put("vitaminA", 900.0); //900 mcg (UG)
        DailyGoal.put("vitaminB1", 1.2); //1.2 mg
        DailyGoal.put("vitaminB2", 1.3); //1.3 mg
        DailyGoal.put("vitaminB3", 16.0); //16 mg
        DailyGoal.put("vitaminB5", 5.0); //5 mg
        DailyGoal.put("vitaminB6", 1.7); //1.7 mg
        DailyGoal.put("vitaminB9", 400.0); //400 mcg (UG)
        DailyGoal.put("vitaminB12", 2.4); //2.4 mcg (UG)
        DailyGoal.put("sodium", 1500.0); //1500 mg
        DailyGoal.put("vitaminC", 90.0); //90 mg
        DailyGoal.put("vitaminD", 20.0); //20 mcg (UG)
        DailyGoal.put("vitaminE", 15.0); //15 mg
        DailyGoal.put("vitaminK", 120.0); //120 mcg (UG)
        DailyGoal.put("calcium", 1300.0); //1300 mg
        DailyGoal.put("phosphorus", 1250.0); //1250 mg
        DailyGoal.put("magnesium", 420.0); //420 mg
        DailyGoal.put("iron", 18.0); //18 mg
        DailyGoal.put("zinc", 11.0); //11 mg
        DailyGoal.put("copper", 0.9); //0.9 mg
        DailyGoal.put("potassium", 4700.0); //4700 mg


    }






    //increases micronutrient values by set amount based on nutrient specified
    public static void addMicrosbyNutrientID(int nutrientID, Micros micros, double amount) {
        switch (nutrientID) {
            case 320:
                micros.setVitaminA(micros.getVitaminA() + amount);
                break;
            case 404:
                micros.setVitaminB1(micros.getVitaminB1() + amount);
                break;
            case 405:
                micros.setVitaminB2(micros.getVitaminB2() + amount);
                break;
            case 406:
                micros.setVitaminB3(micros.getVitaminB3() + amount);
                break;
            case 410:
                micros.setVitaminB5(micros.getVitaminB5() + amount);
                break;
            case 415:
                micros.setVitaminB6(micros.getVitaminB6() + amount);
                break;
            case 417:
                micros.setVitaminB9(micros.getVitaminB9() + amount);
                break;
            case 418:
                micros.setVitaminB12(micros.getVitaminB12() + amount);
                break;
            case 307:
                micros.setSodium(micros.getSodium() + amount);
                break;
            case 401:
                micros.setVitaminC(micros.getVitaminC() + amount);
                break;
            case 328:
                micros.setVitaminD(micros.getVitaminD() + amount);
                break;
            case 573:
                micros.setVitaminE(micros.getVitaminE() + amount);
                break;
            case 430:
                micros.setVitaminK(micros.getVitaminK() + amount);
                break;
            case 301:
                micros.setCalcium(micros.getCalcium() + amount);
                break;
            case 305:
                micros.setPhosphorus(micros.getPhosphorus() + amount);
                break;
            case 304:
                micros.setMagnesium(micros.getMagnesium() + amount);
                break;
            case 303:
                micros.setIron(micros.getIron() + amount);
                break;
            case 309:
                micros.setZinc(micros.getZinc() + amount);
                break;
            case 312:
                micros.setCopper(micros.getCopper() + amount);
                break;
            case 306:
                micros.setPotassium(micros.getPotassium() + amount);
                break;
            default:
                return;
        }
        return;
    }

    public static void PrintAllMicros(Micros micros) {
        System.out.println("VitaminA: " + micros.getVitaminA());
        System.out.println("VitaminB1: " + micros.getVitaminB1());
        System.out.println("VitaminB2: " + micros.getVitaminB2());
        System.out.println("VitaminB3: " + micros.getVitaminB3());
        System.out.println("VitaminB5: " + micros.getVitaminB5());
        System.out.println("VitaminB6: " + micros.getVitaminB6());
        System.out.println("VitaminB9: " + micros.getVitaminB9());
        System.out.println("VitaminB12: " + micros.getVitaminB12());
        System.out.println("Sodium: " + micros.getSodium());
        System.out.println("VitaminC: " + micros.getVitaminC());
        System.out.println("VitaminD: " + micros.getVitaminD());
        System.out.println("VitaminE: " + micros.getVitaminE());
        System.out.println("VitaminK: " + micros.getVitaminK());
        System.out.println("Calcium: " + micros.getCalcium());
        System.out.println("Phosphorus: " + micros.getPhosphorus());
        System.out.println("Magnesium: " + micros.getMagnesium());
        System.out.println("Iron: " + micros.getIron());
        System.out.println("Zinc: " + micros.getZinc());
        System.out.println("Copper: " + micros.getCopper());
        System.out.println("Potassium: " + micros.getPotassium());
    }
    public double getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(double vitaminA) {
        this.vitaminA = vitaminA;
    }

    public double getVitaminB1() {
        return vitaminB1;
    }

    public void setVitaminB1(double vitaminB1) {
        this.vitaminB1 = vitaminB1;
    }

    public double getVitaminB2() {
        return vitaminB2;
    }

    public void setVitaminB2(double vitaminB2) {
        this.vitaminB2 = vitaminB2;
    }

    public double getVitaminB3() {
        return vitaminB3;
    }

    public void setVitaminB3(double vitaminB3) {
        this.vitaminB3 = vitaminB3;
    }

    public double getVitaminB5() {
        return vitaminB5;
    }

    public void setVitaminB5(double vitaminB5) {
        this.vitaminB5 = vitaminB5;
    }

    public double getVitaminB6() {
        return vitaminB6;
    }

    public void setVitaminB6(double vitaminB6) {
        this.vitaminB6 = vitaminB6;
    }

    public double getVitaminB9() {
        return vitaminB9;
    }

    public void setVitaminB9(double vitaminB9) {
        this.vitaminB9 = vitaminB9;
    }

    public double getVitaminB12() {
        return vitaminB12;
    }

    public void setVitaminB12(double vitaminB12) {
        this.vitaminB12 = vitaminB12;
    }

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public double getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(double vitaminD) {
        this.vitaminD = vitaminD;
    }

    public double getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(double vitaminE) {
        this.vitaminE = vitaminE;
    }

    public double getVitaminK() {
        return vitaminK;
    }

    public void setVitaminK(double vitaminK) {
        this.vitaminK = vitaminK;
    }

    public double getCalcium() {
        return calcium;
    }

    public void setCalcium(double calcium) {
        this.calcium = calcium;
    }

    public double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public double getMagnesium() {
        return magnesium;
    }

    public void setMagnesium(double magnesium) {
        this.magnesium = magnesium;
    }

    public double getIron() {
        return iron;
    }

    public void setIron(double iron) {
        this.iron = iron;
    }

    public double getZinc() {
        return zinc;
    }

    public void setZinc(double zinc) {
        this.zinc = zinc;
    }

    public double getCopper() {
        return copper;
    }

    public void setCopper(double copper) {
        this.copper = copper;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }
}
