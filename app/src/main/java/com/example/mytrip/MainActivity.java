package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static boolean logged = false;
    RecyclerView recyclerView;

    @Override
    // show the settings overflow menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    // overflow menu "action listener"
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // user selected settings

                return true;

            case R.id.action_favorite:
                // user pressed the heart icon
                // as a favorite...
                return true;

            case R.id.action_favorites:
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
