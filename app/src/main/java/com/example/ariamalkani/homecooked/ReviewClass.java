package com.example.ariamalkani.homecooked;

/**
 * Created by laked on 12/5/2018.
 */

public class ReviewClass {
    private int mealScore;
    private int politeScore;
    private int cleanScore;
    private int mealID;
    private int userID;
    private String comments;

    public ReviewClass(){
        mealScore = 0;
        politeScore = 0;
        cleanScore = 0;
        mealID = 0;
        userID = 0;
    }

    public ReviewClass(int userID, int mealID, int mealScore, int politeScore, int cleanScore, String comments){
        this.userID = userID;
        this.mealID = mealID;
        this.mealScore = mealScore;
        this.politeScore = politeScore;
        this.cleanScore = cleanScore;
        this.comments = comments;
    }


    public int getMealScore() {
        return mealScore;
    }

    public void setMealScore(int mealScore) {
        this.mealScore = mealScore;
    }

    public int getPoliteScore() {
        return politeScore;
    }

    public void setPoliteScore(int politeScore) {
        this.politeScore = politeScore;
    }

    public int getCleanScore() {
        return cleanScore;
    }

    public void setCleanScore(int cleanScore) {
        this.cleanScore = cleanScore;
    }

    public int getMealID() {
        return mealID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
