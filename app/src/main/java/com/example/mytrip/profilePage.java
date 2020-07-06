package com.example.mytrip;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profilePage extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        TextView user_email = (TextView) findViewById(R.id.user_email);
        ImageView avatar = (ImageView) findViewById(R.id.avatar);

        if (MainActivity.session_user.getImg() != null)
        {
            avatar.setImageBitmap(convertByteToBitmap(MainActivity.session_user.getImg()));
        }
        user_email.setText(MainActivity.session_user.getEmail());

    }

    private Bitmap convertByteToBitmap(byte[] byteImage) {
        return (Bitmap) BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
    }
}