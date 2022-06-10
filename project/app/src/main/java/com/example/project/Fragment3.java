package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.adapter.CategoryAdapter;
import com.example.project.adapter.StoreAdapter;
import com.example.project.databinding.Fragment3Binding;
import com.example.project.interfaces.OnCategoryItemClickListener;
import com.example.project.models.Category;
import com.example.project.models.Store;


public class Fragment3 extends Fragment {

    private Fragment3Binding fragment3Binding;

    private String storeName;
    private String address;
    private double distance;
    private String imgurl;

    private StoreAdapter storeAdapter;


    public Fragment3() {
        // Required empty public constructor
    }


    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        StoreAdapter storeAdapter = new StoreAdapter(Store.getStoreData(), getActivity());

        fragment3Binding = Fragment3Binding.inflate(inflater, container, false);






        return fragment3Binding.getRoot();
    }

    private void requestStoresData(int requestPage) {




    }

    private void setupRecyclerView(String storeName, String address, double distance, String imgurl){
        storeAdapter = new StoreAdapter();


    }






}