package com.example.mytrip;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profilePage extends AppCompatActivity {

    private ImageView avatar;
    private TextView user_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        user_email = (TextView) findViewById(R.id.user_email);
        avatar = (ImageView) findViewById(R.id.avatar);


        User user = MainActivity.session_user;
        if (user.getImg() != null) {
            avatar.setImageBitmap(convertByteToBitmap(user.getImg()));
        }
        user_email.setText(user.getEmail());

    }

    private Bitmap convertByteToBitmap(byte[] byteImage) {
        return (Bitmap) BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
    }
}