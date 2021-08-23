package com.example.energize;

import android.util.Log;

public class Point {

    private int remain_point;

    public Point(){
        remain_point = 0;
        Log.d("myapp","포인트 객체가 생성되었습니다.");
    }

    public int getPoint(){
        return remain_point;
    }
    public void setPoint(int usedPoint){
        remain_point -= usedPoint;
        Log.d("myapp","잔여 포인트 : "+remain_point);
    }
    public void addPoint(int addition){
        remain_point += addition;
        Log.d("myapp","잔여 포인트 : "+remain_point);
    }



}
