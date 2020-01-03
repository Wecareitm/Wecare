package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Userselection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userselection);
    }

    public void ClickOnUser(View view) {

        Intent i =new Intent(Userselection.this,Login.class);
        startActivity(i);

    }

    public void ClickOnServicePersonal(View view) {

        Intent i =new Intent(Userselection.this,Servicepersonlogin.class);
        startActivity(i);

    }
}
