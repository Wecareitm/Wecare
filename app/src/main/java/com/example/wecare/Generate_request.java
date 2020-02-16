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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Generate_request extends AppCompatActivity implements DataInterface {



    EditText edt_name,edt_mobile,edt_address,edt_service_details;
    Button btn_Generate_request;

    Webservice_Volley volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_request);
        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_mobile = (EditText)findViewById(R.id.edt_mobile);
        edt_address = (EditText)findViewById(R.id.edt_address);
        edt_service_details = (EditText)findViewById(R.id.edt_service_details);

        btn_Generate_request = (Button)findViewById(R.id.btn_Generate_request);

        volley = new Webservice_Volley(this,this);


        btn_Generate_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!Commonfunction.checkString(edt_name.getText().toString())) {
                    edt_name.setError("name should consist of 18 characters only!");
                    edt_name.requestFocus();
                    return;
                }

                if (!Commonfunction.checkString(edt_mobile.getText().toString())) {
                        edt_name.setError("Invalid Mobile number!");
                        edt_name.requestFocus();
                        return;
                }


                if (!Commonfunction.checkString(edt_address.getText().toString())) {
                            edt_name.setError("please enter address!");
                            edt_name.requestFocus();
                            return;
                }

                if (!Commonfunction.checkString(edt_service_details.getText().toString())) {
                                edt_name.setError("please enter service details!");
                                edt_name.requestFocus();
                                return;
                }
                String url = Constants.Webserive_Url + "generate_request.php";

                HashMap<String, String> params = new HashMap<>();

                params.put("customer_name", edt_name.getText().toString());
                params.put("phone_number", edt_mobile.getText().toString());
                params.put("address", edt_address.getText().toString());
                params.put("service_details", edt_service_details.getText().toString());
                params.put("service_type", "Home Care");
                params.put("customer_id", "1");
                params.put("amount", "12");
                params.put("duration", "23");
                params.put("order_date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                params.put("status", "pending");
                params.put("serviceperson_id","1");

                volley.CallVolley(url,params,"generate_request");

                }
    });
}

    @Override
    public void getData(JSONObject jsonObject, String tag) {

        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

    }
}
