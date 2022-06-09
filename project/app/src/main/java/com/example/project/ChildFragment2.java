package com.example.project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.adapter.FoodAdapter;
import com.example.project.interfaces.OnFoodItemClickListener;
import com.example.project.models.Food;


public class ChildFragment2 extends Fragment {

    public ChildFragment2() {
        // Required empty public constructor
    }

    public static ChildFragment2 newInstance() {
        ChildFragment2 fragment = new ChildFragment2();
               return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        FoodAdapter foodAdapter = new FoodAdapter(Food.getFoodData2(), getActivity(), new OnFoodItemClickListener() {
            @Override
            public void onItemClicked(View view, int position) {

            }
        });

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_child1, container, false);

        RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recyclerView2);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.hasFixedSize();



        return rootview;
    }
}