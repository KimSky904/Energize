package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Theme_Solar extends AppCompatActivity {

    ImageView next_q2;
    RelativeLayout question1;
    RelativeLayout question2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_solar);

        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        question1 = findViewById(R.id.question1);
        question1.setVisibility(View.VISIBLE);
        question1.startAnimation(translateup);



        next_q2 = findViewById(R.id.next_q2);
        question2 = findViewById(R.id.question2);
        next_q2.setOnClickListener(v -> {
            question1.setVisibility(View.INVISIBLE);
            question2.setVisibility(View.VISIBLE);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_right);
            finish();
        });



    }
}