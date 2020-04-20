package com.example.c0766552_w2020_mad3125_fp.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.c0766552_w2020_mad3125_fp.R
import com.example.c0766552_w2020_mad3125_fp.util.DataStorage

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        DataStorage.getInstance().loadDetails()
        Handler().postDelayed({
            val hint = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(hint)
            finish()
        }, 5000)
    }
}