package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;

public class Register extends AppCompatActivity
{
    // element declaration
    private ImageView avatar;
    private EditText email;
    private EditText password;
    private EditText password2;

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.removeItem(R.id.action_favorite);
        menu.removeItem(R.id.action_favorites);
        menu.removeItem(R.id.action_profile);
        menu.removeItem(R.id.action_login);
        menu.removeItem(R.id.action_register);
        menu.removeItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar action_bar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(action_bar);

        // takeover
        avatar = findViewById(R.id.avatar);
        email = findViewById(R.id.r_username);
        password = findViewById(R.id.r_password);
        password2 = findViewById(R.id.r_password2);
    }
}