package com.example.todaylunch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Store {
	private String storeName;
	private String address;
	private String Imgurl;
    private double distance;
}
