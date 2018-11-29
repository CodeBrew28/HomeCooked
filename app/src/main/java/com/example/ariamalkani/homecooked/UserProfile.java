package com.example.ariamalkani.homecooked;

/**
 * Created by laked on 11/28/2018.
 */

public class UserProfile {
    private int userID;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private StateClass.State state;
    private int zip;
    private boolean isVegan;
    private boolean isVerified;
    private boolean isPublic;

    public UserProfile(){

    }

    public UserProfile(int userID, String fName, String lName, String email, String phone, String address, String city, StateClass.State state,
                       int zip, boolean isVegan, boolean isVerified, boolean isPublic){
        this.userID = userID;
        this.fName=fName;
        this.lName=lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.isVegan = isVegan;
        this.isVerified = isVerified;
        this.isPublic = isPublic;
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StateClass.State getState() {
        return state;
    }

    public void setState(StateClass.State state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }






}
