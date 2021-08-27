package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class LanguageSelection extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //move to avatar
    ImageView go_avatar;

    Locale locale;
    private final int Loc_Korean = 0;
    private final int Loc_Endlish = 1;

    Button korean,english;
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
        //언어 둘 중에 하나 골라야 컨티뉴 버튼 활성화 및 색 변경
        korean=findViewById(R.id.btn_chooseLanguage_Korean);
        english=findViewById(R.id.btn_chooseLanguage_English);

        korean.setOnClickListener(v->{
            changeLocale(Loc_Korean);
            korean.setBackgroundResource(R.drawable.round_edge_btn_click_color);
            english.setBackgroundResource(R.drawable.round_edge_btn_style);
            btn_continue.setEnabled(true);
            btn_continue.setBackgroundResource(R.drawable.oval_btn_color_style);
        });
        english.setOnClickListener(v->{
            changeLocale(Loc_Endlish);
            english.setBackgroundResource(R.drawable.round_edge_btn_click_color);
            korean.setBackgroundResource(R.drawable.round_edge_btn_style);
            btn_continue.setEnabled(true);
            btn_continue.setBackgroundResource(R.drawable.oval_btn_color_style);
        });

        //move to account details
        go_avatar = findViewById(R.id.go_avatar);
        //저장된 아바타 이미지 보여줌
        go_avatar.setBackgroundResource(User.point.getAvatar_image());
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,AccountDetails.class);
            //language selection page code = 1
            intent.putExtra("page_code",1);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

    }

    private void changeLocale(int localeLang){
        Locale locale = null;
        switch (localeLang){
            case 0:
                locale = new Locale("ko");
                break;

            case 1:
                locale = new Locale("en");
                break;
        }
        Configuration config = getApplicationContext().getResources().getConfiguration();
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 ) {
            config.setLocale(locale);
        }
        else {
            config.locale = locale;
        }
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}