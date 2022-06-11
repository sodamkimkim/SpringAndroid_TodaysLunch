package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.adapter.CategoryAdapter;
import com.example.project.adapter.StoreAdapter;
import com.example.project.databinding.Fragment3Binding;
import com.example.project.interfaces.OnCategoryItemClickListener;
import com.example.project.interfaces.OnMapItemClickListener;
import com.example.project.models.Category;
import com.example.project.models.Store;
import com.example.project.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment3 extends Fragment implements OnMapItemClickListener {

    private static final String TAG = "TAG";
    private Fragment3Binding fragment3Binding;
    private StoreAdapter storeAdapter;
    private Service service;
    List<Store> stores;

    private int limit = 10;
    private OnMapItemClickListener onMapItemClickListener;


    public Fragment3(OnMapItemClickListener onMapItemClickListener) {
            this.onMapItemClickListener = onMapItemClickListener;
    }




//    public static Fragment3 getInstance(String param1, String param2) {
//        Fragment3 fragment = new Fragment3();
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = Service.retrofit.create(Service.class);
        stores = new ArrayList<Store>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        StoreAdapter storeAdapter = new StoreAdapter(Store.getStoreData(), getActivity());
        fragment3Binding = Fragment3Binding.inflate(inflater, container, false);
        setupRecyclerView(stores);

        return fragment3Binding.getRoot();
    }



    private void requestStoresData() {
        service.get(limit).enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if(response.isSuccessful()) {
                    stores = new ArrayList<Store>();

                    for (Store store: response.body()) {
                        Store s = new Store();
                        s.setStoreName(store.getStoreName());
                        s.setImgurl(store.getImgurl());
                        s.setAddress(store.getAddress());
                        s.setDistance(store.getDistance());
                        stores.add(s);
                    }
                    storeAdapter.addItem(stores);
                }
                Log.d(TAG, stores.toString());
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });

    }

    private void setupRecyclerView(List<Store> stores) {

        storeAdapter = new StoreAdapter();
        storeAdapter.addItem(stores);
        storeAdapter.setOnMapItemClickListener(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        fragment3Binding.recyclerView3.setAdapter(storeAdapter);
        fragment3Binding.recyclerView3.setLayoutManager(manager);
        fragment3Binding.recyclerView3.hasFixedSize();

        requestStoresData();




    }


    @Override
    public void selectedItem(Store store) {
        Intent intent = new Intent(getContext(), StoreMapActivity.class);
        startActivity(intent);
    }
}