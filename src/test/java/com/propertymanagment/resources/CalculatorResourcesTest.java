package com.propertymanagment.resources;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.propertymanagment.model.Calculator;

@ExtendWith(MockitoExtension.class)
public class CalculatorResourcesTest 
{	
	@InjectMocks
	private CalculatorResources calculatorResources;

	private static Double num1;
	private static Double num2;
	private static Double num3;
	private static Double num4;
		
	@BeforeAll
	static void beforeAll() {
		System.out.println("BEFORE ANY METHOD STARTS \n");
		num1 = 13.0;
		num2 = 11.0;
		num3 = 3.0;
		num4 = 4.0;
	}
	
	@AfterAll
	static void endsHere() {
		System.out.println("\nAFTER EVERY METHOD IT ENDS HERE");
		num1 = null;
		num2 = null;
		num3 = null;
		num4 = null;
	}
	
	@BeforeEach
	void init() {
		System.out.println("BEFORE EACH");		
	}
	
	@AfterEach
	void destroy() {
		System.out.println("AFTER EACH \n");
	}
	
	@Test
	@DisplayName("Test for Addition Success Scenario")
	void testAddFunction_Success() {
		System.out.println("Test for Addition Success Scenario");
		Double result = calculatorResources.add(num1, num2);
		System.out.println("RESULT FOR Addition Success IS : "+result);
		//Expected is 24.0
		//Always do an Assertion
		assertEquals(24.0, result);
	}
	
	@Test
	@DisplayName("Test for Addition Failure Scenario")
	void testAddFunction_Failure() {
		System.out.println("Test for Addition Failure Scenario");
		Double result = calculatorResources.add(num1, num2);
		System.out.println("RESULT FOR Addition Failure IS : "+result);
		//Expected is 24.0
		//Always do an Assertion
		Assertions.assertNotEquals(24.0, result);
	}

	@Test
	@DisplayName("Test Subtraction Success for num1>num2 Scenario")
	void testSubtractFunction_Success_num1_gt_num2() {
		System.out.println("Test for Subtraction Success Scenario");
		Double result = calculatorResources.subtract(num1, num2);
		System.out.println("RESULT FOR SUBTRACTION IS : "+result);
		//Expected is 0.6
		//Always do an Assertion
		assertEquals(2.0, result);		
	}
	
	//@Disabled
	@Test
	@DisplayName("Test Subtraction Success for num1<num2 Scenario")
	void testSubtractFunction_Success_num1_lt_num2() {
		System.out.println("Test for Subtraction Failure Scenario");
		Double result = calculatorResources.subtract(num1, num2);
		System.out.println("RESULT FOR SUBTRACTION IS : "+result);
		//Expected != -0.6
		//Always do an Assertion
		assertEquals(2.5, result);
	}
	
	@Test
	@DisplayName("Test Multiplication")
	void testMultiply() {
		System.out.println("Test for Multiplication Scenario");
		
		Calculator calculatorDTO = new Calculator();
		calculatorDTO.setNum1(num1);
		calculatorDTO.setNum2(num2);
		calculatorDTO.setNum3(num3);
		calculatorDTO.setNum4(num4);
		ResponseEntity<Double> result = calculatorResources.multiply(calculatorDTO);

		System.out.println("RESULT FOR MULTIPLICATION IS : "+result.getBody());
		assertEquals(1716.0, result.getBody());
		assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue(), "Expecting the Status as OK!");
	}
}
