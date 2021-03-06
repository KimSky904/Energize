package com.holdmyhand.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
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

import java.util.Locale;


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

    //이름 입력해야 넘어감
    boolean writeText=false;

    //언어
    Locale locale;

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

        btn_chooseAvatar_text = findViewById(R.id.btn_chooseAvatar_text);
        txt_userName = findViewById(R.id.editTxt_userName);
        btn_continue = findViewById(R.id.btn_continue);
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);

        //기본 언어 지정
        changeLocale();

        // 지난번 저장해놨던 사용자 입력값을 꺼내서 보여주기 & 아바타
        int ava = PreferenceManager.getPreferences(this).getInt("avatar",R.drawable.avatar_1);
        User.point.setAvatar_image(ava);

        //포인트 설정
        int points;
        if(User.p.getInt(this,"point")!=-1){
            points = User.p.getInt(this,"point");
            User.point.setPoint(points);
        }
        else {
            User.p.setInt(this,"point",0);
            points = User.p.getInt(this,"point");
            User.point.setPoint(points);
        }


        //아바타 설정
        if(User.point.getAvatar_image()!=0){
            btn_chooseAvatar_text.setVisibility(View.INVISIBLE);
            btn_chooseAvatar.setBackgroundResource(User.point.getAvatar_image());
            //컨티뉴 활성화
            checkContinueIsAble();
        }

        //이름
        String str = User.p.getString(this,"name");
        txt_userName.setText(str); // EditText에 반영함
        User.point.setUser_name(str);
        if(!str.isEmpty()) writeText=true;
        else writeText=false;


        //컨티뉴 활성화
        checkContinueIsAble();
        //Choose avatar popup
        btn_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SelectAvatar_Dialog.class);
            startActivityForResult(intent,1);
        });

        //continue 버튼 클릭 시 userName 저장
        btn_continue.setOnClickListener(v->{
            //텍스트뷰로 들어온 이름 저장
            User.point.setUser_name(txt_userName.getText().toString());
            Intent intent = new Intent(getApplicationContext(),LanguageSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

        //사용자가 임의로 이름을 지웠을 경우 체크하여 버튼 비활성화
        //userName 안채우면 버튼 비활성화
        txt_userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()<=0) {
                    writeText = false;
                    //컨티뉴 비활성화
                    checkContinueIsAble();
                }
                else{
                    writeText = true;
                    //컨티뉴 활성화
                    checkContinueIsAble();
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int avatarImage = data.getIntExtra("selected_avatar",0);
            User.p.setInt(this,"avatar",avatarImage);
            User.point.setAvatar_image(avatarImage);
            txt_userName.setEnabled(true);
            checkContinueIsAble();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Activity 가 종료되기 전에 저장한다
        // SharedPreferences 에 설정값(특별히 기억해야할 사용자 값)을 저장하기
        //PreferenceManager.getPreferences(this).setInt(this,"avatar",R.drawable.avatar_1);
        SharedPreferences sf = PreferenceManager.getPreferences(this);
        SharedPreferences.Editor editor = sf.edit();//저장하려면 editor가 필요

        String str = txt_userName.getText().toString(); // 사용자가 입력한 값
        int ava = User.point.getAvatar_image();

        editor.putString("name", str); // 입력
        editor.putInt("avatar",ava);//아바타 저장
        editor.putInt("point",User.p.getInt(this,"point"));//아바타 저장
        editor.putString("xx", "xx"); // 입력
        editor.apply(); // 파일에 최종 반영함
    }

    private void checkContinueIsAble(){
        //change userName 비활성화 / 활성화
        if(writeText) {
            Log.d("myapp","통과함");
            btn_continue.setClickable(true);
            btn_continue.setBackgroundResource(R.drawable.oval_btn_color_style);
        }
        else{
            btn_continue.setClickable(false);
            btn_continue.setBackgroundResource(R.drawable.oval_btn_style);
        }
    }

    //언어 미리 지정
    private void changeLocale(){
        Locale locale = new Locale("en");
        Configuration config = getApplicationContext().getResources().getConfiguration();
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 ) config.setLocale(locale);
        else config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }
}

