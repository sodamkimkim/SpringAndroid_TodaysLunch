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

public class EditStoreAdapter extends RecyclerView.Adapter<EditStoreAdapter.ViewHolder> {
    private ImageView imageView;
    private TextView itemBtn;
    TextView staticIdView;
    private List<Store> stores = new ArrayList<Store>();
    private static int BOX_ID = 0;


    public List<Store> getStores() {
        return stores;
    }

    public void loadList(List<Store> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(i);
        }
        stores = list;
        notifyDataSetChanged();
    }

    public void addStore() {
        Store store = new Store();
        store.setId(stores.size());
        stores.add(store);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.itme_store_edit, parent, false);

        imageView = itemView.findViewById(R.id.removebtn);
        staticIdView = itemView.findViewById(R.id.staticId);
        itemBtn = itemView.findViewById(R.id.itemBtn);
        Log.d("TAGS", "viw_id : " + staticIdView.getText().toString());

        imageView.setOnClickListener(view -> {
            for (Store store : stores) {
                Log.d("TAGS", "store : " + store.getId());
                if (store.getId() == Integer.parseInt(staticIdView.getText().toString())) {
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


    public class ViewHolder extends RecyclerView.ViewHolder {
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


            itemBtn.setOnClickListener(view -> {
                staticIdView = itemView.findViewById(R.id.staticId);
                int id = Integer.parseInt(staticIdView.getText().toString());
                if (itemBtn.getText().toString().equals("UPDATE")) {
                    // 2번쨰 버튼을 눌렀을 때 3번째가 버튼이 바뀌는 오류를 수정해야함
                    setEditMode(true);
                } else {
                    saveStore(id);
                    setEditMode(false);
                }
            });
        }

        private void setEditMode(Boolean state) {
            if (state) {
                itemBtn.setText("SAVE");
                storeName.setEnabled(true);
                storeUrl.setEnabled(true);
                storeAddress.setEnabled(true);
                storedistance.setEnabled(true);

            } else {
                itemBtn.setText("UPDATE");
                storeName.setEnabled(false);
                storeUrl.setEnabled(false);
                storeAddress.setEnabled(false);
                storedistance.setEnabled(false);
            }
        }

        public void writeItem(Store store) {
            if (store.getStoreName() == null) {
                setEditMode(true);
            } else {
                setEditMode(false);
            }
            storeName.setText(store.getStoreName());
            storeUrl.setText(store.getImgurl());
            storeAddress.setText(store.getAddress());
            storedistance.setText(String.valueOf(store.getDistance()));
            staticId.setText(String.valueOf(store.getId()));
        }

        public Store saveStore(int id) {
            Store store = null;
            for (Store s : stores) {
                if (s.getId() == id) {
                    s.setStoreName(storeName.getText().toString());
                    s.setImgurl(storeUrl.getText().toString());
                    s.setAddress(storeAddress.getText().toString());
                    s.setDistance(Integer.parseInt(storedistance.getText().toString()));
                    store = s;
                }
            }
            return store;
        }
    }
}
