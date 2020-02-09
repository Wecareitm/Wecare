package com.example.wecare.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wecare.R;
import com.example.wecare.adapter.MyListAdapter;
import com.example.wecare.model.CategoryInfoVo;
import com.example.wecare.utils.Constants;
import com.example.wecare.utils.DataInterface;
import com.example.wecare.utils.Webservice_Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;

public class HomeFragment extends Fragment implements DataInterface {

    RecyclerView recvCategory;

    Webservice_Volley volley;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recvCategory = (RecyclerView)root.findViewById(R.id.recvCategory);
        volley = new Webservice_Volley(getActivity(),this);


        String url = Constants.Webserive_Url + "get_category.php";

        HashMap<String,String> params = new HashMap<>();

        volley.CallVolley(url,params,"get_category");




        return root;
    }

    @Override
    public void getData(JSONObject jsonObject, String tag) {

        try {

            CategoryInfoVo categoryInfoVo = new Gson().fromJson(jsonObject.toString(),CategoryInfoVo.class);

            if (categoryInfoVo != null){

                if (categoryInfoVo.getResult() != null) {

                    if (categoryInfoVo.getResult().size() > 0) {

                        MyListAdapter adapter = new MyListAdapter(categoryInfoVo.getResult());
                        recvCategory.setAdapter(adapter);

                    }

                }

            }


        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}