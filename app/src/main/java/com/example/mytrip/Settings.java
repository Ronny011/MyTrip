package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class Settings extends AppCompatActivity implements View.OnClickListener
{
    private Button wipeDB;
    private Button showDB;
    private Button logoff;
    private Switch theme;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        wipeDB = findViewById(R.id.btn_wipeDB);
        showDB = findViewById(R.id.btn_showDB);
        logoff = findViewById(R.id.btn_logoff);
        theme = findViewById(R.id.switch_theme);
        wipeDB.setOnClickListener(this);
        showDB.setOnClickListener(this);
        logoff.setOnClickListener(this);
        if(!MainActivity.getLogged())
            logoff.setEnabled(false);
        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (theme.isChecked())
                    MainActivity.setLight(false);
                else
                    MainActivity.setLight(true);
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        DbHelper helper = DbHelper.getInstance(this);

        switch (v.getId())
        {
            case R.id.btn_logoff:
                MainActivity.setLogged(false);
                break;

            case R.id.btn_showDB:
                helper.getAllData();
                //List<User> users = helper.getAllData();
//                for (User user : users)
//                {
//                    Toast.makeText(getApplicationContext(), user.toString(),
//                            Toast.LENGTH_SHORT).show();
//                }
                break;

            case R.id.btn_wipeDB:
                helper.deleteAllData();
                this.deleteDatabase("myTrip.db");
                Toast.makeText(getApplicationContext(), R.string.db_delete_message,
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}