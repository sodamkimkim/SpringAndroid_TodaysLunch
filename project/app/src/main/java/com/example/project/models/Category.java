package com.example.project.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String thumbnail;
    private String title;
    private String category;

    public Category(String thumbnail, String title, String category) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.category = category;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public static ArrayList<Category> getCategoryData() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("https://cdn.pixabay.com/photo/2017/08/08/09/44/food-photography-2610863_960_720.jpg", "밥", "RICE"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2014/09/24/09/30/seafood-458853_960_720.jpg", "면", "NOODLE"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2018/12/03/01/04/spicy-seafood-3852529_960_720.jpg", "국물", "SOUP"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2016/02/26/11/42/toppokki-1223900_960_720.jpg", "분식", "BUNSIG"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2015/01/30/18/13/diet-617756_960_720.jpg", "다이어트", "DIET"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2020/03/21/11/17/burger-4953465_960_720.jpg", "간편식", "INSTANT"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2018/07/18/19/12/pasta-3547078_960_720.jpg", "다른나라", "OVERSEA"));
        categories.add(new Category("https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218_960_720.jpg", "계절요리", "SEASON"));
        return categories;
    }

}
