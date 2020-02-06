package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AreaselectionActivity extends AppCompatActivity {

    ListView lv_areas;

    ArrayList<String> citylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areaselection);

        lv_areas = (ListView)findViewById(R.id.lv_areas);

        citylist.add("Akota");
        citylist.add("Alkapuri");
        citylist.add("Fatehgunj");
        citylist.add("Manjalpur");
        citylist.add("Sama Road");
        citylist.add("Karelibaug");
        citylist.add("Chhani Road");
        citylist.add("Nizampura");
        citylist.add("Waghodiya Road");

        ArrayAdapter<String> da = new ArrayAdapter<>(AreaselectionActivity.this,android.R.layout.simple_list_item_1,citylist);
        lv_areas.setAdapter(da);

        lv_areas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent j = new Intent(AreaselectionActivity.this,UserHomepageActivity.class);
                startActivity(j);

            }
        });

    }
}
