package com.example.energize;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AccountDetails extends AppCompatActivity {

    Button Btn_back;

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        Btn_back = findViewById(R.id.Btn_back);


        Btn_back.setOnClickListener(v -> {
            Intent fromPage = getIntent();
            int pageCode = fromPage.getIntExtra("page_code",1);

            switch (pageCode){
                // page code 1 : LanguageSelection
                // page code 2 : ThemeSelection
                // page code 3 : ResultScreen
                case 1 :
                    startActivity(new Intent(this, LanguageSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 2 :
                    startActivity(new Intent(this, ThemeSelection.class));
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
                case 3 :
                    Intent intent7 = new Intent(this,ResultScreen.class);
                    //starting activity animation
                    overridePendingTransition(R.anim.translate_none,R.anim.translate_center_to_right);
                    finish();
                    break;
            }
        });


    }
}
