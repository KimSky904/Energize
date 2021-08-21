package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class SelectAvatar extends AppCompatActivity {

    //each avatar
    ImageButton avatar_1,avatar_2,avatar_3,avatar_4,avatar_5,avatar_6,avatar_7,avatar_8;
    //back to previous page
    Button Btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_selector);

        //each avatars
        avatar_1 = findViewById(R.id.avatar_1);
        avatar_2 = findViewById(R.id.avatar_2);
        avatar_3 = findViewById(R.id.avatar_3);
        avatar_4 = findViewById(R.id.avatar_4);
        avatar_5 = findViewById(R.id.avatar_5);
        avatar_6 = findViewById(R.id.avatar_6);
        avatar_7 = findViewById(R.id.avatar_7);
        avatar_8 = findViewById(R.id.avatar_8);

        Btn_back = findViewById(R.id.Btn_back);
        Btn_back.setOnClickListener(v -> {
            Intent fromPage = getIntent();
            int pageCode = fromPage.getIntExtra("page_code",1);

            switch (pageCode){
                // page code 1 : LanguageSelection
                // page code 2 : ThemeSelection
                // page code 3 : Theme_Solar
                // page code 4 : Theme_Hydro
                // page code 5 : Theme_Wind
                // page code 6 : Theme_Geo
                // page code 7 : ResultScreen
                case 1 :
                    startActivity(new Intent(this, LanguageSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 2 :
                    startActivity(new Intent(this, ThemeSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 3 :
                    int pageNumber_solar = fromPage.getIntExtra("question_number",0);
                    Intent intent_solar = new Intent(this, Theme_Solar.class);
                    intent_solar.putExtra("question_number",pageNumber_solar);
                    startActivity(intent_solar);
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 4 :
                    int pageNumber_hydro = fromPage.getIntExtra("question_number",0);
                    Intent intent_hydro = new Intent(this, Theme_Hydro.class);
                    intent_hydro.putExtra("question_number",pageNumber_hydro);
                    startActivity(intent_hydro);
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 5 :
                    int pageNumber_wind = fromPage.getIntExtra("question_number",0);
                    Intent intent_wind = new Intent(this, Theme_Wind.class);
                    intent_wind.putExtra("question_number",pageNumber_wind);
                    startActivity(intent_wind);
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 6 :
                    int pageNumber_geo = fromPage.getIntExtra("question_number",0);
                    Intent intent_geo = new Intent(this, Theme_Geo.class);
                    intent_geo.putExtra("question_number",pageNumber_geo);
                    startActivity(intent_geo);
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 7 :
                    Intent intent7 = new Intent(this,ResultScreen.class);
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
            }
        });

    }
}