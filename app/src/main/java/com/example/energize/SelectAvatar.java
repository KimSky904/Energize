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
    ImageButton Btn_back;
    //point text
    Button btn_point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_selector);
        //set point
        btn_point = findViewById(R.id.btn_point);
        btn_point.setText(User.point.getPoint()+" Points");

        //each avatars
        avatar_1 = findViewById(R.id.avatar_1);
        avatar_2 = findViewById(R.id.avatar_2);
        avatar_3 = findViewById(R.id.avatar_3);
        avatar_4 = findViewById(R.id.avatar_4);
        avatar_5 = findViewById(R.id.avatar_5);
        avatar_6 = findViewById(R.id.avatar_6);
        avatar_7 = findViewById(R.id.avatar_7);
        avatar_8 = findViewById(R.id.avatar_8);

        Btn_back = findViewById(R.id.btn_back);
        Btn_back.setOnClickListener(v -> {
            Intent intent = new Intent(this,AccountDetails.class);
            startActivity(intent);
        });

        //image resource return
        avatar_1.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_1);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_2.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_2);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_3.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_3);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_4.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_4);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_5.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_5);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_6.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_6);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_7.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_7);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });
        avatar_8.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(this,AccountDetails.class);
            intent.putExtra("selected_avatar",R.drawable.img_avatar_8);
            setResult(RESULT_OK, intent);
            startActivity(intent);
        });


    }
}