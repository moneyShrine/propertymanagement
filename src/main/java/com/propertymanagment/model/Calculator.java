package com.propertymanagment.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Calculator {
	private Double num1;
	private Double num2;
	private Double num3;
	
	@JsonProperty("num35")
	private Double num4;
	
}
