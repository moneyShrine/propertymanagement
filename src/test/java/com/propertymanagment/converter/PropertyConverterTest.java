package com.propertymanagment.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.propertymanagment.dto.PropertyDTO;
import com.propertymanagment.model.Property;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

	@InjectMocks
	private PropertyConverter propertyConverter;
	
	private static PropertyDTO propertyDTO;
	private static Property propertyEntity;
	
	@BeforeAll
	static void init() {
		propertyDTO = new PropertyDTO();
		propertyDTO.setId(3L);
		propertyDTO.setTitle("Dummy Title");
		propertyDTO.setPrice(75840);
		
		propertyEntity = new Property();
		propertyEntity.setId(5L);
		propertyEntity.setTitle("Dummy Entity Title");
		propertyEntity.setPrice(5000);
	}
	
	@Test
	@DisplayName("Test Success Scenario for Convert To Entity")
	void testConvertToEntity() {
		System.out.println("Test Success Scenario for Convert To Entity");
		
		Property propertyEntity = propertyConverter.convertToEntity(propertyDTO);
		
		assertEquals(propertyDTO.getTitle(), propertyEntity.getTitle());
		assertEquals(propertyDTO.getPrice(), propertyEntity.getPrice());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Convert To DTO")
	void testConvertToDTO() {
		System.out.println("Test Success Scenario for Convert To DTO");
		
		PropertyDTO dto = propertyConverter.convertToDTO(propertyEntity);
		
		assertEquals(propertyEntity.getId(), dto.getId());
		assertEquals(propertyEntity.getTitle(), dto.getTitle());
		assertEquals(propertyEntity.getPrice(), dto.getPrice());
	}
	
	@AfterAll
	static void destroy() {
		propertyDTO = null;
		propertyEntity = null;
	}
}
