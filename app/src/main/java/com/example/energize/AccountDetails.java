package com.example.energize;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountDetails extends AppCompatActivity {
    //bottom page animation
    RelativeLayout bottomPage;
    ImageButton btn_back;
    //set point
    Button btn_point;
    //move to avatar selection
    Button btn_chooseAvatar;
    //editText 채워야 버튼 활성화
    EditText Change_userName;

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


        btn_back = findViewById(R.id.btn_back);
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

        //이름 넣는 칸이 빈칸이면 버튼 비활성화
        Change_userName=findViewById(R.id.editTxt_userName);
        Change_userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                //빈칸이 아니면 버튼 활성화 및 이전페이지 이동
                if(s.length()>0) {
                    btn_change_username.setClickable(true);
                    btn_change_username.setBackgroundResource(R.drawable.oval_btn_style);
                    //move to before page
                    btn_change_username.setOnClickListener(v -> {
                        Intent fromPage = getIntent();
                        int pageCode = fromPage.getIntExtra("page_code",1);

                        switch (pageCode){
                            // page code 1 : LanguageSelection
                            // page code 2 : ThemeSelection
                            // page code 3 : ResultScreen
                            case 1 :
                                startActivity(new Intent(v.getContext(), LanguageSelection.class));
                                //starting activity animation
                                overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                                finish();
                                break;
                            case 2 :
                                startActivity(new Intent(v.getContext(), ThemeSelection.class));
                                //starting activity animation
                                overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                                finish();
                                break;
                            case 3 :
                                startActivity(new Intent(v.getContext(), ResultScreen.class));
                                //starting activity animation
                                overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                                finish();
                                break;
                        }
                    });
                }
                else{
                    btn_change_username.setClickable(false);
                }
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
