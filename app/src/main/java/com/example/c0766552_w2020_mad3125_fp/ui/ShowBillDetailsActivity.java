package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.adapters.BillListInfoActivity;
import com.example.c0766552_w2020_mad3125_fp.model.Bill;
import com.example.c0766552_w2020_mad3125_fp.model.Customer;
import com.example.c0766552_w2020_mad3125_fp.util.DataStorage;

import java.util.ArrayList;

public class ShowBillDetailsActivity extends AppCompatActivity {

    private TextView txtCustomerId;
    private TextView txtFullName;
    private TextView txtEmail;
    private TextView txtTotalAmountToPay;

    private RecyclerView rvBillsList;
    private ArrayList<Bill> bills;
    private BillListInfoActivity billsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);

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
        //txtTotalAmountToPay.setText(tempobj.getTotalAmountToPay());

        bills = tempobj.getAllBills();

        rvBillsList = findViewById(R.id.rvBillsList);

      //  billsInfo();

        billsAdapter = new BillListInfoActivity(bills);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvBillsList.setLayoutManager(mLayoutManager1);

        rvBillsList.setAdapter(billsAdapter);
    }

//    private void billsInfo(){
//        DataStorage.getInstance().loadDetails();
//        //bills = new ArrayList<>(DataStorage.getInstance().getCustomer());

//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //https://javatpoint.com/android-option-menu-example
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_bill, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu3:
                Intent intent3 = new Intent(ShowBillDetailsActivity.this, AddNewHydroBillActivity.class);
                startActivity(intent3);
                //  Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu4:
                //  Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(ShowBillDetailsActivity.this, AddNewMobileBillActivity.class);
                startActivity(intent4);
                return true;
            case R.id.menu5:
                //  Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                Intent intent5 = new Intent(ShowBillDetailsActivity.this, AddNewInternetBillActivity.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
