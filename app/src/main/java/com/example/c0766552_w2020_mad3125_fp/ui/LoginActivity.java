package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.example.c0766552_w2020_mad3125_fp.util.DataStorage;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;
    private CheckBox cbRemember;
    private Button btnLogin;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actBar = getSupportActionBar();
        actBar.setTitle("Login");

        edtEmail = findViewById(R.id.emailTextInputEditText);
        edtPassword = findViewById(R.id.passwordTextInputEditText);
        cbRemember = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.loginbutton);
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        edtEmail.setText(sharedPreferences.getString("email",null));
        edtPassword.setText(sharedPreferences.getString("password",null));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = edtEmail.getText().toString().trim();
                String password1 = edtPassword.getText().toString().trim();

                if(email1.isEmpty()){
                    edtEmail.setError("Please enter email");
                } else if(password1.isEmpty()){
                    edtPassword.setError("Please enter password");
                } else if(edtEmail.getText().toString().equals("nsandhu@gmail.com") && edtPassword.getText().toString().equals("nsandhu")){
                    String email = edtEmail.getText().toString();
                    String password = edtPassword.getText().toString();
                    if (cbRemember.isChecked()){
                        editor.putString("email",email);
                        editor.putString("password",password);
                        editor.apply();
                      //  Toast.makeText(LoginActivity.this, "Checked", Toast.LENGTH_SHORT).show();;
                        Intent intent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(intent);
                    }else {
                        editor.clear();
                        editor.apply();
                     //   Toast.makeText(LoginActivity.this, "UnChecked", Toast.LENGTH_SHORT).show();;
                        Intent intent = new Intent(LoginActivity.this, CustomerListActivity.class);
                        startActivity(intent);
                    }
                } else {
                    AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                    alert.setCancelable(false);
                    alert.setTitle("Login Error");
                    alert.setMessage("Invalid User ID and Password");
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
