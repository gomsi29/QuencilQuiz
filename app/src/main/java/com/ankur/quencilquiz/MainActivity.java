package com.ankur.quencilquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//  This work after time is given completed 40000
                Intent iNext = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(iNext);
                finish();

            }
        }  ,  2000);
    }
}