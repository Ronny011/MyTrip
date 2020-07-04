package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity
{
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.l_username);
        password = findViewById(R.id.l_password);
    }
}