package com.example.project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.adapter.StoreAdapter;
import com.example.project.databinding.FragmentNeareststoreBinding;
import com.example.project.interfaces.OnIntentCallback;
import com.example.project.interfaces.OnMapItemClickListener;
import com.example.project.models.Store;
import com.example.project.service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NearestStoreFragment extends Fragment implements OnMapItemClickListener {
    private FragmentNeareststoreBinding fragmentBinding;
    private StoreAdapter storeAdapter;
    private Service service;
    ArrayList<Store> stores;

    private int limit = 29;
    private OnMapItemClickListener onMapItemClickListener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = Service.retrofit.create(Service.class);
        stores = new ArrayList<Store>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentBinding = fragmentBinding.inflate(inflater, container, false);
        setupRecyclerView(stores);

        return fragmentBinding.getRoot();
    }


    private void requestStoresData() {
        service.getStores(limit).enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if (response.isSuccessful()) {
                    stores = new ArrayList<Store>();

                    for (Store store : response.body()) {
                        Store s = new Store();
                        s.setStoreName(store.getStoreName());
                        s.setImgurl(store.getImgurl());
                        s.setAddress(store.getAddress());
                        s.setDistance(store.getDistance());
                        stores.add(s);
                    }
                    storeAdapter.addItem(stores);
                }
            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });

    }

    private void setupRecyclerView(ArrayList<Store> stores) {

        storeAdapter = new StoreAdapter();
        storeAdapter.addItem(stores);
        storeAdapter.setOnMapItemClickListener(this);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());

        fragmentBinding.recyclerView3.setAdapter(storeAdapter);
        fragmentBinding.recyclerView3.setLayoutManager(manager);
        fragmentBinding.recyclerView3.hasFixedSize();

        requestStoresData();

    }


    @Override
    public void selectedItem(String addresss) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + addresss));
        startActivity(intent);
    }
}