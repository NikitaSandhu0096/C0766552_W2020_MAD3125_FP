package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.model.Bill;

import java.text.NumberFormat;
import java.util.Currency;

public class BillInfoActivity extends AppCompatActivity {

    private TextView txtBillId;
    private TextView txtBillDate;
    private TextView txtBillAmount;
    private TextView txtBillType;

    private TextView txtDetail1;
    private TextView txtDetail2;
    private TextView txtDetail3;
    private TextView txtDetail4;
    private TextView txtDetail5;

    private TextView txtDetail11;
    private TextView txtDetail21;
    private TextView txtDetail31;
    private TextView txtDetail41;
    private TextView txtDetail51;

    private Bill tempbill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Bill's Information");

        tempbill = (Bill) getIntent().getSerializableExtra("bills");

        txtBillId = findViewById(R.id.textView19);
        txtBillDate = findViewById(R.id.textView20);
        txtBillType = findViewById(R.id.textView21);
        txtBillAmount = findViewById(R.id.textView22);
        txtDetail1 = findViewById(R.id.textView14);
        txtDetail2 = findViewById(R.id.textView15);
        txtDetail3 = findViewById(R.id.textView16);
        txtDetail4 = findViewById(R.id.textView17);
        txtDetail5 = findViewById(R.id.textView18);

        txtDetail11 = findViewById(R.id.textView23);
        txtDetail21 = findViewById(R.id.textView24);
        txtDetail31 = findViewById(R.id.textView25);
        txtDetail41 = findViewById(R.id.textView26);
        txtDetail51 = findViewById(R.id.textView27);

        txtBillId.setText(tempbill.getBillId());
        txtBillDate.setText(tempbill.getBillDate());
        txtBillType.setText(tempbill.getBillType());

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();             //https://stackoverflow.com/questions/45592109/how-can-i-convert-numbers-to-currency-format-in-android
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setCurrency(Currency.getInstance("USD"));
        txtBillAmount.setText(numberFormat.format(tempbill.getTotalBillAmount()));

        if(tempbill.getBillType().contains("Hydro")){

            txtDetail1.setText("Agency Name");
            txtDetail11.setText("Agency Name");

            txtDetail2.setText("Unit Consumed");
            txtDetail21.setText("Unit Consumed");

        } else if(tempbill.getBillType().contains("Internet")){

            txtDetail1.setText("Provider Name");
            txtDetail11.setText("Provider Name");

            txtDetail2.setText("Internet Usage");
            txtDetail21.setText("Internet Usage");

        } else {
            
            txtDetail1.setText("Manufacturer Name");
            txtDetail11.setText("Manufacturer Name");

            txtDetail2.setText("Plan Name");
            txtDetail21.setText("Plan Name");

            txtDetail3.setText("Mobile Number");
            txtDetail31.setText("Mobile Number");

            txtDetail4.setText("Internet Usage");
            txtDetail41.setText("Internet Usage");

            txtDetail5.setText("Minutes Usage");
            txtDetail51.setText("Minutes Usage");
        }
    }
}
