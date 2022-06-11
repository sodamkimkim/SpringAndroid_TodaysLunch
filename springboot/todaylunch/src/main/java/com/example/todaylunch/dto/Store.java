package com.example.todaylunch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
	private String storeName;
	private String address;
	private String Imgurl;
    private double distance;
	private double latitude;
	private double longitude;
}
