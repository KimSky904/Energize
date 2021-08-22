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


        //move to account details
        go_avatar = findViewById(R.id.go_avatar);
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,AccountDetails.class);
            //Result page code = 3
            intent.putExtra("page_code",3);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        //move to theme select screen
        Button go_theme = (Button) findViewById(R.id.btn_continue);
        go_theme.setOnClickListener(v-> {
            Intent intent = new Intent(this,ThemeSelection.class);
            startActivity(intent);

        });
    }
}