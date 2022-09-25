package com.propertymanagment.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ModelTester {

	@Test
	@DisplayName("Test All Models")
	void testAllModel() {
		BeanTester beanTester = new BeanTester();
		beanTester.testBean(Calculator.class);
		beanTester.testBean(Property.class);
	}
}
