package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewMobileBillActivity extends AppCompatActivity {

    private TextInputEditText edtMBillID;
    private TextInputEditText edtMBillDate;
    private TextInputEditText edtManufacturerName;
    private TextInputEditText edtPlanName;
    private TextInputEditText edtMobileNumber;
    private TextInputEditText edtMInternetUsage;
    private TextInputEditText edtMinutesUsage;
    private Button btnMSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_mobile_bill);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Add New Mobile Bill");

        edtMBillID = findViewById(R.id.mobileBillIDTextInputEditText);
        edtMBillDate = findViewById(R.id.mobileBillDateTextInputEditText);
        edtManufacturerName = findViewById(R.id.mobileManufacturerNameTextInputEditText);
        edtPlanName = findViewById(R.id.mobilePlanNameTextInputEditText);
        edtMobileNumber = findViewById(R.id.mobileMobileNumberTextInputEditText);
        edtMInternetUsage = findViewById(R.id.mobileInternetUsageTextInputEditText);
        edtMinutesUsage = findViewById(R.id.mobileMinutesUsageTextInputEditText);
        btnMSave = findViewById(R.id.mobilebutton);

        btnMSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mID = edtMBillID.getText().toString().trim();
                String mBillDate = edtMBillDate.getText().toString().trim();
                String manufacturerName = edtManufacturerName.getText().toString().trim();
                String planName = edtPlanName.getText().toString().trim();
                String mobileNumber = edtMobileNumber.getText().toString().trim();
                String mInternetUsage = edtMInternetUsage.getText().toString().trim();
                String minutesUsage = edtMinutesUsage.getText().toString().trim();

                if(mID.isEmpty()){
                    edtMBillID.setError("Please enter Bill ID");
                } else if(mBillDate.isEmpty()){
                    edtMBillDate.setError("Please enter Bill Date");
                } else if(manufacturerName.isEmpty()){
                    edtManufacturerName.setError("Please enter Manufacturer Name");
                } else if(planName.isEmpty()){
                    edtPlanName.setError("Please enter Plan Name");
                } else if(mobileNumber.isEmpty()){
                    edtMobileNumber.setError("Please enter Mobile Number");
                } else if(mInternetUsage.isEmpty()){
                    edtMInternetUsage.setError("Please enter Internet Usage");
                } else if(minutesUsage.isEmpty()){
                    edtMinutesUsage.setError("Please enter Minutes Usage");
                } else {
                    Intent mint = new Intent(AddNewMobileBillActivity.this, CustomerDetailsActivity.class);
                    startActivity(mint);
                }
            }
        });
    }
}
