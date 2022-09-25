package com.propertymanagment.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.propertymanagment.model.Calculator;

@RestController
@RequestMapping(value="/calculate")
public class CalculatorResources {

	@GetMapping(value="/add")
	public Double add(@RequestParam("num1")Double num1, @RequestParam("num2")Double num2) {
		return num1 + num2;
	}
	
	@GetMapping(value="/subtract/{num1}/{num2}")
	public Double subtract(@PathVariable("num1")Double num1, @PathVariable("num2")Double num2) {
		Double result = null;
		if(num1 > num2) {
			result = num1 - num2;
		}else if(num2 > num1) {
			result = num2 - num1;
		}else {
			result = 0.0;
		}
		return result;
	}
	
	@PostMapping(value="/multiply")
	public ResponseEntity<Double> multiply(@RequestBody Calculator calculator) 
	{
		Double result = null;
		result = calculator.getNum1() * calculator.getNum2() * calculator.getNum3() * calculator.getNum4();
		ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.OK);
		
		return responseEntity;
	}
}
