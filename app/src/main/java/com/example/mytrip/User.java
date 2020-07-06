package com.example.mytrip;


import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User
{
    private long id;
    private String email;
    private String password;
    private byte[] avatar;
    private String favorites;
    // constructors
    public User(long id, String email, String password, byte[] avatar, String favorites)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.favorites = favorites;
    }

    public User(User user)
    {
        id = user.getId();
        email = user.getEmail();
        password = user.getPassword();
        avatar = user.getImg();
        favorites = user.getFavorites();
    }

    public User(String email, String password, String favorites, byte[] avatar)
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

    public String getFavorites() { return this.favorites; }
    public void setFavorites(String favorites) { this.favorites = favorites; }

    @Override
    public String toString()// can't use NonNull annotation
    {
        return "User" + '\'' +
                "{ID:" + id + '\'' +
                "Email:" + email + '\'' +
                "Password:" + password + '\'' +
                "Favorite:" + favorites + '\'' +
                ", image:" + Arrays.toString(avatar) + '\'' +
                "}";
    }

    public void convertFavorites()
    {
        String input = favorites;
        String[] numbers = input.split(",");
        List<Integer> result = new ArrayList<Integer>();
        for(String number : numbers) {
            try {
                result.add(Integer.parseInt(number.trim()));

            } catch(Exception e) {
                // log about conversion error
            }
        }
        Log.d("D/DHelper", result.toString());
        Log.d("D/DHelper", result.getClass().getName());
        MainActivity.favs = result;
    }
}