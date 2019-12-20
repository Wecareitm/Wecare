package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wecare.utils.Commonfunction;

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

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Commonfunction.checkString(edt_name.getText().toString())){
                    edt_name.setError("name should consist of characters only!");
                    edt_name.requestFocus();
                    return;
                }


                if (!Commonfunction.checkMobileNo(edt_mobile.getText().toString())) {
                    edt_password.setError("minimum 10 numbers required!");
                    edt_password.requestFocus();
                    return;
                }

                if (!Commonfunction.checkEmail(edt_email.getText().toString())) {
                    edt_password.setError("Please enter valid email");
                    edt_password.requestFocus();
                    return;
                }

                if (!Commonfunction.checkPassword(edt_password.getText().toString())) {
                    edt_password.setError("Password should be 6 char long");
                    edt_password.requestFocus();
                    return;
                }

                if (!Commonfunction.checkString(edt_city.getText().toString())) {
                    edt_password.setError("Invalid city name");
                    edt_password.requestFocus();
                    return;
                }

                if (!Commonfunction.checkString(edt_address.getText().toString())) {
                    edt_password.setError("Invalid address");
                    edt_password.requestFocus();
                    return;
                }

                if (!Commonfunction.checkString(edt_servicetype.getText().toString())) {
                    edt_password.setError("Service type not found");
                    edt_password.requestFocus();
                    return;
                }



            }
        });
    }

}
