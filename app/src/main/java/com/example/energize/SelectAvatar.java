package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
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

    //구매된 아바타인지, 미구매 아바타인지 구분
    int[] avatarIsAvailable = {1,1,1,1,0,0,0,0};
    //이미지파일 배열
    int[] avatar = {R.drawable.img_avatar_1,R.drawable.img_avatar_2,R.drawable.img_avatar_3,R.drawable.img_avatar_4,R.drawable.img_avatar_5,
            R.drawable.img_avatar_6,R.drawable.img_avatar_7,R.drawable.img_avatar_8};

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
            Log.d("myapp",User.point.getAvatar_image()+"가 선택됨");
            Intent intent = new Intent(this,AccountDetails.class);
            startActivity(intent);
        });

        //image resource return
        /*
        avatar_1.setOnClickListener(v -> {
            ViewDialog alert = new ViewDialog();
            alert.showDialog(SelectAvatar.this);
        });
        avatar_2.setOnClickListener(v -> {

        });
        avatar_3.setOnClickListener(v -> {

        });
        avatar_4.setOnClickListener(v -> {

        });
        avatar_5.setOnClickListener(v -> {

        });
        avatar_6.setOnClickListener(v -> {

        });
        avatar_7.setOnClickListener(v -> {

        });
        avatar_8.setOnClickListener(v -> {

        });

         */


    }

    public void buttonClicked(View view){
        int avatarId = 1;
        switch (view.getId()){
            case R.id.avatar_1:
                avatarId = 1;
                break;
            case R.id.avatar_2:
                avatarId = 2;
                break;
            case R.id.avatar_3:
                avatarId = 3;
                break;
            case R.id.avatar_4:
                avatarId = 4;
                break;
            case R.id.avatar_5:
                avatarId = 5;
                break;
            case R.id.avatar_6:
                avatarId = 6;
                break;
            case R.id.avatar_7:
                avatarId = 7;
                break;
            case R.id.avatar_8:
                avatarId = 8;
                break;
            default: avatarId=1;
        }
        //배열값이 1으로 되어있는 경우 avatar set
        if(avatarIsAvailable[avatarId]==1){
            User.point.setAvatar_image(avatar[avatarId]);
            Log.d("myapp","아바타가 "+User.point.getAvatar_image()+"로 변경됨");
        }

        //배열값이 0으로 되어있는 경우 구매확인 팝업 띄움 & 배열값 1로 변경
        else if(avatarIsAvailable[avatarId]==0){
            avatarIsAvailable[avatarId]=1;
            ViewDialog alert = new ViewDialog();
            alert.showDialog(SelectAvatar.this,avatarId);
        }

    }


    public class ViewDialog {

        public void showDialog(Activity activity,int avatarId) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_avatar_purchase_confirm_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

/*
            int avatarRes;
            switch (avatarId){
                case 1:
                    avatarRes = R.drawable.img_avatar_1;
                    break;
                case 2:
                    avatarRes = R.drawable.img_avatar_2;
                    break;
                case 3:
                    avatarRes = R.drawable.img_avatar_3;
                    break;
                case 4:
                    avatarRes = R.drawable.img_avatar_4;
                    break;
                case 5:
                    avatarRes = R.drawable.img_avatar_5;
                    break;
                case 6:
                    avatarRes = R.drawable.img_avatar_6;
                    break;
                case 7:
                    avatarRes = R.drawable.img_avatar_7;
                    break;
                case 8:
                    avatarRes = R.drawable.img_avatar_8;
                    break;
                default:
                    avatarRes = R.drawable.img_avatar_1;
            }

 */
            FrameLayout mDialogOk = dialog.findViewById(R.id.frmOk);
            mDialogOk.setOnClickListener(v ->  {
                Toast.makeText(getApplicationContext(),"Okay" ,Toast.LENGTH_SHORT).show();
                dialog.cancel();
            });

            dialog.show();
        }
    }
}