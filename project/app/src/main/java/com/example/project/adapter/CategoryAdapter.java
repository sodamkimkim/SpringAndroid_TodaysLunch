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
import com.example.project.interfaces.OnCategoryItemClickListener;
import com.example.project.models.Category;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder>{
    ArrayList<Category> list;
    Context context;
    OnCategoryItemClickListener onCategoryItemClickListener;

    public CategoryAdapter(ArrayList<Category> list, Context context, OnCategoryItemClickListener onCategoryItemClickListener) {
        this.list = list;
        this.context = context;
        this.onCategoryItemClickListener = onCategoryItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(context)
                .inflate(R.layout.item_food_card,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    // BindViewHolder(화면과 연결)
    // data mapping
        Log.d("TAG", "position: " + position);
        Category category = list.get(position);
        Glide.with(context)
                .load(category.getThumbnail())
                .centerCrop()
                .transform(new CenterCrop(),new RoundedCorners(10))
                .into(holder.categoryTumbnail);
        holder.categoryTitle.setText(category.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 내부클래스
    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView categoryTumbnail;
        private TextView categoryTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTumbnail = itemView.findViewById(R.id.categoryImageView);
            categoryTitle = itemView.findViewById(R.id.titleTextView);
            itemView.setOnClickListener(view->{
                Toast.makeText(view.getContext(),"TEST"+getLayoutPosition(),Toast.LENGTH_SHORT).show();
                onCategoryItemClickListener.onItemClicked(itemView, getLayoutPosition());
            });
        }
    }
}
