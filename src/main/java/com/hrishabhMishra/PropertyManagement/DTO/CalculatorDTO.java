package com.hrishabhMishra.PropertyManagement.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalculatorDTO {
	
	public Double num1;
	public Double num2;
	public Double num3;
		/**
		 * if JSON body has different key name than the variable name in the DTO class
		 * we use @JsonProperty to map the mismatched variable name. Example below.
		 */
	@JsonProperty("number4")
	public Double num4;
	public Double num5;

}
