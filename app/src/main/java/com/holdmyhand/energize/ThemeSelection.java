package com.holdmyhand.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class ThemeSelection extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //each theme button
    Button theme_solar;
    Button theme_hydro;
    Button theme_wind;
    Button theme_geo;
    //back button
    ImageButton btn_back;
    //move to avatar
    ImageView go_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_selection);
        setTheme(R.style.AppTheme);

        //얻은 점수 초기화
        User.point.initialThemePoint();
        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        bottomPage = findViewById(R.id.bottom_page);
        bottomPage.setVisibility(View.VISIBLE);
        bottomPage.startAnimation(translateup);

        theme_solar = findViewById(R.id.Btn_solar);
        theme_hydro = findViewById(R.id.Btn_hydroelectric);
        theme_wind = findViewById(R.id.Btn_wind);
        theme_geo = findViewById(R.id.Btn_geothermal);

        //move to each theme activity(fragment)
        theme_solar.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThemeSolar.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        theme_hydro.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThemeHydro.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        theme_wind.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThemeWind.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        theme_geo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ThemeGeo.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });


        btn_back = findViewById(R.id.btn_back);
        //move to sign in activity (mainactivity)
        btn_back.setOnClickListener(v -> {
            Intent intent = new Intent(this,LanguageSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });


        //move to account details
        go_avatar = findViewById(R.id.go_avatar);
        //저장된 이미지 가져오기
        go_avatar.setBackgroundResource(User.point.getAvatar_image());
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,AccountDetails.class);
            //Theme selection page code = 2
            intent.putExtra("page_code",2);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
    }
}