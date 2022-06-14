package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.project.Define.CategoryType;
import com.example.project.adapter.FoodAdapter;
import com.example.project.databinding.Fragment3Binding;
import com.example.project.databinding.FragmentChild1Binding;
import com.example.project.interfaces.OnFoodItemClickListener;
import com.example.project.models.Food;
import com.example.project.models.Store;
import com.example.project.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChildFragment1 extends Fragment implements OnFoodItemClickListener {
    private static ChildFragment1 instance;
    private FragmentChild1Binding fragmentChild1Binding;
    private FoodAdapter foodAdapter;
    private Service service;
    ArrayList<Food> foods;

    private String category;

    private ChildFragment1() {
        service = Service.retrofit.create(Service.class);
    }

    public static ChildFragment1 getInstance() {
        if(instance == null){
            instance = new ChildFragment1();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        foods = new ArrayList<Food>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentChild1Binding = FragmentChild1Binding.inflate(inflater, container, false);
        setupRecyclerView(foods);

        return fragmentChild1Binding.getRoot();
    }

    private void setupRecyclerView(ArrayList<Food> foods) {
        foodAdapter = new FoodAdapter();
        foodAdapter.addItem(foods);
        foodAdapter.setOnFoodItemClickListener(this);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        fragmentChild1Binding.recyclerView2.setAdapter(foodAdapter);
        fragmentChild1Binding.recyclerView2.setLayoutManager(manager);
        fragmentChild1Binding.recyclerView2.hasFixedSize();

        requestFoodsData("");
    }

    public void requestFoodsData(String category) {
        switch (category){
            case "":
                loadFullFoods();
                break;
            default:
                loadCategoryFoods(category);
                break;
        }


    }

    private void loadFullFoods(){
        service.getFoods().enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {

                if (response.isSuccessful()) {
                    foods = new ArrayList<Food>();

                    for (Food food : response.body()) {
                        Food f = new Food();
                        f.setFoodName(food.getFoodName());
                        f.setUrl(food.getUrl());
                        foods.add(f);
                    }
                    foodAdapter.addItem(foods);
                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
            }
        });
    }

    private void loadCategoryFoods(String category){
        service.getCategoryFoods(category).enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {

                if (response.isSuccessful()) {
                    foods = new ArrayList<Food>();

                    for (Food food : response.body()) {
                        Food f = new Food();
                        f.setFoodName(food.getFoodName());
                        f.setUrl(food.getUrl());
                        foods.add(f);
                    }
                    foodAdapter.addItem(foods);
                }
            }
            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {
            }
        });
    }

    @Override
    public void onItemClicked(Food food) {
        Intent intent = new Intent(getContext(), MenuDetailActivity.class);
        intent.putExtra(MenuDetailActivity.PARAM_NAME_1, food);
        startActivity(intent);
    }
}