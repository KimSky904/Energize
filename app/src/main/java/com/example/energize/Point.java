package com.example.energize;

import android.util.Log;

public class Point {

    private int remain_point;
    private int avatar_image;
    private String user_name;

    public Point(){
        remain_point = 0;
        Log.d("myapp","포인트 객체가 생성되었습니다.");
    }

    //point
    public int getPoint(){
        return remain_point;
    }
    public void setPoint(int point){
        this.remain_point = point;
    }
    public void usePoint(int usedPoint){
        remain_point -= usedPoint;
        Log.d("myapp","잔여 포인트 : "+remain_point);
    }
    public void addPoint(int addition){
        remain_point += addition;
        Log.d("myapp","잔여 포인트 : "+remain_point);
    }
    //quiz result point for each theme
    private int eachPoint;
    public void addEachPoint(int point){
        eachPoint += point;
    }
    public void initialThemePoint(){ eachPoint = 0; }
    public int getEachPoint(){
        return eachPoint;
    }

    //avatar
    public int getAvatar_image(){
        return avatar_image;
    }
    public void setAvatar_image(int avatar_image){
        this.avatar_image = avatar_image;
    }

    //user name
    public String getUser_name(){
        return  user_name;
    }
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }
}


class User{
    static Point point = new Point();
}