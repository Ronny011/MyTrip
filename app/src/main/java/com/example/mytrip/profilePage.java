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
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        mTextView = (TextView) findViewById(R.id.text);
        avatar = (ImageView) findViewById(R.id.avatar);

        User new_user = new User("m@m.c", "", null, null);
//        Log.d(profilePage.class.getName(), helper.findUser(new_user));
//        avatar.setImageBitmap();
    }

    private Bitmap convertByteToBitmap(byte[] byteImage) {
        return (Bitmap) BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
    }
}