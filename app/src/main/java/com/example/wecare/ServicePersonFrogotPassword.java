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

public class ServicePersonFrogotPassword extends AppCompatActivity implements DataInterface {
    TextView txt_forgotpass,txt_submit;

    EditText edt_email;
    Button btn_Submit;

    Webservice_Volley volley;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_person_frogot_password);
        edt_email = (EditText)findViewById(R.id.edt_email);
        btn_Submit = (Button)findViewById(R.id.btn_submit);
        volley = new Webservice_Volley(this,this);

        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Commonfunction.checkString(edt_email.getText().toString())){
                    edt_email.setError("Please enter your email");
                    edt_email.requestFocus();
                    return;

                }


                String url = Constants.Webserive_Url + "sp_forgotpsw.php";

                HashMap<String,String> params = new HashMap<>();
                params.put("sp_email",edt_email.getText().toString());
                volley.CallVolley(url,params,"sp_forgotpsw");


            }
        });

    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();



    }
}
