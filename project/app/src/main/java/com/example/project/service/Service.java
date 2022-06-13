package com.example.project.service;

import com.example.project.models.Category;
import com.example.project.models.Food;
import com.example.project.models.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:9090/lunch/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @GET("todayfood")
    Call<Food> getTodayFood();

    @GET("stores")
    Call<List<Store>> getStores(@Query("limit") int limit);

    @GET("foods")
    Call<List<Food>> getFoods();

    @GET("food")
    Call<Food> loadFood(@Query("foodName") String foodName);

    @GET("category")
    Call<List<Food>> getCategoryFoods(@Query("category") String category);

    @GET("randomcategoryfood")
    Call<Food> getRandomCategoryFood(@Query("category") String category);


    @POST("food")
    Call<Food> createFood(@Body Food food);

    @POST("store")
    Call<Store> createStore(@Body Store store);

    @PUT("food")
    Call<Food> updateFood(@Body Food food);

    @DELETE("food")
    Call<String> deleteFood(@Query("foodName") String foodName);
 }
