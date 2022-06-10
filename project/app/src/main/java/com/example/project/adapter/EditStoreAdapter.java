package com.example.project.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.models.Store;

import java.util.ArrayList;
import java.util.List;

public class EditStoreAdapter extends RecyclerView.Adapter<EditStoreAdapter.ViewHolder>{
    private ImageView imageView;
    private List<Store> stores = new ArrayList<Store>();
    private static int BOX_ID = 0;

    public void loadList(List<Store> list){
        stores = list;
        notifyDataSetChanged();
    }

    public void addStore(){
        Store store = new Store();
        stores.add(store);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.itme_store_edit, parent, false);
        imageView = itemView.findViewById(R.id.removebtn);
        TextView staticIdView = itemView.findViewById(R.id.staticId);
        Log.d("TAG", staticIdView.getText().toString());

        imageView.setOnClickListener(view -> {
            for (Store store : stores) {
                Log.d("TAG", "store : " + store.getId());
                if(store.getId() == Integer.parseInt(staticIdView.getText().toString())){
                    stores.remove(store);
                    notifyDataSetChanged();
                }
            }
        });

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Store store = stores.get(position);
        holder.writeItem(store);


    }

    @Override
    public int getItemCount() {
        return stores.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        EditText storeName;
        EditText storeUrl;
        EditText storeAddress;
        EditText storedistance;
        TextView staticId;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            storeName = itemView.findViewById(R.id.storeName);
            storeUrl = itemView.findViewById(R.id.storeUrl);
            storeAddress = itemView.findViewById(R.id.storeAddress);
            storedistance = itemView.findViewById(R.id.storeDistance);
            staticId = itemView.findViewById(R.id.staticId);
        }

        public void writeItem(Store store){
            storeName.setText(store.getStoreName());
            storeUrl.setText(store.getImgurl());
            storeAddress.setText(store.getAddress());
            storedistance.setText(String.valueOf(store.getDistance()));
            store.setId(BOX_ID);
            staticId.setText(String.valueOf(BOX_ID++));
        }
    }
}
