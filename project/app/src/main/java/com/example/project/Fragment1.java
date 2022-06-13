package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.adapter.CategoryAdapter;
import com.example.project.databinding.Fragment1Binding;
import com.example.project.interfaces.OnCategoryItemClickListener;
import com.example.project.models.Category;

public class Fragment1 extends Fragment {

    Fragment1Binding fragment1Binding;

    public Fragment1() {
    }

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        CategoryAdapter categoryAdapter = new CategoryAdapter(Category.getCategoryData(), getActivity(), new OnCategoryItemClickListener() {
            @Override
            public void onCategoryClicked(Category category) {
                Intent intent = new Intent(getContext(), CategoryRandomMenuDetailActivity.class);
                intent.putExtra(CategoryRandomMenuDetailActivity.PARAM_NAME, category.getCategory());
                startActivity(intent);
            }
        });

        fragment1Binding = Fragment1Binding.inflate(inflater, container, false);

        fragment1Binding.randomLayout.setOnClickListener(v -> {
            System.out.println("클릭!!!!");
            startActivity(new Intent(getContext(), AppRecommendationDetailActivity.class));
        });


        RecyclerView recyclerView = fragment1Binding.recyclerView1;
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.hasFixedSize();


        return fragment1Binding.getRoot();
    }


}