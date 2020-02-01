package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;
import com.example.wecare.utils.Webservice_Volley;

public class Complaint extends AppCompatActivity {

    TextView txt_complaint;
    EditText edit_Complaint;
    Button  btn_PostComplaint;
    Webservice_Volley volley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);

        txt_complaint =(TextView)findViewById(R.id.txt_complaint);
        edit_Complaint=(EditText)findViewById(R.id.edit_Complaint);
        btn_PostComplaint=(Button)findViewById(R.id.btn_PostComplaint);

        volley  = new Webservice_Volley(this,this);



    }
}
