package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.model.Bill;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Bill's Information");

        Bill tempbill = (Bill) getIntent().getSerializableExtra("bills");

        txtBillId = findViewById(R.id.textView10);
        txtBillDate = findViewById(R.id.textView11);
        txtBillType = findViewById(R.id.textView12);
        txtBillAmount = findViewById(R.id.textView13);
        txtDetail1 = findViewById(R.id.textView14);
        txtDetail2 = findViewById(R.id.textView15);
        txtDetail3 = findViewById(R.id.textView16);
        txtDetail4 = findViewById(R.id.textView17);
        txtDetail5 = findViewById(R.id.textView18);

        txtBillId.setText("Bill ID : " + tempbill.getBillId());
        txtBillDate.setText("Bill Date : " + tempbill.getBillDate());
        txtBillType.setText("Bill Type : " + tempbill.getBillType());
        txtBillAmount.setText("Bill Amount : " + tempbill.getTotalBillAmount());

        if(tempbill.getBillType().contains("Hydro")){

            txtDetail1.setText("Agency Name : ");
            txtDetail2.setText("Unit Consumed : ");
        } else if(tempbill.getBillType().contains("Internet")){
            txtDetail1.setText("Provider Name : ");
            txtDetail2.setText("Internet Usage : ");
        } else {
            txtDetail1.setText("Manufacturer Name : ");
            txtDetail2.setText("Plan Name : ");
            txtDetail3.setText("Mobile Number : ");
            txtDetail4.setText("Internet Usage : ");
            txtDetail5.setText("Minutes Usage : ");
        }
    }
}
