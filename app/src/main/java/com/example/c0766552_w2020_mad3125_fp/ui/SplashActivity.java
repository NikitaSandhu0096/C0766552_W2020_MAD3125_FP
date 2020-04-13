package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.c0766552_w2020_mad3125_fp.MainActivity;
import com.example.c0766552_w2020_mad3125_fp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent hint = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(hint);
                finish();
            }
        },5000);
    }
}
