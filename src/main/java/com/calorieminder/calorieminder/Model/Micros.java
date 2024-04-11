package com.calorieminder.calorieminder.Model;

import java.util.*;

//object for storing micronutrient values
public class Micros {
    private double vitaminA;
    private double vitaminB1;
    private double vitaminB2;
    private double vitaminB3;
    private double vitaminB5;
    private double vitaminB6;
    private double vitaminB9;
    private double vitaminB12;
    private double vitaminC;
    private double vitaminD;
    private double vitaminE;
    private double vitaminK;
    private double calcium;
    private double phosphorus;
    private double magnesium;
    private double iron;
    private double zinc;
    private double copper;
    private double potassium;
    private double sodium;

    //USDA number corresponding to each nutrient for the API call
    public final Integer[] nutrientNumbers = {320,404,405,406,410,415,417,418,401,328,573,430,301,305,304,303,309,312,306,307};

    private final Map<String, Integer> nutrientMap;

    public Map<String, Integer> getNutrientMap() {
        return Collections.unmodifiableMap(nutrientMap);
    }

    public Micros() {
        nutrientMap = new HashMap<>();
        nutrientMap.put("vitaminA", 320);
        nutrientMap.put("vitaminB1", 404);
        nutrientMap.put("vitaminB2", 405);
        nutrientMap.put("vitaminB3", 406);
        nutrientMap.put("vitaminB5", 410);
        nutrientMap.put("vitaminB6", 415);
        nutrientMap.put("vitaminB9", 417);
        nutrientMap.put("vitaminB12", 418);
        nutrientMap.put("vitaminC", 401);
        nutrientMap.put("vitaminD", 328);
        nutrientMap.put("vitaminE", 573);
        nutrientMap.put("vitaminK", 430);
        nutrientMap.put("calcium", 301);
        nutrientMap.put("phosphorus", 305);
        nutrientMap.put("magnesium", 304);
        nutrientMap.put("iron", 303);
        nutrientMap.put("zinc", 309);
        nutrientMap.put("copper", 312);
        nutrientMap.put("potassium", 306);

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
