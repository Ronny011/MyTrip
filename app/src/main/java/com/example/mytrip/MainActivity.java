package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar action_bar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(action_bar);

        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.shofet_pic, getString(R.string.shofet_title),
                this.getResources().getString(R.string.shofet_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.dor_pic, getString(R.string.dor_title),
                this.getResources().getString(R.string.dor_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.sorek_pic, getString(R.string.sorek_title),
                this.getResources().getString(R.string.sorek_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.red_pic, getString(R.string.red_title),
                this.getResources().getString(R.string.red_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.ayun_pic, getString(R.string.ayun_title),
                this.getResources().getString(R.string.ayun_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.gedi_pic, getString(R.string.gedi_title),
                this.getResources().getString(R.string.gedi_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.ofir_pic, getString(R.string.ofir_title),
                this.getResources().getString(R.string.ofir_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.sharon_pic,  getString(R.string.sharon_title),
                this.getResources().getString(R.string.sharon_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.meron_pic,  getString(R.string.meron_title),
                this.getResources().getString(R.string.meron_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.snir_pic,  getString(R.string.snir_title),
                this.getResources().getString(R.string.snir_desc).substring(0,75) + "..."));
        modelClassList.add(new ModelClass(R.drawable.cave_pic,getString(R.string.cave_title),
                this.getResources().getString(R.string.cave_desc).substring(0,75) + "..."));

        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
