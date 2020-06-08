package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט2", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט3", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט4", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט5", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט6", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט7", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));
        modelClassList.add(new ModelClass(R.drawable.nahal_shofet, "נחל השופט8", "הטיול מתאים למשפחות, חלקו אף סלול לעגלות" + " תמצאו בו כמה מסלולים בני 2-4 שעות, ובהם גם אחד מעגלי. "));





        Adapter adapter = new Adapter(modelClassList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
