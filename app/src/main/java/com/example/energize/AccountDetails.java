package com.example.energize;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountDetails extends AppCompatActivity {
    //bottom page animation
    RelativeLayout bottomPage;
    Button btn_back;
    //set point
    Button btn_point;
    //move to avatar selection
    Button btn_chooseAvatar;

    //change username -> back to page
    Button btn_change_username;
    //activity 실행 요청 확인을 위한 요청코드
    static final int REQ_AVATAR_CONTACT = 2;

    //move to
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        setTheme(R.style.AppTheme);


        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        bottomPage = findViewById(R.id.bottom_page);
        bottomPage.setVisibility(View.VISIBLE);
        bottomPage.startAnimation(translateup);

        //set point text
        btn_point = findViewById(R.id.btn_point);
        btn_point.setText(User.point.getPoint()+" Points");


        btn_back = findViewById(R.id.btn_back2);

        btn_back.setOnClickListener(v -> {
            Intent fromPage = getIntent();
            int pageCode = fromPage.getIntExtra("page_code",1);

            switch (pageCode){
                // page code 1 : LanguageSelection
                // page code 2 : ThemeSelection
                // page code 3 : ResultScreen
                case 1 :
                    startActivity(new Intent(this, LanguageSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 2 :
                    startActivity(new Intent(this, ThemeSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 3 :
                    startActivity(new Intent(this, ResultScreen.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
            }
        });
        //move to avatar selection
        btn_chooseAvatar=findViewById(R.id.btn_chooseAvatar);
        btn_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SelectAvatar.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });
        btn_change_username=findViewById(R.id.btn_change_username);
        btn_change_username.setOnClickListener(v -> {
            Intent fromPage = getIntent();
            int pageCode = fromPage.getIntExtra("page_code",1);

            switch (pageCode){
                // page code 1 : LanguageSelection
                // page code 2 : ThemeSelection
                // page code 3 : ResultScreen
                case 1 :
                    startActivity(new Intent(this, LanguageSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 2 :
                    startActivity(new Intent(this, ThemeSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 3 :
                    startActivity(new Intent(this, ResultScreen.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_AVATAR_CONTACT) {
            if (resultCode == RESULT_OK) {
                //dialog 액티비티에서 이미지 리소스 네임 받아옴, 객체 avatar 설정
                int selectedAvatarResource = data.getIntExtra("selected_avatar",R.drawable.img_avatar_1);
                User.point.setAvatar_image(selectedAvatarResource);
            }
        }
    }
}
