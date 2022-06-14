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
import com.example.project.interfaces.OnMapItemClickListener;
import com.example.project.models.Food;
import com.example.project.models.Store;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder>{
    ArrayList<Food> list;
    OnFoodItemClickListener onFoodItemClickListener;

    public void setOnFoodItemClickListener(OnFoodItemClickListener onFoodItemClickListener){
        this.onFoodItemClickListener =onFoodItemClickListener;
    }
    public void addItem(List<Food> foods) {
        list = (ArrayList<Food>) foods;

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_food_card2,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Food food = list.get(position);
        holder.drawFoodList(food);
        holder.itemView.setOnClickListener(view->{
         onFoodItemClickListener.onItemClicked(food);

        });

    }

    @Override
    public int getItemCount() {
        return list.size();    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private ImageView foodImageView;
        private TextView foodTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodTextView = itemView.findViewById(R.id.foodTitleTextView);
        }

        public void drawFoodList(Food food) {
            Glide.with(foodImageView.getContext())
                    .load(food.getUrl())
                    .centerCrop()
                    .transform(new CenterCrop(),new RoundedCorners(10))
                    .into(foodImageView);
            foodTextView.setText(food.getFoodName());

        }
    }
}
