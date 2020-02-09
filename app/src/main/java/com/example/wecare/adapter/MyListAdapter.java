package com.example.wecare.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;  
import android.view.ViewGroup;  
import android.widget.ImageView;  
import android.widget.RelativeLayout;  
import android.widget.TextView;  
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wecare.R;
import com.example.wecare.model.CategoryResultVo;
import com.example.wecare.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{
    private List<CategoryResultVo> listdata;
  
   // RecyclerView recyclerView;  
    public MyListAdapter(List<CategoryResultVo> listdata) {
        this.listdata = listdata;  
    }  
    @Override  
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {  
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());  
        View listItem= layoutInflater.inflate(R.layout.layout_category_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);  
        return viewHolder;  
    }  
  
    @Override  
    public void onBindViewHolder(ViewHolder holder, int position) {  

        CategoryResultVo categoryResultVo = listdata.get(position);

        holder.txt_category.setText(categoryResultVo.getCategoryName());

        if (!TextUtils.isEmpty(categoryResultVo.getCategoryIcon())) {
            Picasso.get().load(Constants.IMAGE_Url + categoryResultVo.getCategoryIcon()).into(holder.img_category);
        }

    }  
  
  
    @Override  
    public int getItemCount() {  
        return listdata.size();
    }  
  
    public static class ViewHolder extends RecyclerView.ViewHolder {  
        public ImageView img_category;
        public TextView txt_category;

        public ViewHolder(View itemView) {  
            super(itemView);  
            this.img_category = (ImageView) itemView.findViewById(R.id.img_category);
            this.txt_category = (TextView) itemView.findViewById(R.id.txt_category);

        }  
    }  
}  

