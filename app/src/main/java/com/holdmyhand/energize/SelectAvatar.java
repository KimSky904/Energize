package com.holdmyhand.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;


public class SelectAvatar extends AppCompatActivity {

    //each avatar
    ImageButton[] avatar_button = new ImageButton[8];
    //back to previous page
    ImageButton Btn_back;
    //point text
    Button btn_point;
    //아바타 배열
    int[] avatar = {R.drawable.avatar_1,R.drawable.avatar_2,R.drawable.avatar_3,R.drawable.avatar_4
            ,R.drawable.avatar_5,R.drawable.avatar_6,R.drawable.avatar_7,R.drawable.avatar_8};

    PreferenceManager p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avatar_selector);

        //set point
        btn_point = findViewById(R.id.btn_point);
        //btn_point.setText(p.getInt(this,"point")+" Points");
        btn_point.setText(User.point.getPoint()+" POINTS");

        //each avatars
        avatar_button[0] = findViewById(R.id.btn_avatar_1);
        avatar_button[1] = findViewById(R.id.btn_avatar_2);
        avatar_button[2] = findViewById(R.id.btn_avatar_3);
        avatar_button[3] = findViewById(R.id.btn_avatar_4);
        avatar_button[4] = findViewById(R.id.btn_avatar_5);
        avatar_button[5] = findViewById(R.id.btn_avatar_6);
        avatar_button[6] = findViewById(R.id.btn_avatar_7);
        avatar_button[7] = findViewById(R.id.btn_avatar_8);

        //구매되지 않은 아이콘 잠금처리
        for(int i=4;i<8;i++){
            if(!User.p.getBoolean(this,"avatar_button["+i+"]")) {
                avatar_button[i].setImageResource(R.drawable.materialed_round_btn);
            }
        }

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
        int avatarCode = 0;
        switch(view.getId()){
            case R.id.btn_avatar_1:
                avatarCode = 1;
                break;
            case R.id.btn_avatar_2:
                avatarCode = 2;
                break;
            case R.id.btn_avatar_3:
                avatarCode = 3;
                break;
            case R.id.btn_avatar_4:
                avatarCode = 4;
                break;
            case R.id.btn_avatar_5:
                avatarCode = 5;
                break;
            case R.id.btn_avatar_6:
                avatarCode = 6;
                break;
            case R.id.btn_avatar_7:
                avatarCode = 7;
                break;
            case R.id.btn_avatar_8:
                avatarCode = 8;
                break;
            default: avatarCode = 0;
        }

        //기본 아바타
        User.p.setBoolean(this,"avatar_button[0]",true);
        User.p.setBoolean(this,"avatar_button[1]",true);
        User.p.setBoolean(this,"avatar_button[2]",true);
        User.p.setBoolean(this,"avatar_button[3]",true);

        //구매되지 않은 아바타일 경우
        if(!User.p.getBoolean(this,"avatar_button["+(avatarCode-1)+"]")){
            Log.d("myapp","아바타 구매 x");
            //잔여 포인트 부족할 때
            if(User.p.getInt(this,"point")<20){
                Log.d("myapp","포인트 부족");
                FailDialog alert = new FailDialog();
                alert.showDialog(SelectAvatar.this);
            }
            //잔여 포인트 있을 때
            else{
                Log.d("myapp","포인트 있을 때");
                //User.point.setAvatar_available(avatarCode-1);
                //영구 소장 가능
                User.p.setBoolean(this,"avatar_button["+(avatarCode-1)+"]",true);
                //포인트 사용
                User.point.usePoint(20);
                Log.d("myapp","구매 후 잔액 : "+User.point.getPoint());
                btn_point.setText(User.point.getPoint()+" POINTS");
                //잔액 p에 저장
                User.p.setInt(this,"point",User.point.getPoint());
                //성공 팝업 띄움
                ViewDialog alert = new ViewDialog();
                alert.showDialog(SelectAvatar.this);
                //이미지 띄움
                Log.d("myapp","이미지 저장22");
                AccountDetails.button_chooseAvatar.setBackgroundResource(User.point.getAvatar_image());
                avatar_button[avatarCode-1].setImageResource(avatar[avatarCode-1]);
                User.point.setAvatar_image(avatar[avatarCode-1]);
                User.p.setInt(this,"avatar",avatar[avatarCode-1]); //아바타 코드를 가져가서 배열 방의 아바타 이미지 저장
            }
        }
        //구매된 아바타일 경우
        else {
            Log.d("myapp","이미 구매됨");
            if(User.p.getBoolean(this,"avatar_button["+(avatarCode-1)+"]"))
                //둘다 아바타 이미지 저장
                User.point.setAvatar_image(avatar[avatarCode-1]);
                Log.d("myapp","이미지 저장");
                Log.d("myapp",avatar[avatarCode-1]+"");
                User.p.setInt(this,"avatar",avatar[avatarCode-1]);
                AccountDetails.button_chooseAvatar.setBackgroundResource(avatar[avatarCode-1]);
                SelectedDialog selectedDialog = new SelectedDialog();
                selectedDialog.showDialog(SelectAvatar.this);
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

    public class SelectedDialog{
        public void showDialog(Activity activity) {
            final Dialog dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.activity_avatar_is_selected_dialog);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            FrameLayout mDialogOk = dialog.findViewById(R.id.frmOk);
            mDialogOk.setOnClickListener(v -> {
                dialog.cancel();
            });

            dialog.show();
        }
    }
}