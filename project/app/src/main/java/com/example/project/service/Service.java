package com.example.project.service;

import com.example.project.models.Store;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:9090/lunch/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("stores")
    Call<List<Store>> get(@Query("limit") int limit);

}
