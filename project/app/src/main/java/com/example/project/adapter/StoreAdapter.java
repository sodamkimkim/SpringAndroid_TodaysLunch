package com.example.project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.project.R;
import com.example.project.models.Category;
import com.example.project.models.Store;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    ArrayList<Store> list;
    Context context;

    public StoreAdapter(ArrayList<Store> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.store, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.MyViewHolder holder, int position) {
        Store store = list.get(position);

        Glide.with(context)
                .load(store.getImgurl())
                .centerCrop()
                .transform(new CenterCrop())
                .into(holder.storeImage);
        holder.storeName.setText(store.getStoreName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView storeImage;
            private TextView storeName;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            storeImage = itemView.findViewById(R.id. image);
            storeName = itemView.findViewById(R.id.storeName);
        }


    }


}




