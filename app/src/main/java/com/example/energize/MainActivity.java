package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.preference.Preference;
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
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Modifier;


public class MainActivity extends AppCompatActivity {


    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //choose avatar popup
    //ImageButton btn_chooseAvatar;
    public static ImageButton btn_chooseAvatar;
    public static TextView btn_chooseAvatar_text;

    //userName EditText
    EditText txt_userName;

    //data saving file
    String shared = "file";
    String userName="test";

    //point object
    Point point;

    //아바타 골라야 넘어감
    boolean chooseAvatar; //=false;
    //이름 입력해야 넘어감
    boolean writeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove splash theme
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        //bottom page animation
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        bottomPage = findViewById(R.id.bottom_page);
        bottomPage.setVisibility(View.VISIBLE);
        bottomPage.startAnimation(translateup);

        Log.d("myapp",User.point.getAvatar_image()+"");

        btn_chooseAvatar_text = findViewById(R.id.btn_chooseAvatar_text);
        txt_userName = findViewById(R.id.editTxt_userName);
        btn_continue = findViewById(R.id.btn_continue);
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);

        // 지난번 저장해놨던 사용자 입력값을 꺼내서 보여주기
        SharedPreferences sf = getSharedPreferences(userName, 0);
        String str = sf.getString("name", ""); // 키값으로 꺼냄
        txt_userName.setText(str); // EditText에 반영함
        if(!txt_userName.getText().equals("")) writeText=true;
        else writeText=false;

        Log.d("myapp",writeText+"");
        Log.d("myapp",User.point.getAvatar_image()+"");
        User.point.setUser_name(str);

        //컨티뉴 활성화
        checkContinueIsAble();

        if(User.point.getAvatar_image()!=0) btn_chooseAvatar.setBackgroundResource(User.point.getAvatar_image());
        //Choose avatar popup
        btn_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SelectAvatar_Dialog.class);
            startActivityForResult(intent,1);
            //btn_chooseAvatar.setBackgroundResource(User.point.getAvatar_image());
            chooseAvatar=true;
            txt_userName.setEnabled(true);
        });



        //기본값은 공백으로
        User.point.setUser_name("");

        //continue 버튼 클릭 시 userName 저장
        btn_continue.setOnClickListener(v->{
            //텍스트뷰로 들어온 이름 저장
            User.point.setUser_name(txt_userName.getText().toString());
        });

        User.point.setPoint(0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Log.d("myapp","아바타 선택 종료됨");
            User.point.setAvatar_image(data.getIntExtra("selected_avatar",0));
            Log.d("myapp","->"+User.point.getAvatar_image()+"");
            checkContinueIsAble();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Activity 가 종료되기 전에 저장한다
        // SharedPreferences 에 설정값(특별히 기억해야할 사용자 값)을 저장하기
        SharedPreferences sf = getSharedPreferences(userName, 0);
        SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요
        String str = txt_userName.getText().toString(); // 사용자가 입력한 값
        editor.putString("name", str); // 입력
        User.point.setUser_name(str); //객체에 이름 저장
        editor.putString("xx", "xx"); // 입력
        editor.commit(); // 파일에 최종 반영함
    }

    private void checkContinueIsAble(){
        //change userName 비활성화 / 활성화
        if(User.point.getAvatar_image()!=0&&writeText) {
            btn_continue.setClickable(true);
            btn_continue.setBackgroundResource(R.drawable.oval_btn_color_style);
            //move to select language screen
            btn_continue.setOnClickListener(v -> {
                Intent intent = new Intent(getApplicationContext(),LanguageSelection.class);
                startActivity(intent);
                //starting activity animation
                overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                finish();
            });
        }
        else{
            btn_continue.setClickable(false);
            btn_continue.setBackgroundResource(R.drawable.oval_btn_style);
        }
    }
}

