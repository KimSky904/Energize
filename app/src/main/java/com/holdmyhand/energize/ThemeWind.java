package com.holdmyhand.energize;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThemeWind extends AppCompatActivity {
    //1 2 3 1 4 2 1 4 1 1

    //돌아가기 버튼
    ImageButton btn_back;
    //문제 TextView
    TextView MainText;
    //보기 TextView
    TextView AnswerText1,AnswerText2,AnswerText3,AnswerText4;

    //퀴즈 문제 목록
    int[] question;
    //퀴즈 보기 목록
    int[][] answer = null;
    //정답 목록
    int[] answer_list;
    //사용자가 선택한 정답 목록
    int[] answer_user = new int[10];

    //이전 / 다음 버튼
    ImageView previous;
    ImageView next;
    //인덱스
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_quiz);

        btn_back = findViewById(R.id.btn_back);
        //테마로 돌아가기
        btn_back.setOnClickListener(v->{
            Intent intent = new Intent(this,ThemeSelection.class);
            startActivity(intent);
            //starting activity animation
            overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
            finish();
        });


        //목록 값 할당
        setDataList();

        //퀴즈 문제 textView
        MainText = findViewById(R.id.MainText);
        //퀴즈 보기 textView
        AnswerText1 = findViewById(R.id.AnswerText1);
        AnswerText2 = findViewById(R.id.AnswerText2);
        AnswerText3 = findViewById(R.id.AnswerText3);
        AnswerText4 = findViewById(R.id.AnswerText4);

        //이전 문제로
        previous = findViewById(R.id.previous_btn);
        //1번 값 지정
        setQuestion();
        //1번문제일 경우 이전버튼 숨김
        if(index==0) previous.setVisibility(View.INVISIBLE);
        previous.setOnClickListener(v -> {
            answer_user[index] = 0;
            index--;
            answer_user[index] = 0;
            if (index>-1){
                if(index==0) previous.setVisibility(View.INVISIBLE);
                else previous.setVisibility(View.VISIBLE);
                setQuestion(); //문제 교체
            }
            //previous 누르면 색 원상복구
            initButtonBackground();
        });
        //다음 문제로
        next = findViewById(R.id.next_btn);
        next.setOnClickListener(v -> {
            index++;
            if(index==10) scoring();
            else{
                if(index!=0) previous.setVisibility(View.VISIBLE);
                setQuestion(); //문제 교체
            }
            //next 누르면 색 원상복구
            initButtonBackground();
        });
    }

    private void scoring() {
        //포인트 부여
        for (int i = 0; i < 10; i++) {
            if (answer_user[i] == answer_list[i]) {
                User.point.addPoint(2);
                User.point.addEachPoint(2);
            }
        }
        User.p.setInt(this,"point",User.point.getPoint());
        Intent intent = new Intent(this, ResultScreen.class);
        startActivity(intent);
        //starting activity animation
        overridePendingTransition(R.anim.translate_none, R.anim.translate_center_to_right);
        finish();
    }
    //정답 선택
    public void chooseAnswer(View view){
        initButtonBackground();
        answer_user[index] = view.getId();
        view.setBackgroundResource(R.drawable.round_edge_btn_click_color);
    }
    private void initButtonBackground(){
        AnswerText1.setBackgroundResource(R.drawable.round_edge_btn_style);
        AnswerText2.setBackgroundResource(R.drawable.round_edge_btn_style);
        AnswerText3.setBackgroundResource(R.drawable.round_edge_btn_style);
        AnswerText4.setBackgroundResource(R.drawable.round_edge_btn_style);
    }
    private void setQuestion(){
        //각 문제 텍스트 지정
        MainText.setText(question[index]);
        AnswerText1.setText(answer[index][0]);
        AnswerText2.setText(answer[index][1]);
        AnswerText3.setText(answer[index][2]);
        AnswerText4.setText(answer[index][3]);
    }

    private void setDataList(){
        //퀴즈 문제 목록 string
        question = new int[]{
                R.string.Wind_Question_1,
                R.string.Wind_Question_2,
                R.string.Wind_Question_3,
                R.string.Wind_Question_4,
                R.string.Wind_Question_5,
                R.string.Wind_Question_6,
                R.string.Wind_Question_7,
                R.string.Wind_Question_8,
                R.string.Wind_Question_9,
                R.string.Wind_Question_10,
        };
        //퀴즈 보기 목록 string
        answer = new int[][]{
                {R.string.Wind_Answer_Q1_1, R.string.Wind_Answer_Q1_2, R.string.Wind_Answer_Q1_3, R.string.Wind_Answer_Q1_4},
                {R.string.Wind_Answer_Q2_1, R.string.Wind_Answer_Q2_2, R.string.Wind_Answer_Q2_3, R.string.Wind_Answer_Q2_4},
                {R.string.Wind_Answer_Q3_1, R.string.Wind_Answer_Q3_2, R.string.Wind_Answer_Q3_3, R.string.Wind_Answer_Q3_4},
                {R.string.Wind_Answer_Q4_1, R.string.Wind_Answer_Q4_2, R.string.Wind_Answer_Q4_3, R.string.Wind_Answer_Q4_4},
                {R.string.Wind_Answer_Q5_1, R.string.Wind_Answer_Q5_2, R.string.Wind_Answer_Q5_3, R.string.Wind_Answer_Q5_4},
                {R.string.Wind_Answer_Q6_1, R.string.Wind_Answer_Q6_2, R.string.Wind_Answer_Q6_3, R.string.Wind_Answer_Q6_4},
                {R.string.Wind_Answer_Q7_1, R.string.Wind_Answer_Q7_2, R.string.Wind_Answer_Q7_3, R.string.Wind_Answer_Q7_4},
                {R.string.Wind_Answer_Q8_1, R.string.Wind_Answer_Q8_2, R.string.Wind_Answer_Q8_3, R.string.Wind_Answer_Q8_4},
                {R.string.Wind_Answer_Q9_1, R.string.Wind_Answer_Q9_2, R.string.Wind_Answer_Q9_3, R.string.Wind_Answer_Q9_4},
                {R.string.Wind_Answer_Q10_1, R.string.Wind_Answer_Q10_2, R.string.Wind_Answer_Q10_3, R.string.Wind_Answer_Q10_4},
        };
        //정답 목록
        //1 2 3 1 4 2 1 4 1 1
        answer_list = new int[]{R.id.AnswerText1,R.id.AnswerText2,R.id.AnswerText3,R.id.AnswerText1,R.id.AnswerText4,R.id.AnswerText2,R.id.AnswerText1,R.id.AnswerText4,R.id.AnswerText1,R.id.AnswerText1};

    }
}
