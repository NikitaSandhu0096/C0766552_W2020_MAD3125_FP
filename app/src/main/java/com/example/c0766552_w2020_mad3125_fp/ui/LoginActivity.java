package com.example.c0766552_w2020_mad3125_fp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.c0766552_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText edtEmail;
    private TextInputEditText edtPassword;
    private CheckBox cbRemember;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.emailTextInputEditText);
        edtPassword = findViewById(R.id.passwordTextInputEditText);
        cbRemember = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtEmail.getText().toString().equals("nsandhu@gmail.com") && edtPassword.getText().toString().equals("nsandhu")){
                    if (cbRemember.isChecked()){
                        
                    }
                }
            }
        });

    }
}
