package com.example.project.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.project.R;
import com.example.project.interfaces.OnFoodItemClickListener;
import com.example.project.models.Food;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder2>{
    ArrayList<Food> list;
    Context context;
    OnFoodItemClickListener onFoodItemClickListener;

    public FoodAdapter(ArrayList<Food> list, Context context, OnFoodItemClickListener onFoodItemClickListener) {
        this.list = list;
        this.context = context;
        this.onFoodItemClickListener = onFoodItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food_card2,parent,false);
        return new MyViewHolder2(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        // BindViewHolder(화면과 연결)
        // data mapping
        Log.d("TAG", "position: " + position);
        Food food = list.get(position);
        Glide.with(context)
                .load(food.getThumbnail())
                .centerCrop()
                .transform(new CenterCrop(),new RoundedCorners(10))
                .into(holder.foodImageView);
        holder.foodTextView.setText(food.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();    }

    // 내부클래스
    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        //findviewbyid재활용해서 사용하기 위해서 만든 viewHolder
        private ImageView foodImageView;
        private TextView foodTextView;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodTextView = itemView.findViewById(R.id.foodTitleTextView);
            itemView.setOnClickListener(view->{
                Toast.makeText(view.getContext(),"TEST"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                onFoodItemClickListener.onItemClicked(itemView, getLayoutPosition());
            });
        }
    }
}
