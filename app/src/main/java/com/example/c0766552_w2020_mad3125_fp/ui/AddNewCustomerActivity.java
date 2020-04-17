package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.model.Customer;
import com.example.c0766552_w2020_mad3125_fp.util.DataStorage;
import com.google.android.material.textfield.TextInputEditText;

public class AddNewCustomerActivity extends AppCompatActivity {

    private TextInputEditText edtCustomerID;
    private TextInputEditText edtFirstName;
    private TextInputEditText edtLastName;
    private TextInputEditText edtCEmail;
    private Button btnCSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Add New Customer");

        edtCustomerID = findViewById(R.id.customerIDTextInputEditText);
        edtFirstName = findViewById(R.id.firstNameTextInputEditText);
        edtLastName = findViewById(R.id.lastNameTextInputEditText);
        edtCEmail = findViewById(R.id.customerEmailTextInputEditText);
        btnCSave = findViewById(R.id.customerbutton);

        btnCSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cID = edtCustomerID.getText().toString().trim();
                String fName = edtFirstName.getText().toString().trim();
                String lName = edtLastName.getText().toString().trim();
                String cEmail = edtCEmail.getText().toString().trim();

                if(cID.isEmpty()){
                    edtCustomerID.setError("Please enter Customer ID");
                } else if(fName.isEmpty()){
                    edtFirstName.setError("Please enter First Name");
                } else if(lName.isEmpty()){
                    edtLastName.setError("Please enter Last Name");
                } else if(cEmail.isEmpty()){
                    edtCEmail.setError("Please enter email");
                } else if(edtCEmail.getText().toString().matches("[A-Z0-9a-z.%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}")) {   //https://stackoverflow.com/questions/43747709/how-to-obtain-a-regular-expression-for-validation-email-address-for-one-domain-o

                    Customer customer = new Customer(cID, fName, lName, cEmail);
                    DataStorage.getInstance().addCustomer(customer.getCustomerId(), customer);
                    Intent cint = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
                    startActivity(cint);
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(AddNewCustomerActivity.this);
                    alert.setCancelable(false);
                    alert.setTitle("New Customer Creation Error");
                    alert.setMessage("Invalid Email");
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
