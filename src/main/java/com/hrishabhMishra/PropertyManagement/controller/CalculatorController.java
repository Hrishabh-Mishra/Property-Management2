package com.hrishabhMishra.PropertyManagement.controller;

import java.net.http.HttpResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrishabhMishra.PropertyManagement.DTO.CalculatorDTO;

@RestController
@RequestMapping("/api/v1/calculator") //class level mapping
public class CalculatorController {
	
	//Getting parameters using request param.
	//http://localhost:8080/api/v1/calculator/add?num1=3.5&num2=6.5
	@GetMapping("/add") //method level mapping
	public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
		return num1+num2;
	}
	
	
	//Getting parameters using path variables.
	//Map the values of the url to java variable using the Path variable method;
	//Values are being passed in the url path itself - hence called @PathVariable. 
	@GetMapping("/difference/{num111}/{num222}")
	public Double difference(@PathVariable("num111") Double num1, @PathVariable("num222") Double num2) {
		return num1>num2? num1-num2:num2-num1;
	}
	
	/***
	 * Both the above methods can be used in a combination.
	 * PathVariable method or RequestParam method. (Both use GET method of the http request)
	 * 
	 * The problem is
	 * 1. Form multiple variables, above two methods, the url will be extremely lengthy.
	 * 3. the URL has a limit to its length - it may get cut short and the values may get lost.
	 * 2. The values are visible in the url, not good for security reasons.
	 * 
	 * 
	 * Another better way to get data - use POST request of the URL. It will use the DTO class
	 * of the calculator to map the data from the client (Browser).
	 * In POST mapping -
	 * 1. the client will send the data in JSON (key:value) format, rather than as a part of the URL.
	 * 1A. The data is passed in the http body rather than in http address.
	 * 2. The key must match with the variable name of the DTO object.
	 * 3. A browser can send only GET request. Hence we need Postman to sent POST request.
	 * 4. Since POST is used to create a record, the default HttpResponse (i.e 200 OK) must be change to CREATED
	 * 		This is important because:
	 * 			1. the client will receive data (multiplication result here)
	 * 			2. As well as proper status report. 
	 * 		This can be done by following example.
	 * 		
	 * 
	 */
	
	
	@PostMapping("/multiply")
	public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calDto) {
		ResponseEntity<Double> resEntity = new ResponseEntity<>(calDto.num1*calDto.num2*calDto.num3*calDto.num4, HttpStatus.CREATED);
		return resEntity;
	}
	
}
