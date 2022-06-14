package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project.adapter.CategoryAdapter;
import com.example.project.databinding.FragmentMainBinding;
import com.example.project.interfaces.OnCategoryItemClickListener;
import com.example.project.models.Category;

public class MainFragment extends Fragment {

    FragmentMainBinding fragmentMainBinding;

    public MainFragment() {
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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

        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        fragmentMainBinding.randomLayout.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), EventActivity.class));
        });


        RecyclerView recyclerView = fragmentMainBinding.recyclerViewContainer;
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.hasFixedSize();


        return fragmentMainBinding.getRoot();
    }


}