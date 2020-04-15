package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}
