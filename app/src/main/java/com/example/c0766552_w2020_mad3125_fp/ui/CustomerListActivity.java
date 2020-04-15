package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.adapters.CustomerListInfoActivity;
import com.example.c0766552_w2020_mad3125_fp.model.Customer;

import java.util.ArrayList;

public class CustomerListActivity extends AppCompatActivity {

    private RecyclerView rvCustomersList;
    private ArrayList<Customer> customers;
    private CustomerListInfoActivity customersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Customer List");

        rvCustomersList = findViewById(R.id.rvCustomersList);

        customersInfo();

        customersAdapter = new CustomerListInfoActivity(customers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvCustomersList.setLayoutManager(mLayoutManager);

        rvCustomersList.setAdapter(customersAdapter);
    }

    private void customersInfo(){
        customers = new ArrayList<>();
        customers.add(new Customer("C0001","Nikita","Sandhu","nsandhu@gmail.com"));
        customers.add(new Customer("C0002","Kashyap","Jhaveri","kjhaveri@yahoo.com"));
        customers.add(new Customer("C0003","Kamalpreet","Kaur","kkaur@yahoo.com"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {         //https://javatpoint.com/android-option-menu-example
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent2 = new Intent(CustomerListActivity.this, AddNewCustomerActivity.class);
                startActivity(intent2);
              //  Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu2:
              //  Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CustomerListActivity.this, LoginActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
