package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Servicepersonlogin extends AppCompatActivity {
    EditText edt_email_mobile,edt_password;
    TextView txt_forgotpassword,txt_signup;
    Button btn_login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicepersonlogin);
        edt_email_mobile = (EditText)findViewById(R.id.edt_email_mobile);
        edt_password = (EditText)findViewById(R.id.edt_password);
        txt_forgotpassword = (TextView)findViewById(R.id.txt_forgotpassword);
        txt_signup = (TextView)findViewById(R.id.txt_signup);
        btn_login = (Button)findViewById(R.id.btn_login);

    }
}
