package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecare.utils.Commonfunction;
import com.example.wecare.utils.Constants;
import com.example.wecare.utils.DataInterface;
import com.example.wecare.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class Servicepersonlogin extends AppCompatActivity implements DataInterface {
    EditText edt_email_mobile,edt_password;
    TextView txt_forgotpassword,txt_signup;
    Button btn_login;

    Webservice_Volley volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicepersonlogin);
        edt_email_mobile = (EditText)findViewById(R.id.edt_email_mobile);
        edt_password = (EditText)findViewById(R.id.edt_password);

        txt_forgotpassword = (TextView)findViewById(R.id.txt_forgotpassword);
        txt_signup = (TextView)findViewById(R.id.txt_signup);
        btn_login = (Button)findViewById(R.id.btn_login);

        volley = new Webservice_Volley(this,this);

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
                String url = Constants.Webserive_Url + "sp_login.php";


                HashMap<String,String> params = new HashMap<>();
                params.put("sp_email",edt_email_mobile.getText().toString());
                params.put("sp_password",edt_password.getText().toString());

                volley.CallVolley(url,params,"sp_login");
            }

        });
        txt_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Servicepersonlogin.this, Signup.class);
                startActivity(intent);


            }
        });

       }

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
    }

    public void ClickOnServicepersonsignup(View view) {
        Intent intent=new Intent(Servicepersonlogin.this, Servicepersonsignup.class);
        startActivity(intent);
    }
}
