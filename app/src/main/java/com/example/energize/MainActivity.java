package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //choose avatar popup
    Button btn_chooseAvatar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove splash theme
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        bottomPage = findViewById(R.id.bottom_page);
        bottomPage.setVisibility(View.VISIBLE);
        bottomPage.startAnimation(translateup);

        //Choose avatar popup
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);
        btn_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SelectAvatar.class);
            startActivityForResult(intent,1);
        });


        //move to select language screen
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Log.d("myapp",data.getStringExtra("selected_avatar")+"가 선택되었습니다.");

        }
    }

}

