package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ThemeSelection extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //each theme button
    Button theme_solar;
    Button theme_hydro;
    Button theme_wind;
    Button theme_geo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);
        setTheme(R.style.AppTheme);

        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        bottomPage = findViewById(R.id.bottom_page);
        bottomPage.setVisibility(View.VISIBLE);
        bottomPage.startAnimation(translateup);


        theme_solar = findViewById(R.id.Btn_solar);
        theme_hydro = findViewById(R.id.Btn_hydroelectric);
        theme_wind = findViewById(R.id.Btn_wind);
        theme_geo = findViewById(R.id.Btn_geothermal);

//        //move to each theme activity(fragment)
//        theme_solar.setOnClickListener(v -> {
//            Intent intent = new Intent(this, Fragment_Solar.class);
//            startActivity(intent);
//            //starting activity animation
//            overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
//            finish();
//        });
//        theme_hydro.setOnClickListener(v -> {
//            Intent intent = new Intent(this, Fragment_Hydro.class);
//            startActivity(intent);
//            //starting activity animation
//            overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
//            finish();
//        });
//        theme_wind.setOnClickListener(v -> {
//            Intent intent = new Intent(this, Fragment_Wind.class);
//            startActivity(intent);
//            //starting activity animation
//            overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
//            finish();
//        });
//        theme_geo.setOnClickListener(v -> {
//            Intent intent = new Intent(this, Fragment_Geo.class);
//            startActivity(intent);
//            //starting activity animation
//            overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
//            finish();
//        });

        //            overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
        //            finish();
    }
}