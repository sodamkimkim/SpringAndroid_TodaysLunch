package com.example.todaylunch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todaylunch.dto.ErrorDto;
import com.example.todaylunch.dto.Food;
import com.example.todaylunch.dto.Store;
import com.example.todaylunch.service.Service;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@RestController
@RequestMapping("/lunch")
@Validated
public class foodController {
	private Service service;
	
	public foodController() {
		this.service = Service.getinstance();
	}

	@GetMapping("/foods")
	public List<Food> food() {
		List<Food> foods = new ArrayList<Food>();
		foods = service.getFoodList();
		return foods;
	}
	
	@GetMapping("/food")
	public ResponseEntity<?> food(@NotEmpty @RequestParam String foodName) {	
		Food food = service.findFood(foodName);
		if(food == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(food);
	}
	@PostMapping("/food")
	public ResponseEntity<Food> food(@RequestBody Food food) {

		service.addFood(food);
		return ResponseEntity.status(HttpStatus.OK).body(food);

	}


@GetMapping("/storeInfo")
public Store Store(@NotNull @RequestParam String storeName){
	System.out.println("storeLocation호출됨");
	Store store = service.getStoreInfo(storeName);
	return store;
}


	
	@GetMapping("/todayfood")
	public Food randomfood() {
		return service.suffleFood();
	}
	
	@GetMapping("/stores")
	public List<Store> stores(@Min(1) @Max(10) @NotNull @RequestParam Integer limit){
		System.out.println("호출됨");
		List<Store> stores = service.getNearStorelist(limit);
		return stores;
		
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Food>> foods(@NotEmpty @RequestParam String category){
		System.out.println("호출됨");
		List<Food> categoryFood = service.getCategoryFood(category);
		return ResponseEntity.status(HttpStatus.OK).body(categoryFood);	
	}
}
