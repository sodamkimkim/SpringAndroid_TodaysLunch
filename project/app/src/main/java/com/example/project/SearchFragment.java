package com.example.project;

import static com.example.project.Define.CategoryType.*;
import static com.example.project.Define.CategoryType.DIET;
import static com.example.project.Define.CategoryType.OVERSEA;
import static com.example.project.Define.CategoryType.SEASON;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.project.Define.CategoryType;
import com.example.project.Define.Mode;
import com.example.project.adapter.EditStoreAdapter;
import com.example.project.databinding.FragmentSearchBinding;
import com.example.project.models.Food;
import com.example.project.models.Store;
import com.example.project.service.Service;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private static SearchFragment instance;
    private Service service;
    private EditStoreAdapter editStoreAdapter;
    private FragmentSearchBinding fragmentSearchBinding;

    // 이벤트 처리를 위한 멤버변수
    private Button searchbutton;
    private TextInputLayout foodNameTextEdit;
    private TextInputLayout foodUrlEdit;
    private ImageView urlimageView;
    private EditText foodName;
    private Button submitBtn;
    private Button deleteBtn;
    private HashMap<CategoryType, CheckBox> checkBoxHashMap;

    // 현재 상황 설정
    private boolean editMode = false;
    private boolean postMode = false;
    private boolean updateMode = false;
    private Food tempfood;

    private SearchFragment() {
    }

    public static SearchFragment getInstance() {
        if(instance == null){
            instance = new SearchFragment();
        }
        return instance;
    }

    /**
     * 프래그먼트 생성
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 프래그먼트 뷰 생성
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false);
        initData();
        addEvent();
        return fragmentSearchBinding.getRoot();
    }

    /**
     * 프래그먼트 멤버변수 주소값 부여
     */
    private void initData() {
        service = Service.retrofit.create(Service.class);

        searchbutton = fragmentSearchBinding.searchBtn;
        foodNameTextEdit = fragmentSearchBinding.textField;
        foodUrlEdit = fragmentSearchBinding.foodUrlField;
        urlimageView = fragmentSearchBinding.showUrlImg;
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

    /**
     * 이벤트 등록
     */
    private void addEvent() {
        searchbutton.setOnClickListener(view -> {
            if (!(editMode)) {
                changeSearchbtnState(Mode.UPDATE);
                String name = foodName.getText().toString();
                if (!(name == null || name.equals(""))) {
                    requestFoodInfo(name);
                } else {
                    alertMessage("ALERT","이름을 입력해주세요");
                    changeSearchbtnState(Mode.NONTYPE);
                }

            } else {
                clearPage();
            }
        });

        foodUrlEdit.setStartIconOnClickListener(view -> {
            Log.d("TAG", "url 버튼 클릭");
            String url = String.valueOf(fragmentSearchBinding.urlText.getText());
            drawImage(url);
        });

        submitBtn.setOnClickListener(view -> {
            Log.d("TAGS" , "--" + foodName.getText().toString());
            tempfood.setFoodName(foodName.getText().toString());
            tempfood.setCategory(readCategory());
            tempfood.setUrl(fragmentSearchBinding.urlText.getText().toString());
            tempfood.setStorelist(editStoreAdapter.getStores());
            Log.d("TAGS", tempfood.toString());

            if(submitBtn.getText().toString().equals("POST")){
                postFoodDate(tempfood);
            }else{
                updateFoodDate(tempfood);
            }

        });

        deleteBtn.setOnClickListener(view -> {
            Log.d("TAGS", "deletebtn : "+foodName.getText().toString());
            deleteFoodDate(foodName.getText().toString());
            clearPage();
            alertMessage("DELETE 완료","수정이 완료되었습니다");

        });

        fragmentSearchBinding.addStoreInput.setOnClickListener(view -> {
            try{
                editStoreAdapter.addStore();
            }catch (NullPointerException e){
                Toast.makeText(getContext(), "foodName을 먼저 검색해주세요", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * url 이미지 드로잉
     * @param url
     */
    private void drawImage(Object url) {
            Glide.with(this)
                    .load(url)
                    .centerCrop()
                    .transform(new CenterCrop(), new RoundedCorners(10))
                    .into(urlimageView);

            if(urlimageView.getDrawable() == null){
                Glide.with(this)
                        .load(R.drawable.ic_baseline_fastfood_24)
                        .centerCrop()
                        .transform(new CenterCrop(), new RoundedCorners(10))
                        .into(urlimageView);
                Toast.makeText(getContext(), "올바른 이미지 주소가 아닙니다ㅁㄴ", Toast.LENGTH_SHORT).show();
            }
    }

    /**
     * 유저가 선택한 카테고리에 해당하는 스트링 값을 체크하여 스트링리스트로 반환
     * @return
     */
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

    /**
     * 페이지를 초기화
     */
    private void clearPage(){
        tempfood = new Food();
        tempfood.setCategory(new ArrayList<String>());
        tempfood.setStorelist(new ArrayList<Store>());
        writeFoodData(tempfood);
        urlimageView.setImageResource(R.drawable.ic_baseline_fastfood_24);
        foodName.setText("");
        clearCategory();
        drawRecyclerView(tempfood.getStorelist());
        changeSearchbtnState(Mode.NONTYPE);
    }

    /**
     * 카테고리 초기화
     */
    private void clearCategory(){
        checkBoxHashMap.forEach((categoryType, checkBox) -> {
            checkBox.setChecked(false);
        });
    }

    /**
     * 카테고리에 해당하는 리스트를 받으면 화면에 클릭된것으로 표시하는 기능
     * @param categoryList
     */
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

    /**
     * 서버에게 Food 데이터를 요청
     * @param foodName
     */
    private void requestFoodInfo(String foodName) {
        service.loadFood(foodName).enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {

                if (response.isSuccessful()) {
                    Log.d("TAGS", response.body().toString());
                    Food food = response.body();
                    tempfood = food;
                    writeFoodData(food);
                    drawRecyclerView(food.getStorelist());

                }else{
                    String tempName = fragmentSearchBinding.searchFoodName.getText().toString();
                    clearPage();
                    fragmentSearchBinding.searchFoodName.setText(tempName);
                    changeSearchbtnState(Mode.POST);
                    alertMessage("ALERT","메뉴가 없으므로 POST모드로 전환됩니다. \n 취소하시려면 search 버튼을 클릭해주세요");
                }

            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });

    }

    /**
     * food 데이터를 화면에 드로잉
     * @param food
     */
    private void writeFoodData(Food food) {
        loadCategory(food.getCategory());
        fragmentSearchBinding.urlText.setText(food.getUrl());
        drawImage(food.getUrl());

    }

    /**
     * 스토어 리스트에 해당하는 리사이클러 뷰를 드로잉
     * @param stores
     */
    private void drawRecyclerView(List<Store> stores) {
        editStoreAdapter = new EditStoreAdapter();
        editStoreAdapter.loadList(stores);
        fragmentSearchBinding.storeEditFleid.setAdapter(editStoreAdapter);
        fragmentSearchBinding.storeEditFleid.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentSearchBinding.storeEditFleid.hasFixedSize();
    }

    /**
     * 데이터 추가를 서버에 요청
     * @param food
     */
    private void postFoodDate(Food food){
        service.createFood(food).enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if(response.isSuccessful()){
                    clearPage();
                    alertMessage("POST 성공", "등록이 완료되었습니다");
                }else{
                    alertMessage("POST 실패", "정보를 다시확인해 주세요");
                }
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });

    }

    /**
     * food 데이터 갱신을 서버에 요청
     * @param food
     */
    private void updateFoodDate(Food food){
        service.updateFood(food).enqueue(new Callback<Food>() {
            @Override
            public void onResponse(Call<Food> call, Response<Food> response) {
                if(response.body() != null){
                    clearPage();
                    alertMessage("UPDATE 성공", "수정이 완료되었습니다");
                }else {
                    alertMessage("UPDATE 실패", "정보를 다시확인해주세요");
                }
            }

            @Override
            public void onFailure(Call<Food> call, Throwable t) {

            }
        });
    }

    /**
     * 서버에 해당 foodName의 데이터를 삭제를 요청
     * @param foodName
     */
    private void deleteFoodDate(String foodName){
        service.deleteFood(foodName).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {}
            @Override
            public void onFailure(Call<String> call, Throwable t) {}
        });
    }

    /**
     * 버튼 선택에 따른 프래그먼트의 동작을 지정
     * @param mode
     */
    private void changeSearchbtnState(Mode mode) {
        if (mode.equals(Mode.UPDATE)) {
            editMode = true;
            updateMode = true;
            postMode = false;
            foodNameTextEdit.setEnabled(false);
            submitBtn.setText("UPDATE");
            submitBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            searchbutton.setBackgroundColor(Color.YELLOW);
        } else if(mode.equals(Mode.NONTYPE)){
            editMode = false;
            updateMode = false;
            postMode = false;
            foodNameTextEdit.setEnabled(true);
            submitBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
            searchbutton.setBackgroundColor(Color.WHITE);
        } else if(mode.equals(Mode.POST)){
            editMode = true;
            postMode = true;
            updateMode = false;
            foodNameTextEdit.setEnabled(false);
            submitBtn.setEnabled(true);
            submitBtn.setText("POST");
            deleteBtn.setEnabled(false);
            searchbutton.setBackgroundColor(Color.YELLOW);
        }

    }

    /**
     * 메세지 표시
     * @param title
     * @param message
     */
    public void alertMessage(String title, String message) {
        AlertDialog.Builder alertMsg = new AlertDialog.Builder(getContext());
        alertMsg.setTitle(title);
        alertMsg.setMessage(message);
        alertMsg.show();
    }


}