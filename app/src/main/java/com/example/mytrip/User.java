package com.example.mytrip;


public class User
{
    private long customerId;
    private String strEmail;
    private String strPassword;
    private byte[] bImg;
    private String sirFavorite;
    // constructors
    public User(long customerId, String strEmail, String strPassword, byte[] bImg, String sirFavorite)
    {
        this.customerId = customerId;
        this.strEmail = strEmail;
        this.strPassword = strPassword;
        this.bImg = bImg;
        this.sirFavorite = sirFavorite;
    }

    public User(String strEmail, String strPassword, String sirFavorite, byte[] bImg)
    {
        this.customerId = 0;
        this.strEmail = strEmail;
        this.strPassword = strPassword;
        this.bImg = bImg;
        this.sirFavorite = sirFavorite;
    }
    // getters and setters
    public long getCustomerId() { return customerId; }
    public void setCustomerId(long customerId) { this.customerId = customerId; }

    public String getEmail() { return strEmail; }
    public void setEmail(String strEmail) { this.strEmail = strEmail; }

    public String getPassword() { return this.strPassword; }
    public void setPassword(String strPassword) { this.strPassword = strPassword; }

    public byte[] getImg() { return this.bImg; }
    public void setImg(byte[] bImg) { this.bImg = bImg; }

    public String getFavorite() { return this.sirFavorite; }
    public void setFavorite(String sirFavorite) { this.sirFavorite = sirFavorite; }

    @Override
    public String toString()// can't use NonNull annotation
    {
        if (this != null)
        {
            return "User{" +
                    "Email:" + strEmail + '\'' +
                    ", Password:" + strPassword + '\'' +
                    ", Favorite:" + sirFavorite +
                    ", image:" + bImg +
                    ", customerID:" + customerId +
                    "}";
        }
        else return super.toString();
    }
}