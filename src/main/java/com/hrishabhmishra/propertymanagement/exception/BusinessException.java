package com.hrishabhmishra.propertymanagement.exception;

import java.util.List;

public class BusinessException extends RuntimeException{ //Custom exception for my business logic.
	
	private List<ErrorModel> errorList;

	public BusinessException() {}
	
	public BusinessException(List<ErrorModel> errorList){
		this.errorList = errorList;
	}

	public List<ErrorModel> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorModel> errorList) {
		this.errorList = errorList;
	}

}
