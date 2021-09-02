package com.holdmyhand.energize;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.holdmyhand.energize.R;

public class AccountDetails extends AppCompatActivity {
    //bottom page animation
    RelativeLayout bottomPage;
    ImageButton btn_back;
    //set point
    Button btn_point;
    //move to avatar selection
    public static Button button_chooseAvatar;
    //메인에서 가져온 이름 넣어놓기
    EditText Change_userName;
    String userName="test";
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
        //저장된 포인트 꺼내옴
        //int point= User.p.getInt(this,"point");
        btn_point.setText(User.point.getPoint()+" Points");

        //get User name
        Change_userName=findViewById(R.id.editTxt_userName);


        // 지난번 저장해놨던 사용자 입력값을 꺼내서 보여주기 -> 어느 액티비티에서 변경하던 적용되어야함 : manager사용
        SharedPreferences sf = getSharedPreferences(userName, 0);
        String str = sf.getString("name", ""); // 키값으로 꺼냄
        Change_userName.setText(User.point.getUser_name().toString()); // EditText에 반영함

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
        button_chooseAvatar=findViewById(R.id.btn_chooseAvatar);
        //저장된 아바타 이미지를 가져옴
        button_chooseAvatar.setBackgroundResource(User.point.getAvatar_image());
        button_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SelectAvatar.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

        btn_change_username=findViewById(R.id.btn_change_username);
                    //move to before page
                    btn_change_username.setOnClickListener(v -> {
                        //아바타 적용
                        MainActivity.btn_chooseAvatar.setBackgroundResource(User.point.getAvatar_image());
                        //이름 적용
                        String changedName = Change_userName.getText().toString();
                        User.p.setString(this,"name",changedName);
                        User.point.setUser_name(changedName);
                        Log.d("myapp","p에 저장된 이름 : "+User.p.getString(this,"name"));
                        Log.d("myapp","point에 저장된 이름 : "+User.point.getUser_name());

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_AVATAR_CONTACT) {
            if (resultCode == RESULT_OK) {
                //dialog 액티비티에서 이미지 리소스 네임 받아옴, 객체 avatar 설정
                int selectedAvatarResource = data.getIntExtra("selected_avatar",R.drawable.avatar_1);
                User.point.setAvatar_image(selectedAvatarResource);
            }
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        // Activity 가 종료되기 전에 저장한다
        // SharedPreferences 에 설정값(특별히 기억해야할 사용자 값)을 저장하기
        SharedPreferences sf = getSharedPreferences(User.point.getUser_name(), 0);
        SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
        String str = Change_userName.getText().toString(); // 사용자가 입력한 값
        editor.putString("name", str); // 입력
        editor.putString("xx", "xx"); // 입력
        editor.commit(); // 파일에 최종 반영함
    }


}



