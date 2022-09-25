package com.propertymanagment.resources;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.propertymanagment.dto.PropertyDTO;
import com.propertymanagment.service.impl.PropertyServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PropertyResourcesTest 
{
	@InjectMocks
	private PropertyResources propertyResources;
	
	@Mock
	private PropertyServiceImpl propertyServiceImpl;
	
	private static PropertyDTO propertyDTO;
	private static PropertyDTO savedProperty;
	
	@BeforeAll
	static void init() {
		propertyDTO = new PropertyDTO();
		propertyDTO.setId(23L);
		propertyDTO.setTitle("Dummy title");
		propertyDTO.setDescription("Dummy Description");
		propertyDTO.setPrice(500000);
		
		savedProperty= new PropertyDTO();
		savedProperty.setId(propertyDTO.getId());
		savedProperty.setTitle(propertyDTO.getTitle());
		savedProperty.setDescription(propertyDTO.getDescription());
		savedProperty.setPrice(propertyDTO.getPrice());
		
		System.out.println("OBJECTS INITIALIZED\n");
	}
	
	@Test
	@DisplayName("Test Success Scenario for Saving new Property")
	void testSaveProperty(){
		System.out.println("\nTest SAVE PROPERTY FUNCTION");			
		
		Mockito.when(propertyServiceImpl.saveProperty(propertyDTO)).thenReturn(savedProperty);
		
		ResponseEntity<PropertyDTO> responseResult = propertyResources.saveProperty(propertyDTO);
		
		Assertions.assertNotNull(responseResult.getBody().getId());
		assertEquals(HttpStatus.CREATED.value(), responseResult.getStatusCodeValue());
		
	}
	
	@Test
	@DisplayName("Test Success Scenario for Get All Property")
	void testGetAllProperties() {
		System.out.println("\nTest for Success Scenario for Get All Property");
		
		PropertyDTO propertyDTO = new PropertyDTO();
		propertyDTO.setId(35L);
		propertyDTO.setTitle("Dummy Property");
		propertyDTO.setPrice(25000);
		
		Collection<PropertyDTO> savedProperties = new ArrayList<>();
		savedProperties.add(propertyDTO);
		
		Mockito.when(propertyServiceImpl.getAllProperties()).thenReturn(savedProperties);
		
		ResponseEntity<Collection<PropertyDTO>> responseEntity = propertyResources.getAllProperties();
		
		Assertions.assertEquals(1, responseEntity.getBody().size());
		Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Update Property")
	void TestUpdateProperty() {
		System.out.println("\nTest Success Scenario for Update Property");
		
		Mockito.when(propertyServiceImpl.updateProperty(propertyDTO, propertyDTO.getId())).thenReturn(savedProperty);
		
		ResponseEntity<PropertyDTO> responseEntity = propertyResources.updateProperty(propertyDTO, propertyDTO.getId());
		
		Assertions.assertNotNull(responseEntity.getBody().getId());
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Update Property Description")
	void TestUpdatePropertyDescription() {
		System.out.println("\nTest Success Scenario for Update Property Description");
				
		Mockito.when(propertyServiceImpl.updatePropertyDescription(propertyDTO, propertyDTO.getId())).thenReturn(savedProperty);
		
		ResponseEntity<PropertyDTO> responseEntity = propertyResources.updatePropertyDescription(propertyDTO, propertyDTO.getId());
		
		Assertions.assertNotNull(responseEntity.getBody().getId());
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		assertEquals(propertyDTO.getDescription(), responseEntity.getBody().getDescription());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Update Property Price")
	void TestUpdatePropertyPrice() {
		System.out.println("\nTest Success Scenario for Update Property Price");
		
		Mockito.when(propertyServiceImpl.updatePropertyPrice(propertyDTO, propertyDTO.getId())).thenReturn(savedProperty);
		
		ResponseEntity<PropertyDTO> responseEntity = propertyResources.updatePropertyPrice(propertyDTO, propertyDTO.getId());
		
		Assertions.assertNotNull(responseEntity.getBody().getId());
		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
		assertEquals(propertyDTO.getPrice(), responseEntity.getBody().getPrice());
	}
	
	
	
	@AfterAll
	static void destroy() {
		propertyDTO = null;
		savedProperty = null;
		System.out.println("\nOBJECTS DESTROYED");
	}
}
