package com.example.akal.shoppyapp;

import android.app.Application;

/**
 * Created by Gursimran on 07-12-2017.
 */

public class RetriveData extends Application {

    public String city;
    public String country;
    public String email;

    public RetriveData() {
    }

    public String postal;
    public String state;

    public RetriveData(String city, String country, String email, String postal, String state, String street, String username) {
        this.city = city;
        this.country = country;
        this.email = email;
        this.postal = postal;
        this.state = state;
        this.street = street;
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "RetriveData{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", postal='" + postal + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String street;
    public String username;
    }

