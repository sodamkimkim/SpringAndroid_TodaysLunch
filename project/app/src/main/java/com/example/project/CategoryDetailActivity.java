package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.project.adapter.FoodAdapter;
import com.example.project.adapter.StoreAdapter;
import com.example.project.databinding.ActivityCategoryDetailBinding;
import com.example.project.databinding.Fragment1Binding;
import com.example.project.databinding.Fragment3Binding;
import com.example.project.models.Category;
import com.example.project.models.Food;
import com.example.project.models.Store;
import com.example.project.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// 데이터 전달받아서 화면 구성
public class CategoryDetailActivity extends AppCompatActivity {

    private ActivityCategoryDetailBinding binding;
    private Service service;
    private ArrayList<Store> stores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryDetailBinding.inflate(getLayoutInflater());
        service = Service.retrofit.create(Service.class);
        stores = new ArrayList<>();
        binding = ActivityCategoryDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        RecyclerView recyclerView = binding.recyclerView4;

        StoreAdapter storeAdapter = new StoreAdapter();

        storeAdapter.addItem(stores);

        LinearLayoutManager manager = new LinearLayoutManager(this);

        manager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(storeAdapter);

        recyclerView.hasFixedSize();


//        service.getStores(2).enqueue(new Callback<List<Store>>() {
//            @Override
//            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {
//                if (response.isSuccessful()) {
//                    System.out.println("통신하세요");
//                    for (Store store : response.body()) {
//                        Store s = new Store();
//                        s.setStoreName(store.getStoreName());
//                        s.setImgurl(store.getImgurl());
//                        s.setAddress(store.getAddress());
//                        s.setDistance(store.getDistance());
//                        stores.add(s);
//
//                    }
//                    storeAdapter.addItem(stores);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Store>> call, Throwable t) {
//
//            }
//        });

        requestCategoryData();

    }


    private void requestCategoryData() {
        stores.clear();
        service.getTodayFood().enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if (response.isSuccessful()) {
                    binding.foodNameTextView.setText(response.body().getFoodName());
                    Glide.with(binding.menuImageView.getContext())
                            .load(response.body().getUrl())
                            .centerCrop()
                            .transform(new CenterCrop())
                            .into(binding.menuImageView);
                }

                for (Store store: response.body().getStorelist()) {
                        stores.add(store);
                    }

                    System.out.println(stores);

            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });


    }


}