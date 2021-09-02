package com.holdmyhand.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.holdmyhand.energize.R;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startSplash();

        logo = findViewById(R.id.img_logo);

    }
    void startSplash() {
        Handler handler = new Handler();
        handler.postDelayed((Runnable) () -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
            }, 3000);
    }

}