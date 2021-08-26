package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelectAvatar extends AppCompatActivity {

    //each avatar
    ImageButton avatar_1,avatar_2,avatar_3,avatar_4,avatar_5,avatar_6,avatar_7,avatar_8;
    //back to previous page
    ImageButton Btn_back;
    //point text
    Button btn_point;

    //아바타가 구매되어있는지 확인
    int[] isAvatarAvailable = {1,1,1,1,0,0,0,0};
    //아바타 배열
    int[] avatar = {R.drawable.img_avatar_1,R.drawable.img_avatar_2,R.drawable.img_avatar_3,R.drawable.img_avatar_4
            ,R.drawable.img_avatar_5,R.drawable.img_avatar_6,R.drawable.img_avatar_7,R.drawable.img_avatar_8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_selector);
        //set point
        btn_point = findViewById(R.id.btn_point);
        btn_point.setText(User.point.getPoint()+" Points");

        //each avatars
        avatar_1 = findViewById(R.id.avatar_1);
        avatar_2 = findViewById(R.id.avatar_2);
        avatar_3 = findViewById(R.id.avatar_3);
        avatar_4 = findViewById(R.id.avatar_4);
        avatar_5 = findViewById(R.id.avatar_5);
        avatar_6 = findViewById(R.id.avatar_6);
        avatar_7 = findViewById(R.id.avatar_7);
        avatar_8 = findViewById(R.id.avatar_8);

        Btn_back = findViewById(R.id.btn_back);
        Btn_back.setOnClickListener(v -> {
            Intent intent = new Intent(this,AccountDetails.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

    }
    public void buttonClicked(View view){
        int avatarCode = 1;
        switch(view.getId()){
            case R.id.avatar_1:
                avatarCode = 1;
                break;
            case R.id.avatar_2:
                avatarCode = 2;
                break;
            case R.id.avatar_3:
                avatarCode = 3;
                break;
            case R.id.avatar_4:
                avatarCode = 4;
                break;
            case R.id.avatar_5:
                avatarCode = 5;
                break;
            case R.id.avatar_6:
                avatarCode = 6;
                break;
            case R.id.avatar_7:
                avatarCode = 7;
                break;
            case R.id.avatar_8:
                avatarCode = 8;
                break;
            default: avatarCode = 1;
        }

        //구매되지 않은 아바타일 경우
        if(isAvatarAvailable[avatarCode-1]==0){
            //포인트 사용
            //잔여 포인트 부족할 때
            if(User.point.getPoint()<20){
                FailDialog alert = new FailDialog();
                alert.showDialog(SelectAvatar.this);
            }
            else{
                isAvatarAvailable[avatarCode-1]=1;
                User.point.usePoint(20);
                btn_point.setText(User.point.getPoint()+" POINTS");
                ViewDialog alert = new ViewDialog();
                alert.showDialog(SelectAvatar.this);
            }
        }
        //구매된 아바타일 경우
        else {
            User.point.setAvatar_image(avatar[avatarCode-1]);
        }
    }

    public class ViewDialog {
        public void showDialog(Activity activity) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_avatar_purchase_confirm_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            FrameLayout mDialogOk = dialog.findViewById(R.id.frmOk);
            mDialogOk.setOnClickListener(v -> {
                dialog.cancel();
            });

            dialog.show();
        }
    }

    public class FailDialog {
        public void showDialog(Activity activity) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_avatar_purchase_fail_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            FrameLayout mDialogNo = dialog.findViewById(R.id.frmNo);
            mDialogNo.setOnClickListener(v -> {
                dialog.dismiss();
            });

            dialog.show();
        }
    }
}