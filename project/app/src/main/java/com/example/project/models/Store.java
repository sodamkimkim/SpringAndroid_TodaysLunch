package com.example.project.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {

    private String storeName;
    private double instance;
    private String image;

    public Store(String storeName, double instance, String image) {
        this.storeName = storeName;
        this.instance = instance;
        this.image = image;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String store) {
        this.storeName = store;
    }

    public double getInstance() {
        return instance;
    }

    public void setInstance(double instance) {
        this.instance = instance;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static ArrayList<Store> getStoreData() {
        ArrayList<Store> stores = new ArrayList<>();
        stores.add(new Store("store1", 1, "https://cdn.pixabay.com/photo/2017/07/20/15/21/chickens-2522623_960_720.jpg"));
        stores.add(new Store("store2", 2, "https://cdn.pixabay.com/photo/2018/06/04/13/36/cold-noodles-3453218__340.jpg"));
        stores.add(new Store("store3", 3, "https://cdn.pixabay.com/photo/2012/04/11/17/31/vegetables-29063__340.png"));
        stores.add(new Store("store4", 4, "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032__480.jpg"));
        stores.add(new Store("store5", 5, "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011__340.jpg"));
        stores.add(new Store("store6", 6, "https://cdn.pixabay.com/photo/2017/02/02/14/04/grapes-2032838__340.jpg"));
        stores.add(new Store("store7", 7, "https://cdn.pixabay.com/photo/2014/12/21/23/25/apples-575317__340.png"));
        stores.add(new Store("store8", 8, "https://cdn.pixabay.com/photo/2017/05/07/08/56/pancakes-2291908__340.jpg"));
        stores.add(new Store("store9", 9, "https://cdn.pixabay.com/photo/2017/06/09/16/39/carrots-2387394__340.jpg"));
        stores.add(new Store("store10", 10, "https://cdn.pixabay.com/photo/2014/07/22/09/59/bread-399286__340.jpg"));

        return stores;
    }


}
