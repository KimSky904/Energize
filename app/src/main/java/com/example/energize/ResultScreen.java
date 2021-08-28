package com.example.energize;

import android.content.Intent;
import android.content.SharedPreferences;
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
    //값 유지
    String shared = "file";
    int saving;
    PreferenceManager p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        //원형 버튼 텍스트
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);
        saving = User.point.getEachPoint();

        //get each points
        btn_chooseAvatar.setText(User.point.getEachPoint() + " out 20 points");
        //얻은 포인트 저장한다.
        p.setInt(this,"point",saving);


        //move to account details
        go_avatar = findViewById(R.id.go_avatar);
        //저장된 아바타 값 가져옴
        go_avatar.setBackgroundResource(User.point.getAvatar_image());
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
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });


    }
}