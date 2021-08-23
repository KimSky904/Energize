package com.example.energize;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultScreen extends AppCompatActivity {

    //move to avatar
    ImageView go_avatar;
    //move to theme selection
    Button go_theme;
    //text of acquired point
    Button btn_chooseAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        //get each points
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);
        btn_chooseAvatar.setText(User.point.getEachPoint()+" out 20 points");
        User.point.initialThemePoint();


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
        go_theme = (Button) findViewById(R.id.btn_done);
        go_theme.setOnClickListener(v-> {
            Intent intent = new Intent(this,ThemeSelection.class);
            startActivity(intent);
        });
    }
}