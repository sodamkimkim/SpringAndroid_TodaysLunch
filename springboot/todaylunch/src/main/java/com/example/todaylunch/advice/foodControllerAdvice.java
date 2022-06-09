package com.example.todaylunch.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.todaylunch.dto.ErrorDto;

@RestControllerAdvice
public class foodControllerAdvice {
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e){
		ErrorDto errorDto = new ErrorDto();
		errorDto.setField(spiltText(e));
		errorDto.setMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto);
	}
	
	private String spiltText(Object object) {
		String[] temp = object.getClass().toString().split("\\.");
		return temp[temp.length-1];
	}
}
