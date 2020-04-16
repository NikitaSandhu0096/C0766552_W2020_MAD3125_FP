package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewInternetBillActivity extends AppCompatActivity {

    private TextInputEditText edtIBillID;
    private TextInputEditText edtIBillDate;
    private TextInputEditText edtIBillAmount;
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

        edtIBillDate.setOnClickListener(new View.OnClickListener() {        //https://www.journaldev.com/9976/android-date-time-picker-dialog
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddNewInternetBillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {       //https://android--code.blogspot.com/2015/08/android-datepickerdialog-date-format.html
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(date);
                        edtIBillDate.setText(s);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

        edtIBillAmount = findViewById(R.id.internetBillAmountTextInputEditText);
        edtProviderName = findViewById(R.id.internetProviderNameTextInputEditText);
        edtIInternetUsage = findViewById(R.id.internetInternetUsageTextInputEditText);
        btnISave = findViewById(R.id.internetbutton);

        btnISave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iID = edtIBillID.getText().toString().trim();
                String iBillDate = edtIBillDate.getText().toString().trim();
                String iBillAmount = edtIBillAmount.getText().toString().trim();
                String providerName = edtProviderName.getText().toString().trim();
                String iInternetUsage = edtIInternetUsage.getText().toString().trim();

                if(iID.isEmpty()){
                    edtIBillID.setError("Please enter Bill ID");
                } else if(iBillDate.isEmpty()){
                    edtIBillDate.setError("Please enter Bill Date");
                } else if(iBillAmount.isEmpty()){
                    edtIBillAmount.setError("Please enter Bill Amount");
                } else if(providerName.isEmpty()){
                    edtProviderName.setError("Please enter Provider Name");
                } else if(iInternetUsage.isEmpty()){
                    edtIInternetUsage.setError("Please enter Internet Usage");
                } else {
                    Intent iint = new Intent(AddNewInternetBillActivity.this, ShowBillDetailsActivity.class);
                    startActivity(iint);
                }
            }
        });
    }
}
