package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.model.Customer;

public class CustomerDetailsActivity extends AppCompatActivity {

    private TextView txtCustomerId;
    private TextView txtFullName;
    private TextView txtEmail;
    private TextView txtTotalAmountToPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Customer's Details");

        txtCustomerId = findViewById(R.id.textView5);
        txtFullName = findViewById(R.id.textView6);
        txtEmail = findViewById(R.id.textView7);
        txtTotalAmountToPay = findViewById(R.id.textView8);

        Customer tempobj = (Customer) getIntent().getSerializableExtra("customers");

        txtCustomerId.setText(tempobj.getCustomerId());
        txtFullName.setText(tempobj.getFullName());
        txtEmail.setText(tempobj.getEmail());
    }
}
