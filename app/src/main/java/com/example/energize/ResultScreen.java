package com.example.energize;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

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
        //move to theme select screen
        Button go_theme = (Button) findViewById(R.id.btn_continue);
        go_theme.setOnClickListener(v-> {
            Intent intent = new Intent(this,ThemeSelection.class);
            startActivity(intent);
        });
    }
}