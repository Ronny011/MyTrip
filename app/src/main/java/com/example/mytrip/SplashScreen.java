package com.example.mytrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
// splash screen before main activity
public class SplashScreen extends Activity
{
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // no status bar, window title or action bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            // starting the main activity as a function of time
            public void run()
            {
                Intent intent = new Intent(SplashScreen.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        },750);// delay in milliseconds
    }
}
