package com.example.energize;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AccountDetails extends AppCompatActivity {
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        setContentView(R.layout.activity_account_details);
    }
}
