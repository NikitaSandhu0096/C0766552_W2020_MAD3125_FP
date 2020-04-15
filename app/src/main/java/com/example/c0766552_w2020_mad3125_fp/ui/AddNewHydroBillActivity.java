package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

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
        edtAgencyName = findViewById(R.id.hydroAgencyNameTextInputEditText);
        edtUnitConsumed = findViewById(R.id.hydroUnitConsumedTextInputEditText);

        
    }
}
