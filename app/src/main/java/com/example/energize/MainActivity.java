package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.lang.reflect.Modifier;


public class MainActivity extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //choose avatar popup
    Button btn_chooseAvatar;

    //userName EditText
    EditText txt_userName;

    //saving user name
    String userName;

    //data saving file
    String shared = "file";

    //point object
    Point point;

    //아바타 골라야 넘어감
    boolean chooseAvatar=false;


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


        txt_userName = findViewById(R.id.editTxt_userName);
        btn_continue = findViewById(R.id.btn_continue);
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);
        //Choose avatar popup
        btn_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SelectAvatar_Dialog.class);
            startActivityForResult(intent,1);
            chooseAvatar=true;
        });
        //userName 안채우면 버튼 비활성화
        txt_userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()>0 && chooseAvatar==true) {
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
        });




        User.point.setPoint(0);
/*
        // get shared preference data
        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        int point_number =sharedPreferences.getInt("point_number",0);
        point.setPoint(point_number);

 */

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Log.d("myapp",data.getStringExtra("selected_avatar")+"가 선택되었습니다.");

        }
    }

/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //sharedprefarence 호출해서 위의 set한 포인트 값 얻어오기
        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("point_number",point.getPoint());
        editor.commit();

    }

 */

}

