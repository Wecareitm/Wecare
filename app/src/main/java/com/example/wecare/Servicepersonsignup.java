package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Servicepersonsignup extends AppCompatActivity {
    EditText edt_name,edt_mobile,edt_email,edt_password,edt_city,edt_address,edt_servicetype;
    Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicepersonsignup);
        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_mobile = (EditText)findViewById(R.id.edt_mobile);
        edt_email = (EditText)findViewById(R.id.edt_email);
        edt_password = (EditText)findViewById(R.id.edt_password);
        edt_city = (EditText)findViewById(R.id.edt_city);
        edt_address= (EditText)findViewById(R.id.edt_address);
        edt_servicetype = (EditText)findViewById(R.id.edt_servicetype);
        btn_register = (Button)findViewById(R.id.btn_register);
    }

}
