package com.example.project.models;

import com.example.project.Define.CategoryType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Food implements Serializable {
    //    NOODLE, RICE, SOUP, BUNSIG, DIET, INSTANT,OVERSEA, SEASON
    private String foodName;
    private String url;
    private List<String> category;
    private List<Store> storelist;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<Store> getStorelist() {
        return storelist;
    }

    public void setStorelist(List<Store> storelist) {
        this.storelist = storelist;
    }

    public Food() {
    }

    public Food(String foodName, String url, List<String> category, List<Store> storelist) {
        this.foodName = foodName;
        this.url = url;
        this.category = category;
        this.storelist = storelist;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", url='" + url + '\'' +
                ", category=" + category +
                ", storelist=" + storelist +
                '}';
    }

}
