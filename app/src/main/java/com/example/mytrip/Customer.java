package com.example.mytrip;

import java.sql.Blob;

public class Customer {
    private String strEmail;
    private String strPassword;
    private Blob bImg;
    private String sirFavorite;
    private int customerId;

    public Customer(int customerId, String strEmail, String strPassword, Blob bImg, String sirFavorite) {
        this.strEmail = strEmail;
        this.strPassword = strPassword;
        this.sirFavorite = sirFavorite;
        this.bImg = bImg;
        this.customerId = customerId;
    }

    public Customer(String strEmail, String strPassword, String sirFavorite, Blob bImg) {
        this.strEmail = strEmail;
        this.strPassword = strPassword;
        this.sirFavorite = sirFavorite;
        this.bImg = bImg;
        this.customerId = 0;
    }

    public String getEmail() {
        return strEmail;
    }

    public void setEmail(String strEmail) {
        this.strEmail = strEmail;
    }


    public String getPassword() {
        return this.strPassword;
    }

    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }


    public String getFavorite() {
        return this.sirFavorite;
    }

    public void setFavorite(String sirFavorite) {
        this.sirFavorite = sirFavorite;
    }


    public Blob getImg() {
        return this.bImg;
    }

    public void setImg(Blob bImg) {
        this.bImg = bImg;
    }

    public long getcustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Email:'" + strEmail + '\'' +
                ", Password:'" + strPassword + '\'' +
                ", Favorit:" + sirFavorite +
                ", image:" + bImg +
                ", customerID:" + customerId +
                '}';
    }
}

