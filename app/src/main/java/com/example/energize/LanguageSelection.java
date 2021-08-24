package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class LanguageSelection extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //move to avatar
    ImageView go_avatar;
    //move to next page

    ToggleButton korean,english;

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

        //user setting check
        Log.d("myapp","포인트 : "+User.point.getPoint()+"");
        Log.d("myapp","사용자 이름 : "+User.point.getUser_name()+"");
        Log.d("myapp","아바타 : "+User.point.getAvatar_image()+"");



        //move to theme select screen
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),ThemeSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        //move to account details
        go_avatar = findViewById(R.id.go_avatar);
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,AccountDetails.class);
            //language selection page code = 1
            intent.putExtra("page_code",1);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        korean=findViewById(R.id.btn_chooseLanguage_Korean);
        english=findViewById(R.id.btn_chooseLanguage_English);
        korean.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //on
                    btn_continue.setEnabled(true);
                    btn_continue.setBackgroundResource(R.drawable.oval_btn_color_style);
                    korean.setBackgroundResource(R.drawable.round_edge_btn_click_color);
                    english.setEnabled(false);
                }
                else {
                    //off
                    btn_continue.setBackgroundResource(R.drawable.oval_btn_style);
                    btn_continue.setEnabled(false);
                    korean.setBackgroundResource(R.drawable.round_edge_btn_style);
                    english.setEnabled(true);
                }
            }
        });
        english.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //on
                    btn_continue.setEnabled(true);
                    btn_continue.setBackgroundResource(R.drawable.oval_btn_color_style);
                    english.setBackgroundResource(R.drawable.round_edge_btn_click_color);
                    korean.setEnabled(false);
                }
                else {
                    //off
                    btn_continue.setBackgroundResource(R.drawable.oval_btn_style);
                    btn_continue.setEnabled(false);
                    english.setBackgroundResource(R.drawable.round_edge_btn_style);
                    korean.setEnabled(true);
                }
            }
        });
    }
}