package com.holdmyhand.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;


public class SelectAvatar_Dialog extends AppCompatActivity {

    ImageButton avatar1;
    ImageButton avatar2;
    ImageButton avatar3;
    ImageButton avatar4;

    ImageButton btn_choose_avatar;

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
        avatar1 = findViewById(R.id.btn_avatar_1);
        avatar2 = findViewById(R.id.btn_avatar_2);
        avatar3 = findViewById(R.id.btn_avatar_3);
        avatar4 = findViewById(R.id.btn_avatar_4);

        btn_choose_avatar=findViewById(R.id.btn_chooseAvatar);

        avatar1.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.avatar_1);
            MainActivity.btn_chooseAvatar_text.setVisibility(View.INVISIBLE);
            MainActivity.btn_chooseAvatar.setBackgroundResource(R.drawable.avatar_1);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.avatar_1);
            setResult(RESULT_OK, intent);
            finish();

        });
        avatar2.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.avatar_2);
            MainActivity.btn_chooseAvatar.setBackgroundResource(R.drawable.avatar_2);
            MainActivity.btn_chooseAvatar_text.setVisibility(View.INVISIBLE);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.avatar_2);
            setResult(RESULT_OK, intent);
            finish();
        });
        avatar3.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.avatar_3);
            MainActivity.btn_chooseAvatar_text.setVisibility(View.INVISIBLE);
            MainActivity.btn_chooseAvatar.setBackgroundResource(R.drawable.avatar_3);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.avatar_3);
            setResult(RESULT_OK, intent);
            finish();
        });
        avatar4.setOnClickListener(v->{
            User.point.setAvatar_image(R.drawable.avatar_4);
            MainActivity.btn_chooseAvatar_text.setVisibility(View.INVISIBLE);
            MainActivity.btn_chooseAvatar.setBackgroundResource(R.drawable.avatar_4);
            //intent
            Intent intent = new Intent();
            intent.putExtra("selected_avatar",R.drawable.avatar_4);
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