package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        edtMBillDate.setOnClickListener(new View.OnClickListener() {        //https://www.journaldev.com/9976/android-date-time-picker-dialog
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddNewMobileBillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {       //https://android--code.blogspot.com/2015/08/android-datepickerdialog-date-format.html
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(date);
                        edtMBillDate.setText(s);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

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
                } else if(edtMobileNumber.getText().toString().matches("[0-9]{10}")) {      //https://stackoverflow.com/questions/27998409/email-phone-validation-in-swift
                    Intent mint = new Intent(AddNewMobileBillActivity.this, CustomerDetailsActivity.class);
                    startActivity(mint);
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddNewMobileBillActivity.this);
                    alert.setCancelable(false);
                    alert.setTitle("New Mobile Bill Creation Error");
                    alert.setMessage("Invalid Mobile Number");
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog aDialog = alert.create();
                    aDialog.show();
                }
            }
        });
    }
}
