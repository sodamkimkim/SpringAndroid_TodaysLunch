package com.example.todaylunch.dto;

import lombok.Data;

@Data
public class ErrorDto {
	private String field;
	private String message;
}
