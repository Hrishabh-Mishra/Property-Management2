package com.hrishabhmishra.propertymanagement.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * Beans will be created at runtime, and Spring will know this class
 * is the Exception Handler for the entire project.
 */
@ControllerAdvice
public class CustomExceptionHandler {
	
	//Following is typical handler for business exception.
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex) {
		return new ResponseEntity<>(bex.getErrorList(), HttpStatus.BAD_REQUEST);
	}

}
