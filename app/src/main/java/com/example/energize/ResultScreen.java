package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class ResultScreen extends AppCompatActivity {

    //move to avatar
    ImageButton go_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);


        //move to avatar select page
        go_avatar = findViewById(R.id.go_avatar);
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,SelectAvatar.class);
            //Result page code = 7
            intent.putExtra("page_code",7);
            startActivity(intent);
        });
    }
}