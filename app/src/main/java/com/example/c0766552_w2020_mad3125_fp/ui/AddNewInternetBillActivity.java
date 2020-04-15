package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewInternetBillActivity extends AppCompatActivity {

    private TextInputEditText edtIBillID;
    private TextInputEditText edtIBillDate;
    private TextInputEditText edtProviderName;
    private TextInputEditText edtIInternetUsage;
    private Button btnISave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_internet_bill);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Add New Internet Bill");

        edtIBillID = findViewById(R.id.internetBillIDTextInputEditText);
        edtIBillDate = findViewById(R.id.internetBillDateTextInputEditText);
        edtProviderName = findViewById(R.id.internetProviderNameTextInputEditText);
        edtIInternetUsage = findViewById(R.id.internetInternetUsageTextInputEditText);
        btnISave = findViewById(R.id.internetbutton);

        btnISave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iID = edtIBillID.getText().toString().trim();
                String iBillDate = edtIBillDate.getText().toString().trim();
                String providerName = edtProviderName.getText().toString().trim();
                String iInternetUsage = edtIInternetUsage.getText().toString().trim();

                if(iID.isEmpty()){
                    edtIBillID.setError("Please enter Bill ID");
                } else if(iBillDate.isEmpty()){
                    edtIBillDate.setError("Please enter Bill Date");
                } else if(providerName.isEmpty()){
                    edtProviderName.setError("Please enter Provider Name");
                } else if(iInternetUsage.isEmpty()){
                    edtIInternetUsage.setError("Please enter Internet Usage");
                } else {
                    Intent iint = new Intent(AddNewInternetBillActivity.this, CustomerDetailsActivity.class);
                    startActivity(iint);
                }
            }
        });
    }
}
