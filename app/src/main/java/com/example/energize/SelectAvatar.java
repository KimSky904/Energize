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
            Intent intent = new Intent(this,AccountDetails.class);
            startActivity(intent);
        });

    }
}