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

public class Resetpassword extends AppCompatActivity implements DataInterface {
    EditText edt_newpassword,edt_confirmnewpassword;
    TextView txt_resetpassword;
    Button btn_reset;

    String userid="";

    Webservice_Volley volley;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        edt_newpassword = (EditText)findViewById(R.id.edt_email_mobile);
        edt_confirmnewpassword = (EditText)findViewById(R.id.edt_password);

        txt_resetpassword=(TextView)findViewById(R.id.txt_forgotpassword);
        btn_reset = (Button)findViewById(R.id.btn_login);


        volley = new Webservice_Volley(this,this);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Commonfunction.checkString(edt_newpassword.getText().toString())){
                    edt_newpassword.setError("Please enter new password");
                    edt_newpassword.requestFocus();
                    return;

                }

                if (!Commonfunction.checkPassword(edt_confirmnewpassword.getText().toString())){
                    edt_confirmnewpassword.setError("Please confirm new password");
                    edt_confirmnewpassword.requestFocus();
                    return;
                }


                String url = Constants.Webserive_Url + "u_resetpsw.php";

                HashMap<String,String> params = new HashMap<>();
                params.put("sp_password",edt_newpassword.getText().toString());
                params.put("sp_id",userid);

                volley.CallVolley(url,params,"u_resetpsw");


            }
        });
    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

    }
}
