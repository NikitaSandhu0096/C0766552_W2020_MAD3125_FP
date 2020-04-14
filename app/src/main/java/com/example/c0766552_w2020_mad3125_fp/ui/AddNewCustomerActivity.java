package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c0766552_w2020_mad3125_fp.R;
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

        edtCustomerID = findViewById(R.id.customerIDTextInputEditText);
        edtFirstName = findViewById(R.id.firstNameTextInputEditText);
        edtLastName = findViewById(R.id.lastNameTextInputEditText);
        edtCEmail = findViewById(R.id.customerEmailTextInputEditText);
        btnCSave = findViewById(R.id.button2);

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
                } else {
                    Intent cint = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
                    startActivity(cint);
                }
            }
        });
    }
}
