package com.example.project.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Store {
    private int id;
    private String storeName;
    private String address;
    private String imgurl;
    private int distance;
    private double latitude;
    private double longitude;

    public Store(){

    }
    public Store(int id, String storeName, String address, String imgurl, int distance, double latitude, double longitude) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.imgurl = imgurl;
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", address='" + address + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", distance=" + distance +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}