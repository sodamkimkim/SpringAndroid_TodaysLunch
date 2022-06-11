package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.project.databinding.ActivityCategoryDetailBinding;
import com.example.project.models.Category;
import com.example.project.models.Food;
import com.example.project.models.Store;

// 데이터 전달받아서 화면 구성
public class CategoryDetailActivity extends AppCompatActivity {

    private Food food;
    public static final String PARAM_NAME_1 = "food obj";
    private ActivityCategoryDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent() != null) {
            food = (Food) getIntent().getSerializableExtra(PARAM_NAME_1);
            initData();
            addEventListener();
        }
    }


    private void initData() {
        binding.foodNameTextView.setText(food.getFoodName());
        Glide.with(this)

                .load(food.getUrl())
                .transform(new CenterCrop(), new RoundedCorners(10))
                .centerCrop()
                .into(binding.menuImageView);

    }

    private void addEventListener() {
    }
}