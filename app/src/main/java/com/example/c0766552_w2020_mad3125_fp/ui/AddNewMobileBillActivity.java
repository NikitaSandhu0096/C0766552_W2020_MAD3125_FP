package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.c0766552_w2020_mad3125_fp.R;

public class AddNewMobileBillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_mobile_bill);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Add New Mobile Bill");
    }
}
