package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelectAvatar_Dialog extends AppCompatActivity {

    ImageButton avatar1;
    ImageButton avatar2;
    ImageButton avatar3;
    ImageButton avatar4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //transparent background corner
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //remove status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_avator_selector_dialog);


        //each buttons
        avatar1 = findViewById(R.id.avatar_1);
        avatar2 = findViewById(R.id.avatar_2);
        avatar3 = findViewById(R.id.avatar_3);
        avatar4 = findViewById(R.id.avatar_4);



        avatar1.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.img_avatar_1);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.img_avatar_1);
            setResult(RESULT_OK, intent);
            finish();
        });
        avatar2.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.img_avatar_2);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.img_avatar_2);
            setResult(RESULT_OK, intent);
            finish();
        });
        avatar3.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.img_avatar_3);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.img_avatar_3);
            setResult(RESULT_OK, intent);
            finish();
        });
        avatar4.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.img_avatar_4);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.img_avatar_4);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()== MotionEvent.ACTION_OUTSIDE)
            return false;
        else
            return true;
    }
    @Override
    public void onBackPressed(){
    }
}