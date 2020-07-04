package com.example.mytrip;


import java.util.Arrays;

public class User
{
    private long id;
    private String email;
    private String password;
    private byte[] avatar;
    private int[] favorites;
    // constructors
    public User(long id, String email, String password, byte[] avatar, int[] favorites)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.favorites = favorites;
    }

    public User(String email, String password, int[] favorites, byte[] avatar)
    {
        //this.id = 0;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.favorites = favorites;
    }
    // getters and setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return this.password; }
    public void setPassword(String password) { this.password = password; }

    public byte[] getImg() { return this.avatar; }
    public void setImg(byte[] avatar) { this.avatar = avatar; }

    public String getFavorites() { return Arrays.toString(this.favorites); }
    public void setFavorites(int[] favorites) { this.favorites = favorites; }

    @Override
    public String toString()// can't use NonNull annotation
    {
        return "User" + '\'' +
                "{ID:" + id + '\'' +
                "Email:" + email + '\'' +
                "Password:" + password + '\'' +
                "Favorite:" + Arrays.toString(favorites) + '\'' +
                ", image:" + Arrays.toString(avatar) + '\'' +
                "}";
    }
}