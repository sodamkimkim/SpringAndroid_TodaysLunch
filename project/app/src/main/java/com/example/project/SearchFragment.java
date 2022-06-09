package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.Define.CategoryType;
import com.example.project.databinding.FragmentSearchBinding;
import com.google.android.material.textfield.TextInputLayout;

public class SearchFragment extends Fragment {
    FragmentSearchBinding fragmentSearchBinding;
    Button searchbutton;
    TextInputLayout foodNameTextEdit;
    TextInputLayout foodUrlEdit;


    public SearchFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSearchBinding =FragmentSearchBinding.inflate(inflater,container,false);
        initData();
        addEvent();
        requestFoodInfo();
        return fragmentSearchBinding.getRoot();
    }

    private void addEvent() {
        searchbutton.setOnClickListener(view -> {
            Log.d("TAG", "searchPage의 searchbtn 클릭");
            foodNameTextEdit.setEnabled(true);
        });

       foodUrlEdit.setEndIconOnClickListener(view -> {
           Log.d("TAG","url 버튼 클릭");
       });
    }

    private void initData() {
        searchbutton = fragmentSearchBinding.searchBtn;
        foodNameTextEdit =fragmentSearchBinding.textField;
        foodUrlEdit = fragmentSearchBinding.foodUrlField;
    }

    private void requestFoodInfo() {

    }

    private void drawRecyclerView(){

    }
}