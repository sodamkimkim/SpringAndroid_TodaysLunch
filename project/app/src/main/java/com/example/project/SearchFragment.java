package com.example.project;

import static com.example.project.Define.CategoryType.*;
import static com.example.project.Define.CategoryType.DIET;
import static com.example.project.Define.CategoryType.OVERSEA;
import static com.example.project.Define.CategoryType.SEASON;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.project.Define.CategoryType;
import com.example.project.adapter.EditStoreAdapter;
import com.example.project.databinding.FragmentSearchBinding;
import com.example.project.models.Food;
import com.example.project.models.Store;
import com.example.project.service.Service;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {
    private Service service;
    private EditStoreAdapter editStoreAdapter;

    private FragmentSearchBinding fragmentSearchBinding;
    private Button searchbutton;
    private TextInputLayout foodNameTextEdit;
    private TextInputLayout foodUrlEdit;
    private ImageView UrlimageView;
    private EditText foodName;
    private Button submitBtn;
    private Button deleteBtn;
    private HashMap<CategoryType, CheckBox> checkBoxHashMap;
    boolean editMode = false;

    private Food food;


    public SearchFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false);
        initData();
        addEvent();
        return fragmentSearchBinding.getRoot();
    }

    private void initData() {
        service = Service.retrofit.create(Service.class);

        searchbutton = fragmentSearchBinding.searchBtn;
        foodNameTextEdit = fragmentSearchBinding.textField;
        foodUrlEdit = fragmentSearchBinding.foodUrlField;
        UrlimageView = fragmentSearchBinding.showUrlImg;
        submitBtn = fragmentSearchBinding.submitbtn;
        deleteBtn = fragmentSearchBinding.deletbtn;
        foodName = fragmentSearchBinding.searchFoodName;


        checkBoxHashMap = new HashMap<CategoryType, CheckBox>();
        checkBoxHashMap.put(RICE, fragmentSearchBinding.checkRice);
        checkBoxHashMap.put(NOODLE, fragmentSearchBinding.checkNoodle);
        checkBoxHashMap.put(SOUP, fragmentSearchBinding.checkSoup);
        checkBoxHashMap.put(BUNSIG, fragmentSearchBinding.checkBunsig);
        checkBoxHashMap.put(INSTANT, fragmentSearchBinding.checkInstant);
        checkBoxHashMap.put(SEASON, fragmentSearchBinding.checkSeasonFood);
        checkBoxHashMap.put(DIET, fragmentSearchBinding.checkDietFood);
        checkBoxHashMap.put(OVERSEA, fragmentSearchBinding.checkOverseaFood);
    }

    private void addEvent() {
        searchbutton.setOnClickListener(view -> {
            if (!(editMode)) {
                changeSearchbtnState(false);
                String name = foodName.getText().toString();
                if (!(name == null || name.equals(""))) {
                    requestFoodInfo(name);
                } else {
                    alertMessage("이름을 입력해주세요");
                    changeSearchbtnState(true);
                }

            } else {
                changeSearchbtnState(true);
            }
        });

        foodUrlEdit.setStartIconOnClickListener(view -> {
            Log.d("TAG", "url 버튼 클릭");
            String url = String.valueOf(fragmentSearchBinding.urlText.getText());
            drawImage(url);
        });

        submitBtn.setOnClickListener(view -> {
            Log.d("TAG", "submit 버튼 클릭");
            readCategory();
        });

        fragmentSearchBinding.addStoreInput.setOnClickListener(view -> {
            editStoreAdapter.addStore();
        });
    }

    private void drawImage(String url) {
        Glide.with(this)
                .load(url)
                .centerCrop()
                .transform(new CenterCrop(), new RoundedCorners(10))
                .into(UrlimageView);
    }

    private ArrayList<String> readCategory() {
        ArrayList<String> selectedCategory = new ArrayList<String>();
        Iterator<Map.Entry<CategoryType, CheckBox>> categoryboxs = checkBoxHashMap.entrySet().iterator();
        while (categoryboxs.hasNext()) {
            Map.Entry<CategoryType, CheckBox> box = categoryboxs.next();
            if (box.getValue().isChecked() == true) {
                selectedCategory.add(box.getKey().toString());
            }
        }
        Log.d("TAG", selectedCategory.toString());

        return selectedCategory;
    }

    private void loadCategory(List<String> categoryList) {
        for (String category : categoryList) {
            switch (category) {
                case "RICE":
                    checkBoxHashMap.get(RICE).setChecked(true);
                    break;
                case "NOODLE":
                    checkBoxHashMap.get(NOODLE).setChecked(true);
                    break;
                case "SOUP":
                    checkBoxHashMap.get(SOUP).setChecked(true);
                    break;
                case "BUNSIG":
                    checkBoxHashMap.get(BUNSIG).setChecked(true);
                    break;
                case "INSTANT":
                    checkBoxHashMap.get(INSTANT).setChecked(true);
                    break;
                case "SEASON":
                    checkBoxHashMap.get(SEASON).setChecked(true);
                    break;
                case "DIET":
                    checkBoxHashMap.get(DIET).setChecked(true);
                    break;
                case "OVERSEA":
                    checkBoxHashMap.get(OVERSEA).setChecked(true);
            }
        }
    }

    private void requestFoodInfo(String foodName) {
        service.loadFood(foodName).enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if (response.isSuccessful()) {
                    Log.d("TAG", response.body().toString());
                    Food food = response.body();
                    writeFoodData(food);
                    drawRecyclerView(food.getStorelist());

                }

            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {
                alertMessage("해당하신 이름의 메뉴는 없습니다.");
                changeSearchbtnState(true);
            }
        });

    }

    private void writeFoodData(Food food) {
        loadCategory(food.getCategory());
        fragmentSearchBinding.urlText.setText(food.getUrl());
        drawImage(food.getUrl());

    }

    private void drawRecyclerView(List<Store> stores) {
        editStoreAdapter = new EditStoreAdapter();
        editStoreAdapter.loadList(stores);
        fragmentSearchBinding.storeEditFleid.setAdapter(editStoreAdapter);
        fragmentSearchBinding.storeEditFleid.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentSearchBinding.storeEditFleid.hasFixedSize();
    }

    private void changeSearchbtnState(Boolean state) {
        if (!(state)) {
            editMode = true;
            foodNameTextEdit.setEnabled(false);
            submitBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            searchbutton.setBackgroundColor(Color.YELLOW);
        } else {
            editMode = false;
            foodNameTextEdit.setEnabled(true);
            fragmentSearchBinding.submitbtn.setEnabled(false);
            fragmentSearchBinding.deletbtn.setEnabled(false);
            searchbutton.setBackgroundColor(Color.WHITE);
        }

    }

    public void alertMessage(String message) {
        AlertDialog.Builder alertMsg = new AlertDialog.Builder(getContext());
        alertMsg.setTitle("ALERT");
        alertMsg.setMessage(message);
        alertMsg.show();
    }


}