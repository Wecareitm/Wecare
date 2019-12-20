package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wecare.utils.Commonfunction;

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

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Commonfunction.checkString(edt_email_mobile.getText().toString())) {
                    edt_email_mobile.setError("please enter valid Email");
                    edt_email_mobile.requestFocus();
                    return;
                }

                if (!Commonfunction.checkString(edt_password.getText().toString())) {
                    edt_password.setError("Password should be 6 char long");
                    edt_password.requestFocus();
                    return;
                }
            }

        });


       }
}
