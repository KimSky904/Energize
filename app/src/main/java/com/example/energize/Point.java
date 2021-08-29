package com.example.energize;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

import java.util.Locale;


public class Point {

    private int remain_point;
    private int avatar_image = 0;
    private String user_name;
    private int eachPoint;

    //아바타 잠금해제 여부
    private boolean[] avatar_available={true,true,true,true,false,false,false,false};

    public Point(){
        remain_point = 0;
        Log.d("myapp","포인트 객체가 생성되었습니다.");
    }

    //포인트
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
        Log.d("myapp","총 잔여 포인트 : "+remain_point);
    }

    //테마 끝난 후 해당 세트에 획득한 포인트
    public void addEachPoint(int point){
        eachPoint += point;
    }
    public void initialThemePoint(){ eachPoint = 0; }
    public int getEachPoint(){
        return eachPoint;
    }

    //아바타 리소스 세팅
    public int getAvatar_image(){
        return avatar_image;
    }
    public void setAvatar_image(int avatar_image){
        this.avatar_image = avatar_image;
    }

    //구매할때 사용
    public void setAvatar_available(int index){
        this.avatar_available[index] = true;
    }
    public boolean getAvatar_available(int index){
        return avatar_available[index];
    }

    //사용자 이름
    public String getUser_name(){
        return  user_name;
    }
    public void setUser_name(String user_name){
        this.user_name = user_name;
    }

}


class User{
    static Point point = new Point();
    static PreferenceManager p;
}