package com.example.ariamalkani.homecooked;

/**
 * Created by laked on 11/27/2018.
 */

public class ReviewMeal extends Meal {
    private int mealScore;
    private int cleanScore;
    private int politeScore;

    public ReviewMeal(){}

    public ReviewMeal(String chefName, Boolean verified, Boolean vegan,
                      String rating, String avgPrice, int thumbnail, String location) {
        super(chefName, verified, vegan, rating, avgPrice, thumbnail, location);
        this.mealScore = 0;
        this.politeScore = 0;
        this.cleanScore = 0;
    }

    public ReviewMeal(String chefName, Boolean verified, Boolean vegan,
                      String rating, String avgPrice, int thumbnail, String location,
                      int mealScore, int cleanScore, int politeScore){
        super(chefName, verified, vegan, rating, avgPrice, thumbnail, location);
        this.mealScore = mealScore;
        this.cleanScore = cleanScore;
        this.politeScore = politeScore;
    }

    public int getMealScore(){
        return this.mealScore;
    }
    public int getCleanScore(){
        return this.cleanScore;
    }
    public int getPoliteScore(){
        return this.politeScore;
    }


    public void setMealScore(int newScore){
        this.mealScore = newScore;
    }
    public void setCleanScore(int newScore){
        this.cleanScore = newScore;
    }
    public void setPoliteScore(int newScore){
        this.politeScore = newScore;
    }
}
;