package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Theme_Solar extends AppCompatActivity {

    //previous / next button
    ImageView previous;
    ImageView next;
    //back button
    Button btn_back;
    //question
    RelativeLayout question1;
    RelativeLayout question2;
    RelativeLayout question3;
    RelativeLayout question4;
    RelativeLayout question5;
    RelativeLayout question6;
    RelativeLayout question7;
    RelativeLayout question8;
    RelativeLayout question9;
    RelativeLayout question10;
    //each answer button
    Button question1_a1,question1_a2,question1_a3,question1_a4;
    Button question2_a1,question2_a2,question2_a3,question2_a4;
    Button question3_a1,question3_a2,question3_a3,question3_a4;
    Button question4_a1,question4_a2,question4_a3,question4_a4;
    Button question5_a1,question5_a2,question5_a3,question5_a4;
    Button question6_a1,question6_a2,question6_a3,question6_a4;
    Button question7_a1,question7_a2,question7_a3,question7_a4;
    Button question8_a1,question8_a2,question8_a3,question8_a4;
    Button question9_a1,question9_a2,question9_a3,question9_a4;
    Button question10_a1,question10_a2,question10_a3,question10_a4;
    //index Key
    int index = 0;
    //question 1~10 array
    View[] question;
    //animation
    Animation tranlateLeftAnim;
    Animation tranlateRightAnim;
    //save the currently displayed screen
    View NowDisplayScreen; //1 ~ 10;
    //save the pre/next screen
    View PreDisplayScreen;
    View NextDisplayScreen;
    //move to avatar
    ImageView go_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_solar);

        //bottom page animation (only first page)
        final Animation translateup = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_up);
        question1 = findViewById(R.id.question1);
        question1.setVisibility(View.VISIBLE);
        question1.startAnimation(translateup);

        //previous / next button
        previous = findViewById(R.id.previous_btn);
        next = findViewById(R.id.next_btn);

        //back button
        btn_back = findViewById(R.id.btn_back);

        //question & view
        question1_a1 = findViewById(R.id.question1_a1);
        question1_a2 = findViewById(R.id.question1_a2);
        question1_a3 = findViewById(R.id.question1_a3);
        question1_a4 = findViewById(R.id.question1_a4);

        question2 = findViewById(R.id.question2);
        question2_a1 = findViewById(R.id.question2_a1);
        question2_a2 = findViewById(R.id.question2_a2);
        question2_a3 = findViewById(R.id.question2_a3);
        question2_a4 = findViewById(R.id.question2_a4);

        question3 = findViewById(R.id.question3);
        question3_a1 = findViewById(R.id.question3_a1);
        question3_a2 = findViewById(R.id.question3_a2);
        question3_a3 = findViewById(R.id.question3_a3);
        question3_a4 = findViewById(R.id.question3_a4);

        question4 = findViewById(R.id.question4);
        question4_a1 = findViewById(R.id.question4_a1);
        question4_a2 = findViewById(R.id.question4_a2);
        question4_a3 = findViewById(R.id.question4_a3);
        question4_a4 = findViewById(R.id.question4_a4);

        question5 = findViewById(R.id.question5);
        question5_a1 = findViewById(R.id.question5_a1);
        question5_a2 = findViewById(R.id.question5_a2);
        question5_a3 = findViewById(R.id.question5_a3);
        question5_a4 = findViewById(R.id.question5_a4);

        question6 = findViewById(R.id.question6);
        question6_a1 = findViewById(R.id.question6_a1);
        question6_a2 = findViewById(R.id.question6_a2);
        question6_a3 = findViewById(R.id.question6_a3);
        question6_a4 = findViewById(R.id.question6_a4);

        question7 = findViewById(R.id.question7);
        question7_a1 = findViewById(R.id.question7_a1);
        question7_a2 = findViewById(R.id.question7_a2);
        question7_a3 = findViewById(R.id.question7_a3);
        question7_a4 = findViewById(R.id.question7_a4);

        question8 = findViewById(R.id.question8);
        question8_a1 = findViewById(R.id.question8_a1);
        question8_a2 = findViewById(R.id.question8_a2);
        question8_a3 = findViewById(R.id.question8_a3);
        question8_a4 = findViewById(R.id.question8_a4);

        question9 = findViewById(R.id.question9);
        question9_a1 = findViewById(R.id.question9_a1);
        question9_a2 = findViewById(R.id.question9_a2);
        question9_a3 = findViewById(R.id.question9_a3);
        question9_a4 = findViewById(R.id.question9_a4);

        question10 = findViewById(R.id.question10);
        question10_a1 = findViewById(R.id.question10_a1);
        question10_a2 = findViewById(R.id.question10_a2);
        question10_a3 = findViewById(R.id.question10_a3);
        question10_a4 = findViewById(R.id.question10_a4);

        //back button click listener
        btn_back.setOnClickListener(v -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });

        //save each page as int (like key)
        question = new View[]{question1, question2, question3, question4, question5, question6, question7, question8, question9, question10};
        //save the currently displayed screen
        View NowDisplayScreen = question[0]; //1 ~ 10;
        //save the pre/next screen
        View PreDisplayScreen = question[0];
        View NextDisplayScreen = question[1];
        if(index==0) previous.setVisibility(View.INVISIBLE);

        //animation in anim directory
        tranlateLeftAnim = AnimationUtils.loadAnimation(this,R.anim.translate_center_to_left);
        tranlateRightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_center_to_right);
        // sence page sliding event
        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();
        tranlateLeftAnim.setAnimationListener(animListener);
        tranlateRightAnim.setAnimationListener(animListener);


        next.setOnClickListener(v -> {
            NowDisplayScreen.setVisibility(View.INVISIBLE);
            NextDisplayScreen.setVisibility(View.VISIBLE);
            index++;
            if(index>10) index = 10;
            //NextDisplayScreen.startAnimation(tranlateLeftAnim);
            NowDisplayScreen.startAnimation(tranlateLeftAnim);

            //if last question is end
            if(index==9){
                Intent intent = new Intent(this,ResultScreen.class);
                startActivity(intent);
                //starting activity animation
                overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                finish();
            }
        });
        previous.setOnClickListener(v -> {
            NowDisplayScreen.setVisibility(View.INVISIBLE);
            PreDisplayScreen.setVisibility(View.VISIBLE);
            index--;
            if(index<0) index = 0;
            NowDisplayScreen.startAnimation(tranlateRightAnim);
            //PreDisplayScreen.startAnimation(tranlateRightAnim);
        });

        //move to avatar select page
        go_avatar = findViewById(R.id.go_avatar);
        go_avatar.setOnClickListener(v -> {
            Intent intent = new Intent(this,SelectAvatar.class);
            //Theme Solar page code = 3
            intent.putExtra("page_code",3);
            startActivity(intent);
        });
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation) { }
        public void onAnimationEnd(Animation animation){
            //remove previous button if question 1
            if(index==0) previous.setVisibility(View.INVISIBLE);
            else previous.setVisibility(View.VISIBLE);
            //remove next button if question 10
            if(index==10) next.setVisibility(View.INVISIBLE);
            else next.setVisibility(View.VISIBLE);

            //hide irrelevant question page
            for(int i=0;i<10;i++){
                if(i==index) question[i].setVisibility(View.VISIBLE);
                else question[i].setVisibility(View.INVISIBLE);
            }

            //set each screen status
            //now
            NowDisplayScreen = question[index];
            //prev
            if(index==0) PreDisplayScreen = question[0];
            else PreDisplayScreen = question[index-1];
            //next
            if(index==9) NextDisplayScreen = question[9];
            else NextDisplayScreen = question[index+1];
        }
        @Override
        public void onAnimationRepeat(Animation animation) { }
    }
}