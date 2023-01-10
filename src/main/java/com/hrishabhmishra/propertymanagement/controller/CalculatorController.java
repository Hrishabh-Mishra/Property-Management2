package com.hrishabhmishra.propertymanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrishabhmishra.propertymanagement.dto.CalculatorDTO;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping
public class CalculatorController {
	
	@GetMapping("/add") //method level mapping
	public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
		return num1+num2;
	}
	
	
	@GetMapping("/difference/{num111}/{num222}")
	public Double difference(@PathVariable("num111") Double num1, @PathVariable("num222") Double num2) {
		return num1>num2? num1-num2:num2-num1;
	}
	
	@PostMapping("/multiply")
	public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calDto) {
		return new ResponseEntity<>(calDto.num1*calDto.num2*calDto.num3*calDto.num4, HttpStatus.CREATED);
		
	}
	
}
