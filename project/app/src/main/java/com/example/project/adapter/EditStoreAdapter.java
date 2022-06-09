package com.example.project.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EditStoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class EditStoreViewHolder extends RecyclerView.ViewHolder {


        public EditStoreViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
