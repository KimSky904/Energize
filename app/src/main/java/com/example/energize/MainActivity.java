package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int AVATAR_REQUEST_CODE = 1003;
    static final int QUIZ_REQUEST_CODE = 1005;


    Button btn_selectAvatar;
    Button btn_solveQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_selectAvatar.findViewById(R.id.btn_selectAvatar);
        btn_solveQuiz.findViewById(R.id.btn_solveQuiz);


        btn_selectAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SelectAvatar.class);
            startActivityForResult(intent , AVATAR_REQUEST_CODE );
        });

        btn_solveQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SolveQuiz.class);
            startActivityForResult(intent , QUIZ_REQUEST_CODE );
        });



    }
}