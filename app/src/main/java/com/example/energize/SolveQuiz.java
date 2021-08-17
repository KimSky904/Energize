package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SolveQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve_quiz);
        Log.d("myapp","퀴즈 풀이 페이지 열림");

        Intent intent = getIntent();
        intent.putExtra("sample1", "Successed");
        intent.putExtra("sample2", "Successed");
        setResult(RESULT_OK, intent);

        this.finish();

    }
}