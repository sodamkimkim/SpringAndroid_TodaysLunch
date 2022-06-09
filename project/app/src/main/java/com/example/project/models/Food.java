package com.example.project.models;

import java.util.List;

public class Food {
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
}

