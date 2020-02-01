package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.example.wecare.utils.Commonfunction;
import com.example.wecare.utils.Constants;
import com.example.wecare.utils.DataInterface;
import com.example.wecare.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class Complaint extends AppCompatActivity implements DataInterface {

    TextView txt_complaint;
    EditText edit_Complaint;
    Button  btn_PostComplaint;
    Webservice_Volley volley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        txt_complaint = (TextView) findViewById(R.id.txt_complaint);
        edit_Complaint = (EditText) findViewById(R.id.edit_Complaint);
        btn_PostComplaint = (Button) findViewById(R.id.btn_PostComplaint);

        volley = new Webservice_Volley(this, this);

        btn_PostComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Commonfunction.checkString(edit_Complaint.getText().toString())){
                    edit_Complaint.setError("Please enter your comment");
                    edit_Complaint.requestFocus();
                    return;
                }


                String url = Constants.Webserive_Url + "complaintAPI.php";

                HashMap<String,String> params = new HashMap<>();
                params.put("f_comment",edit_Complaint.getText().toString());

                volley.CallVolley(url,params,"complaintAPI");

            }
        });

    }
    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();
    }

}
