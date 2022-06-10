package com.example.project;

import static com.example.project.Define.CategoryType.*;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.project.Define.CategoryType;
import com.example.project.databinding.FragmentSearchBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SearchFragment extends Fragment {
    FragmentSearchBinding fragmentSearchBinding;
    Button searchbutton;
    TextInputLayout foodNameTextEdit;
    TextInputLayout foodUrlEdit;
    ImageView UrlimageView;
    Button submitBtn;
    Button deleteBtn;
    HashMap<CategoryType, CheckBox> checkBoxHashMap;
    boolean editMode = false;


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

    private void initData() {
        searchbutton = fragmentSearchBinding.searchBtn;
        foodNameTextEdit =fragmentSearchBinding.textField;
        foodUrlEdit = fragmentSearchBinding.foodUrlField;
        UrlimageView = fragmentSearchBinding.showUrlImg;
        submitBtn = fragmentSearchBinding.submitbtn;
        deleteBtn = fragmentSearchBinding.deletbtn;

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
            if(!(editMode)){
                editMode = true;
                //데이터가 통신이 이루어져야 하고 통신이 실패한다면 이벤트가 일어나서는 안됨
                foodNameTextEdit.setEnabled(false);
                submitBtn.setEnabled(true);
                deleteBtn.setEnabled(true);
                searchbutton.setBackgroundColor(Color.YELLOW);

            }else{
                editMode = false;
                foodNameTextEdit.setEnabled(true);
                fragmentSearchBinding.submitbtn.setEnabled(false);
                fragmentSearchBinding.deletbtn.setEnabled(false);
                searchbutton.setBackgroundColor(Color.WHITE);
            }

        });

       foodUrlEdit.setStartIconOnClickListener(view -> {
           Log.d("TAG","url 버튼 클릭");
           String url = String.valueOf(fragmentSearchBinding.urlText.getText());
           Glide.with(this)
                   .load(url)
                   .centerCrop()
                   .into(UrlimageView);
       });

       submitBtn.setOnClickListener(view -> {
           Log.d("TAG","submit 버튼 클릭");
           readCategory();
       });
    }

    private ArrayList<String> readCategory(){
        ArrayList<String> selectedCategory = new ArrayList<String>();
        Iterator<Map.Entry<CategoryType, CheckBox>> categoryboxs = checkBoxHashMap.entrySet().iterator();
        while(categoryboxs.hasNext()){
            Map.Entry<CategoryType, CheckBox> box = categoryboxs.next();
            if(box.getValue().isChecked() == true){
                selectedCategory.add(box.getKey().toString());
            }
        }
        Log.d("TAG", selectedCategory.toString());

        return selectedCategory;
    }

    private void loadCategory(List<String> categoryList){
        for (String category: categoryList) {
            switch (category){
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



    private void loadFoodData(){

    }

    private void requestFoodInfo() {

    }

    private void drawRecyclerView(){

    }
}