package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class Login extends AppCompatActivity implements DataInterface {

    TextView txt_forgotpassword,txt_signup;

    EditText edt_email_mobile,edt_password;
    Button btn_login;

    Webservice_Volley volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email_mobile = (EditText)findViewById(R.id.edt_email_mobile);
        edt_password = (EditText)findViewById(R.id.edt_password);

        txt_forgotpassword=(TextView)findViewById(R.id.txt_forgotpassword);
        btn_login = (Button)findViewById(R.id.btn_login);
        txt_signup = (TextView)findViewById(R.id.txt_signup);

        volley = new Webservice_Volley(this,this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Commonfunction.checkString(edt_email_mobile.getText().toString())){
                    edt_email_mobile.setError("Please enter your email or mobile");
                    edt_email_mobile.requestFocus();
                    return;

                }

                if (!Commonfunction.checkPassword(edt_password.getText().toString())){
                    edt_password.setError("Password should be 6 char long");
                    edt_password.requestFocus();
                    return;
                }


                String url = Constants.Webserive_Url + "u_login.php";

                HashMap<String,String> params = new HashMap<>();
                params.put("u_email",edt_email_mobile.getText().toString());
                params.put("u_pass",edt_password.getText().toString());

                volley.CallVolley(url,params,"login");


                            }
        });


        txt_forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, Forgotpassword.class);
                        startActivity(intent);


            }
        });
    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {

        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

        Intent i = new Intent(Login.this,AreaselectionActivity.class);
        startActivity(i);

    }

    public void ClickOnSignup(View view) {

        Intent intent=new Intent(Login.this, Signup.class);
        startActivity(intent);

    }
}
