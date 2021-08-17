package com.example.energize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class SelectAvatar extends AppCompatActivity {


    private ListView listView;
    private AvatarListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
        Log.d("myapp","아바타 선택 페이지 열림");


        Intent intent = getIntent();

        adapter = new AvatarListAdapter();

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        adapter.addItem(R.drawable.test_avatar,1000);
        adapter.addItem(R.drawable.test_avatar,2000);
        adapter.addItem(R.drawable.test_avatar,3000);
        adapter.addItem(R.drawable.test_avatar,4000);
        adapter.addItem(R.drawable.test_avatar,5000);
        adapter.notifyDataSetChanged();

        intent.putExtra("sample1", "Successed");
        intent.putExtra("sample2", "Successed");
        setResult(RESULT_OK, intent);

        this.finish();
    }
}