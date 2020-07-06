package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AllTripInfo extends AppCompatActivity
{
    private TextView tvLink;
    private String full_text = "";
    private TextView tvDesc;
    private TextView tvTitle;
    private int nID = -1;
    private static boolean pressed = false;
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Intent settings = new Intent(this, Settings.class);
                startActivity(settings);
                return true;

            case R.id.action_favorite:
                pressed = !pressed;
                // user pressed the heart icon
                if(pressed)
                {
                    item.setIcon(R.drawable.sharp_favorite_black_18dp);
                    MainActivity.favs.add(nID);
                    Toast.makeText(getApplicationContext(), String.valueOf(MainActivity.favs), Toast.LENGTH_SHORT).show();
                }
                else if(!pressed)
                {
                    item.setIcon(R.drawable.sharp_favorite_border_black_18dp);
                    MainActivity.favs.remove(Integer.valueOf(nID));
                    Toast.makeText(getApplicationContext(), String.valueOf(MainActivity.favs), Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.action_favorites:
                return true;

            case R.id.action_login:
                Intent login = new Intent(this, Login.class);
                startActivity(login);
                return false;

            case R.id.action_profile:
                return true;

            case R.id.action_register:
                Intent register = new Intent(this, Register.class);
                startActivity(register);
                return false;

            case R.id.action_search:
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem favorite = menu.findItem(R.id.action_favorite);
        MenuItem favorites = menu.findItem(R.id.action_favorites);
        MenuItem profile = menu.findItem(R.id.action_profile);
        MenuItem search = menu.findItem(R.id.action_search);
        MenuItem login = menu.findItem(R.id.action_login);
        MenuItem register = menu.findItem(R.id.action_register);
        MenuItem settings = menu.findItem(R.id.action_settings);
        favorites.setVisible(false);
        favorite.setVisible(MainActivity.getLogged());
        profile.setVisible(false);
        search.setVisible(false);
        login.setVisible(!MainActivity.getLogged());
        register.setVisible(!MainActivity.getLogged());
        settings.setVisible(false);
        if(!MainActivity.favs.isEmpty())
        {
            if (MainActivity.favs.contains(nID)) {
                if (pressed) {
                    favorite.setIcon(R.drawable.sharp_favorite_black_18dp);
                }
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trip_info);

        Toast.makeText(getApplicationContext(), String.valueOf(MainActivity.favs), Toast.LENGTH_SHORT).show();//

        // setting the a tool bar as an action bar
        Toolbar action_bar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(action_bar);

        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setTypeface(null, Typeface.BOLD);
        tvDesc = findViewById(R.id.tv_desc);
        tvLink = findViewById(R.id.tv_link);
        final Button more = findViewById(R.id.more_button);

        Intent i = getIntent();
        nID = i.getIntExtra("tripId", 0);
        if(!MainActivity.favs.isEmpty())
        {
            if (MainActivity.favs.contains(nID))
            {
                pressed = true;
            }
        }


        GetTripInfo(nID);

        more.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                tvDesc.setText(full_text);
                more.setVisibility(View.GONE);
            }
        });
    }

    // switch case for filling the second activity with the relevant information
    private void GetTripInfo(int nTripId)
    {
        final int length = 650;// length of trip description
        int description = R.string.app_name;// default string
        switch (nTripId)
        {
            case 0:
                description = R.string.shofet_desc;// for use with general functions at the bottom
                tvTitle.setText(R.string.shofet_title);
                tvLink.setText(R.string.shofet_link);
                break;

            case 1:
                description = R.string.dor_desc;
                tvTitle.setText(R.string.dor_title);
                tvLink.setText(R.string.dor_link);
                break;

            case 2:
                description = R.string.sorek_desc;
                tvTitle.setText(R.string.sorek_title);
                tvLink.setText(R.string.sorek_link);
                break;

            case 3:
                description = R.string.red_desc;
                tvTitle.setText(R.string.red_title);
                tvLink.setText(R.string.red_link);
                break;

            case 4:
                description = R.string.ayun_desc;
                tvTitle.setText(R.string.ayun_title);
                tvLink.setText(R.string.ayun_link);
                break;

            case 5:
                description = R.string.gedi_desc;
                tvTitle.setText(R.string.gedi_title);
                tvLink.setText(R.string.gedi_link);
                break;

            case 6:
                description = R.string.ofir_desc;
                tvTitle.setText(R.string.ofir_title);
                tvLink.setText(R.string.ofir_link);
                break;

            case 7:
                description = R.string.sharon_desc;
                tvTitle.setText(R.string.sharon_title);
                tvLink.setText(R.string.sharon_link);
                break;

            case 8:
                description = R.string.meron_desc;
                tvTitle.setText(R.string.meron_title);
                tvLink.setText(R.string.meron_link);
                break;

            case 9:
                description = R.string.snir_desc;
                tvTitle.setText(R.string.snir_title);
                tvLink.setText(R.string.snir_link);
                break;

            case 10:
                description = R.string.cave_desc;
                tvTitle.setText(R.string.cave_title);
                tvLink.setText(R.string.cave_link);
                break;
        }

        // full string and substring are saved for switching
        full_text = this.getResources().getString(description);
        tvDesc.setText(this.getResources().getString(description).substring(0, length));
        tvLink.setMovementMethod(LinkMovementMethod.getInstance());// "linkify"
    }
}
