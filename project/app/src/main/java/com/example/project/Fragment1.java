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
import com.example.project.interfaces.OnCategoryItemClickListener;
import com.example.project.models.Category;

import java.util.ArrayList;

public class Fragment1 extends Fragment {



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
            public void onItemClicked(View view, int position) {
//                Log.d("TAG","넘겨받은 position : " + position);
//                Intent intent = new Intent(getCategoryData(), DetailActivity.class);
//                // 원래 intent는 object로 주고받지 못함.
//                //serializable : 직렬화.
//                // 직렬화 처리 --> object단위를 byte타입으로 변환시켜줌.
//                // 역직렬화 --> byte -> object
////                intent.putExtra("obj",Category.getCatagoryData().get(position));
//                startActivity(intent);
            }
        });

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_1, container, false);

        RecyclerView recyclerView = (RecyclerView)rootview.findViewById(R.id.recyclerView1);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.hasFixedSize();



        return rootview;
    }
}