package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

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

public class Signup extends AppCompatActivity implements DataInterface {
    EditText edt_name,edt_mobile,edt_email,edt_password,edt_address;
    Button btn_register;
    Webservice_Volley volley;

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
        volley = new Webservice_Volley(this,this);
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
                    edt_address.setError("Please enter address");
                    edt_address.requestFocus();
                    return;
                }


                String url = Constants.Webserive_Url + "u_Signup.php";

                HashMap<String,String> params = new HashMap<>();
                params.put("u_name",edt_name.getText().toString());
                params.put("u_address",edt_address.getText().toString());
                params.put("u_pass",edt_password.getText().toString());
                params.put("u_email",edt_email.getText().toString());
                params.put("u_mobile",edt_mobile.getText().toString());

                volley.CallVolley(url,params,"registration");


        }
    });
}

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
    }
}
