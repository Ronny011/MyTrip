package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private boolean pressed = false;
    private boolean logged = false;
    private boolean light = true;
    RecyclerView recyclerView;

    @Override
    // show the settings overflow menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    // overflow menu "action listener"
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
                Log.d("CREATION", "button pressed");
                // user pressed the heart icon
                if(pressed)// if the heart icon is empty
                {
                    item.setIcon(R.drawable.sharp_favorite_black_18dp);
                    Log.d("CREATION", "changed to full");
                }
                else if(!pressed)
                    item.setIcon(R.drawable.sharp_favorite_border_black_18dp);
                Log.d("CREATION", "changed to empty");
                //invalidateOptionsMenu();
                return true;

            case R.id.action_favorites:
                return true;

            case R.id.action_login:
                return true;

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

    // toggle logged in status
    public void setLogged(boolean logged)
    {
        this.logged = logged;
    }

    // toggle app theme (light, dark)
    public void setLight(boolean light)
    {
        this.light = light;
    }

    @Override
    // which options are available as a function of the log in status
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        //invalidateOptionsMenu();
        if(!logged)
        {
            menu.removeItem(R.id.action_favorite);
            menu.removeItem(R.id.action_favorites);
            menu.removeItem(R.id.action_profile);
        }
        else
        {
            menu.removeItem(R.id.action_login);
            menu.removeItem(R.id.action_register);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setting the a tool bar as an action bar
        Toolbar action_bar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(action_bar);

        recyclerView = findViewById(R.id.rv);
        // setting a linear layout (vertical) for the recycle view
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        // filling the array list
        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.shofet_pic, getString(R.string.shofet_title),
                this.getResources().getString(R.string.shofet_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.dor_pic, getString(R.string.dor_title),
                this.getResources().getString(R.string.dor_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.sorek_pic, getString(R.string.sorek_title),
                this.getResources().getString(R.string.sorek_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.red_pic, getString(R.string.red_title),
                this.getResources().getString(R.string.red_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.ayun_pic, getString(R.string.ayun_title),
                this.getResources().getString(R.string.ayun_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.gedi_pic, getString(R.string.gedi_title),
                this.getResources().getString(R.string.gedi_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.ofir_pic, getString(R.string.ofir_title),
                this.getResources().getString(R.string.ofir_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.sharon_pic,  getString(R.string.sharon_title),
                this.getResources().getString(R.string.sharon_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.meron_pic,  getString(R.string.meron_title),
                this.getResources().getString(R.string.meron_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.snir_pic,  getString(R.string.snir_title),
                this.getResources().getString(R.string.snir_desc).substring(0,90) + "..."));
        modelClassList.add(new ModelClass(R.drawable.cave_pic,getString(R.string.cave_title),
                this.getResources().getString(R.string.cave_desc).substring(0,90) + "..."));
        // using the adapter class
        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
