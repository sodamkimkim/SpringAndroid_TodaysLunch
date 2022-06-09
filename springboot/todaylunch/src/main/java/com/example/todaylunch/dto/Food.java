package com.example.todaylunch.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {
	private String foodName;
	private String url;
    private List<String> category;
    private List<Store> storelist;
   
    
}
