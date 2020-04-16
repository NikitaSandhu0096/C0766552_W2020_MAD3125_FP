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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNewHydroBillActivity extends AppCompatActivity {

    private TextInputEditText edtHBillID;
    private TextInputEditText edtHBillDate;
    private TextInputEditText edtAgencyName;
    private TextInputEditText edtUnitConsumed;
    private Button btnHSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_hydro_bill);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Add New Hydro Bill");

        edtHBillID = findViewById(R.id.hydroBillIDTextInputEditText);
        edtHBillDate = findViewById(R.id.hydroBillDateTextInputEditText);

        edtHBillDate.setOnClickListener(new View.OnClickListener() {        //https://www.journaldev.com/9976/android-date-time-picker-dialog
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(AddNewHydroBillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {       //https://android--code.blogspot.com/2015/08/android-datepickerdialog-date-format.html
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        Date date = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(date);
                        edtHBillDate.setText(s);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });

        edtAgencyName = findViewById(R.id.hydroAgencyNameTextInputEditText);
        edtUnitConsumed = findViewById(R.id.hydroUnitConsumedTextInputEditText);
        btnHSave = findViewById(R.id.hydrobutton);

        btnHSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hID = edtHBillID.getText().toString().trim();
                String hBillDate = edtHBillDate.getText().toString().trim();
                String agencyName = edtAgencyName.getText().toString().trim();
                String unitConsumed = edtUnitConsumed.getText().toString().trim();

                if(hID.isEmpty()){
                    edtHBillID.setError("Please enter Bill ID");
                } else if(hBillDate.isEmpty()){
                    edtHBillDate.setError("Please enter Bill Date");
                } else if(agencyName.isEmpty()){
                    edtAgencyName.setError("Please enter Agency Name");
                } else if(unitConsumed.isEmpty()){
                    edtUnitConsumed.setError("Please enter Unit Consumed");
                } else {
                    Intent hint = new Intent(AddNewHydroBillActivity.this, ShowBillDetailsActivity.class);
                    startActivity(hint);
                }
            }
        });
    }
}
