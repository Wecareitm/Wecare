package com.example.wecare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wecare.utils.Commonfunction;
import com.example.wecare.utils.Constants;
import com.example.wecare.utils.DataInterface;
import com.example.wecare.utils.Webservice_Volley;

import org.json.JSONObject;

import java.util.HashMap;

public class Feedback extends AppCompatActivity implements DataInterface {
    TextView txt_feedback;
    EditText edt_comment;
    RatingBar ratingBar2;
    Button btn_submit1;
    
    Webservice_Volley volley;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        txt_feedback = (TextView)findViewById(R.id.txt_feedback);
        edt_comment = (EditText)findViewById(R.id.edt_comment);
        ratingBar2 = (RatingBar)findViewById(R.id.ratingBar2);
        btn_submit1 = (Button)findViewById(R.id.btn_submit1);
        volley = new Webservice_Volley(this,this);
        
        btn_submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ratingBar2.getRating()<=0) {
                    Toast.makeText(Feedback.this, "Select Rating..", Toast.LENGTH_SHORT).show();
                    return;
                }

                String url = Constants.Webserive_Url + "feedbackAPI.php";
                HashMap<String,String> params = new HashMap<>();
                params.put("f_comment",edt_comment.getText().toString());
                params.put("f_rating","" + ratingBar2.getRating());


                volley.CallVolley(url,params,"feedbackAPI");


            }
                
               

                
        });
    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {
        Toast.makeText(this,jsonObject.toString(),Toast.LENGTH_SHORT).show();
    }
}
