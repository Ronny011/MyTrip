package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Favorites extends AppCompatActivity implements View.OnClickListener {
    TextView list;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        save = findViewById(R.id.btn_save_favs);
        save.setOnClickListener(this);
        list = findViewById(R.id.all_favorites);
        StringBuilder temp = new StringBuilder();
        for (int i =0; i<MainActivity.favs.size(); i++)
            switch(MainActivity.favs.get(i))
            {
                case 0:
                    temp.append(getResources().getString(R.string.shofet_title));
                    temp.append("\n");
                    break;

                case 1:
                    temp.append(getResources().getString(R.string.dor_title));
                    temp.append("\n");
                    break;

                case 2:
                    temp.append(getResources().getString(R.string.sorek_title));
                    temp.append("\n");
                    break;

                case 3:
                    temp.append(getResources().getString(R.string.red_title));
                    temp.append("\n");
                    break;

                case 4:
                    temp.append(getResources().getString(R.string.ayun_title));
                    temp.append("\n");
                    break;

                case 5:
                    temp.append(getResources().getString(R.string.gedi_title));
                    temp.append("\n");
                    break;

                case 6:
                    temp.append(getResources().getString(R.string.ofir_title));
                    temp.append("\n");
                    break;

                case 7:
                    temp.append(getResources().getString(R.string.sharon_title));
                    temp.append("\n");
                    break;

                case 8:
                    temp.append(getResources().getString(R.string.meron_title));
                    temp.append("\n");
                    break;

                case 9:
                    temp.append(getResources().getString(R.string.snir_title));
                    temp.append("\n");
                    break;

                case 10:
                    temp.append(getResources().getString(R.string.cave_title));
                    temp.append("\n");
                    break;
            }
        list.setText(temp.toString());
    }

    @Override
    public void onClick(View v) {
        DbHelper helper = DbHelper.getInstance(this);
        helper.addOrUpdateUser(MainActivity.session_user);
        Toast.makeText(getApplicationContext(), "נשמר בהצלחה", Toast.LENGTH_SHORT).show();
    }
}