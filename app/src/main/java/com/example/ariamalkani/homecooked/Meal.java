package com.example.ariamalkani.homecooked;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Meal implements Serializable {
    private int mealID;
    private String chefName;
    private Boolean verified;
    private Boolean vegan;
    private String rating;
    private String avgPrice;
    private String location;
    private int thumbnail;
    private ArrayList<ReviewClass> reviews;

    public Meal() { }

    public Meal(int mealID, String chefName, Boolean verified, Boolean vegan,
                String rating, String avgPrice, int thumbnail, String location) {
        this.mealID = mealID;
        this.chefName = chefName;
        this.verified = verified;
        this.vegan = vegan;
        this.rating = rating;
        this.avgPrice = avgPrice;
        this.thumbnail = thumbnail;
        this.location = location;
        reviews = new ArrayList<ReviewClass>(5);
    }

    //  Getters
    public String getChefName() {
        return this.chefName;
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public String getRating() {
        return rating;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getLocation() {return location; }

    // Setters

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLocation (String location) { this.location = location; }

    public ArrayList<ReviewClass> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<ReviewClass> reviews) {
        this.reviews = reviews;
    }
}

