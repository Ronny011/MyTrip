package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    Adapter adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items= new ArrayList<>();
        items.add("נחל 1");
        items.add("נחל 2");
        items.add("נחל 3");
        items.add("נחל 4");
        items.add("נחל 5");
        items.add("נחל 6");
        items.add("נחל 7");
        items.add("נחל 8");

        rv= findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, items);
        rv.setAdapter(adapter);
    }
}
