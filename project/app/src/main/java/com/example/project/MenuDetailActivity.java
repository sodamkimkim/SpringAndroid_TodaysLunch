package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.project.adapter.StoreAdapter;
import com.example.project.databinding.ActivityCategoryDetailBinding;
import com.example.project.databinding.ActivityMenuDetailBinding;
import com.example.project.models.Food;
import com.example.project.models.Store;
import com.example.project.service.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuDetailActivity extends AppCompatActivity {


    public static final String PARAM_NAME_1 = "food obj";
    private ActivityMenuDetailBinding binding;
    private Service service;
    private Food food;
    private ArrayList<Store> stores;
    StoreAdapter storeAdapter;
    String TAG = "TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getIntent()!=null) {
            food = (Food) getIntent().getSerializableExtra(PARAM_NAME_1);
        }


        binding = ActivityMenuDetailBinding.inflate(getLayoutInflater());
        service = Service.retrofit.create(Service.class);
        stores = new ArrayList<Store>();
        requestCategoryData();
        RecyclerView recyclerView = binding.recyclerView4;
        storeAdapter = new StoreAdapter();
        storeAdapter.addItem(stores);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(storeAdapter);
        recyclerView.hasFixedSize();


    }


    private void requestCategoryData() {
        Log.d(TAG, "requestCategoryData: " + stores.toString());
        service.loadFood(food.getFoodName()).enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if (response.isSuccessful()) {
                    if(response.body().getStorelist().size() == 0){
                        requestCategoryData();
                    }
                    Food tempFood = response.body();
                    drawFood(tempFood);
                }
            }
            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                Log.d(TAG, "통신 실패");
            }
        });
        setContentView(binding.getRoot());
    }

    private void drawFood(Food food){
        binding.foodNameTextView.setText(food.getFoodName());

        Glide.with(binding.menuImageView.getContext())
                .load(food.getUrl())
                .centerCrop()
                .transform(new CenterCrop())
                .into(binding.menuImageView);

        stores.addAll(food.getStorelist());
        Collections.sort(stores, new Comparator<Store>() {
            @Override
            public int compare(Store store, Store t1) {
                int result = -1;
                if(store.getDistance() >= t1.getDistance()) {
                    result = 1;
                }
                return result;
            }
        });
        storeAdapter.addItem(stores);
        Log.d(TAG, "templist: "+stores.toString());

//        for (Store store : templist) {
//            store.setStoreName(store.getStoreName());
//            store.setImgurl(store.getImgurl());
//            store.setAddress(store.getAddress());
//            store.setDistance(store.getDistance());
//            stores.add(store);
//
//            Log.d(TAG, "for문 안: " + stores.toString());
//        }
    }

}