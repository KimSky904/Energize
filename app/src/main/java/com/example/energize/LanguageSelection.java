package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class LanguageSelection extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //move to avatar
    ImageButton go_avatar;
    //move to next page
    Button btn_korean, btn_english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);
        setTheme(R.style.AppTheme);

        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        bottomPage = findViewById(R.id.bottom_page);
        bottomPage.setVisibility(View.VISIBLE);
        bottomPage.startAnimation(translateup);

        //move to theme select screen
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ThemeSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        //move to theme select screen
        btn_english = findViewById(R.id.btn_chooseLanguage_English);
        btn_english.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ThemeSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        //move to theme select screen
        btn_korean = findViewById(R.id.btn_chooseLanguage_Korean);
        btn_korean.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ThemeSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

        //move to avatar select page
        go_avatar = findViewById(R.id.go_avatar);
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,SelectAvatar.class);
            //language selection page code = 1
            intent.putExtra("page_code",1);
            startActivity(intent);
        });

    }
}