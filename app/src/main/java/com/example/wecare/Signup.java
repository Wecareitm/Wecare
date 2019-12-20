package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wecare.utils.Commonfunction;

public class Signup extends AppCompatActivity {
    EditText edt_name,edt_mobile,edt_email,edt_password,edt_address;
    Button btn_register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_mobile = (EditText)findViewById(R.id.edt_mobile);
        edt_email = (EditText)findViewById(R.id.edt_email);
        edt_password = (EditText)findViewById(R.id.edt_password);
        edt_address = (EditText)findViewById(R.id.edt_address);
        btn_register = (Button)findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Commonfunction.checkString(edt_name.getText().toString())){
                    edt_name.setError("Please enter name");
                edt_name.requestFocus();
                return;
            }
                if (!Commonfunction.checkMobileNo(edt_mobile.getText().toString())){
                    edt_mobile.setError("Please enter mobile no");
                    edt_mobile.requestFocus();
                    return;
                }
                if (!Commonfunction.checkEmail(edt_email.getText().toString())){
                    edt_email.setError("Please enter Email");
                    edt_email.requestFocus();
                    return;

                }
                if (!Commonfunction.checkPassword(edt_password.getText().toString())){
                    edt_password.setError("PLease enter valid password");
                    edt_password.requestFocus();
                    return;
                }
                if (!Commonfunction.checkString(edt_address.getText().toString())){
                    edt_address.setError("Please ener address");
                    edt_address.requestFocus();
                    return;
                }

        }
    });
}}
