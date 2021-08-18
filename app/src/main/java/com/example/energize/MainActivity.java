package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //Key values representing the value of a request
    static final int AVATAR_REQUEST_CODE = 1003;
    static final int QUIZ_REQUEST_CODE = 1005;


    Button btn_selectAvatar;
    Button btn_solveQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        btn_selectAvatar = findViewById(R.id.btn_selectAvatar);
        btn_solveQuiz = findViewById(R.id.btn_solveQuiz);


        btn_selectAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SelectAvatar.class);
            startActivityForResult(intent , AVATAR_REQUEST_CODE );
        });

        btn_solveQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SolveQuiz.class);
            startActivityForResult(intent , QUIZ_REQUEST_CODE );
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Main Activity", "onActivityResult : " + resultCode);
        switch (requestCode){
            case AVATAR_REQUEST_CODE: // Third레이아웃으로 보냈던 요청
                if (resultCode == RESULT_OK) { // 결과가 OK
                    Log.d("Main Activity", data.getStringExtra("sample1"));
                    Log.d("Main Activity", data.getStringExtra("sample2"));
                }
                break;
        }
        switch (requestCode){
            case QUIZ_REQUEST_CODE: // Third레이아웃으로 보냈던 요청
                if (resultCode == RESULT_OK) { // 결과가 OK
                    Log.d("Main Activity", data.getStringExtra("sample1"));
                    Log.d("Main Activity", data.getStringExtra("sample2"));
                }
                break;
        }
    }
}