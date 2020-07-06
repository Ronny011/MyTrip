package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity implements View.OnClickListener
{
    private Button search;
    private TextView emails;
    private EditText search_input;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = findViewById(R.id.btn_search);
        emails = findViewById(R.id.search_emails);
        search_input = findViewById(R.id.input_search);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String search = search_input.getText().toString();
        if (search.isEmpty())
        {
            try { throw new Exception("נא להקליד לפחות תו אחד"); }
            catch (Exception e)
            { Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show(); }
        }
        else {
            DbHelper helper = DbHelper.getInstance(this);
            Cursor cursor = helper.findName(search);
            if (cursor.getCount() == 0)
                emails.setText("לא נמצאו התאמות לחיפוש");
            else {
                StringBuilder buffer = new StringBuilder();
                while (cursor.moveToNext()) {
                    buffer.append(cursor.getString(1)).append("\n");
                }
                emails.setText(buffer);
            }
        }
    }
}