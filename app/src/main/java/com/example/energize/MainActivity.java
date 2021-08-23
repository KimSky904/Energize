package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //bottom page animation
    RelativeLayout bottomPage;
    //continue button
    Button btn_continue;
    //choose avatar popup
    Button btn_chooseAvatar;
    //user name
    EditText editTxt_userName;

    //data saving file
    String shared = "file";
    //point object
    Point point;

    //activity 실행 요청 확인을 위한 요청코드
    static final int REQ_DIALOG_CONTACT = 1;

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

        //user name
        editTxt_userName = findViewById(R.id.editTxt_userName);
        //Choose avatar popup
        btn_chooseAvatar = findViewById(R.id.btn_chooseAvatar);
        btn_chooseAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SelectAvatar_Dialog.class);
            startActivityForResult(intent,REQ_DIALOG_CONTACT);
        });


        //move to select language screen
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(v -> {
            User.point.setUser_name(editTxt_userName.getText().toString());
            Intent intent = new Intent(getApplicationContext(),LanguageSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
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
        if (requestCode == REQ_DIALOG_CONTACT) {
            if (resultCode == RESULT_OK) {
                //dialog 액티비티에서 이미지 리소스 네임 받아옴, 객체 avatar 설정
                int selectedAvatarResource = data.getIntExtra("selected_avatar",R.drawable.img_avatar_1);
                User.point.setAvatar_image(selectedAvatarResource);
            }
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

