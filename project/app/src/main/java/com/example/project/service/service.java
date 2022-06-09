package com.example.project.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface service {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
