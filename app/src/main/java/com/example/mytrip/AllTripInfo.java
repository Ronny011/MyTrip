package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class AllTripInfo extends AppCompatActivity {

    TextView tvTile;
    TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trip_info);


        tvTile = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);

        Intent i = getIntent();
        int nTripId = i.getIntExtra("tripId", 0);

        String strTitle= GetTripTitle(nTripId);
        tvTile.setText(strTitle);

        String strInformation = GetTripInfo(nTripId);
        tvDesc.setText(strInformation);


    }


    private String GetTripInfo(int nTripId) {
        String strInfo = "";
        switch (nTripId) {
            case 0:
                strInfo = "בדיקה 0 בדיקה 0 בדיקה 0";
                break;

            case 1:
                strInfo = "בדיקה 1 בדיקה 1 בדיקה 1";
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

            case 6:

                break;
            case 7:

                break;
            case 8:

                break;

            case 9:

                break;


            case 10:

                break;


            case 11:

                break;


            case 12:

                break;



        }

        return strInfo;
    }


    private String GetTripTitle(int nTripId) {
        String strTitle = "";
        switch (nTripId) {
            case 0:
                strTitle = "בדיקה 0 בדיקה 0 בדיקה 0 כותרת כותרת";
                break;

            case 1:
                strTitle = "בדיקה 1 בדיקה 1 בדיקה 1 כותרת כותרת";
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

                case 6:

                break;
            case 7:

                break;
            case 8:

                break;

            case 9:

                break;


            case 10:

                break;


            case 11:

                break;


            case 12:

                break;

        }

        return strTitle;
    }


}
