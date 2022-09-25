package com.propertymanagment.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.propertymanagment.converter.PropertyConverter;
import com.propertymanagment.dto.PropertyDTO;
import com.propertymanagment.model.Property;
import com.propertymanagment.repository.PropertyRepository;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {
	
	@InjectMocks
	private PropertyServiceImpl propertyServiceImpl;	
	@Mock
	private PropertyConverter propertyConverter;
	@Mock
	private PropertyRepository propertyRepository;
	
	
	@Test
	@DisplayName("Test Success Scenario for Save Property")
	void testSaveProperty() {
		System.out.println("Test Success Scenario for Save Property");
		
		PropertyDTO dto = new PropertyDTO();
		dto.setTitle("Dummy Title");		

		Property entity = new Property();
		entity.setTitle("Dummy Entity Title");
		
		Property savedEntity = new Property();
		savedEntity.setId(98L);
		savedEntity.setTitle("Dummy Entity Title");

		PropertyDTO savedDTO = new PropertyDTO();
		savedDTO.setId(savedEntity.getId());
		savedDTO.setTitle(savedEntity.getTitle());
		
		Mockito.when(propertyConverter.convertToEntity(Mockito.any())).thenReturn(entity); //Returns PropertyEntity without an Id
		
		Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity); //Returns property Entity with an Id
		
		Mockito.when(propertyConverter.convertToDTO(Mockito.any())).thenReturn(savedDTO); //Returns a saved DTO with an Id
		
		PropertyDTO result = propertyServiceImpl.saveProperty(dto);
		
		Assertions.assertEquals(savedEntity.getId(), result.getId());
		Assertions.assertEquals(savedEntity.getTitle(), result.getTitle());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Get All Properties")
	void testGetAllProperties() {
		System.out.println("Test Success Scenario for Get All Properties");
		
		Property propertyEntity = new Property();
		propertyEntity.setId(98L);
		propertyEntity.setTitle("Dummy Title");
		propertyEntity.setPrice(98765);
		
		PropertyDTO dto = new PropertyDTO();
		dto.setId(98L);
		dto.setTitle("Dummy Title");
		dto.setPrice(98765);
		
		List<Property> list_of_entity = new ArrayList<>();
		list_of_entity.add(propertyEntity);
		
		Mockito.when(propertyRepository.findAll()).thenReturn(list_of_entity);
		
		Mockito.when(propertyConverter.convertToDTO(Mockito.any())).thenReturn(dto);
		
		Collection<PropertyDTO> result = propertyServiceImpl.getAllProperties();
		
		Assertions.assertEquals(1, result.size());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Update Property")
	void testUpdateProperty() {
		System.out.println("\nTest Success Scenario for Update Property");
		PropertyDTO dto = new PropertyDTO();
		dto.setId(98L);
		dto.setTitle("Dummy Title");
		dto.setPrice(98765);
		dto.setDescription("Dummy Description");
		dto.setAddress("Dummy Address");
		dto.setOwnerName("Dummy Owner Name");
		dto.setOwnerEmail("dummy@owneremail.com");
		
		Property propertyEntity = new Property();
		propertyEntity.setId(98L);
		propertyEntity.setTitle("Dummy Title");
		propertyEntity.setPrice(98765);
		propertyEntity.setDescription("Dummy Description");
		propertyEntity.setAddress("Dummy Address");
		propertyEntity.setOwnerName("Dummy Owner Name");
		propertyEntity.setOwnerEmail("dummy@owneremail.com");
		
		Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(propertyEntity));
		Mockito.when(propertyConverter.convertToDTO(Mockito.any())).thenReturn(dto);
		
		PropertyDTO updatedDTO = propertyServiceImpl.updateProperty(dto, dto.getId());
		
		Assertions.assertEquals(dto.getTitle(), updatedDTO.getTitle());
		Assertions.assertEquals(dto.getPrice(), updatedDTO.getPrice());
	}
	
	@Test
	@DisplayName("Test Success Scenario for Update Property Description")
	void testUpdatePropertyDescription() {
		System.out.println("Test Success Scenario for Update Property Description");
		
		Property propertyEntity = new Property();
		propertyEntity.setId(98L);
		propertyEntity.setDescription("Dummy Property Entity Description");
		
		PropertyDTO dto = new PropertyDTO();
		dto.setId(98L);
		dto.setDescription("Dummy Saved Property DTO Description");
		
		Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(propertyEntity));
		
		Mockito.when(propertyConverter.convertToDTO(Mockito.any())).thenReturn(dto);
		
		PropertyDTO  result = propertyServiceImpl.updatePropertyDescription(dto, dto.getId());
	
		Assertions.assertEquals(propertyEntity.getId(), result.getId());
		Assertions.assertEquals(propertyEntity.getDescription(), result.getDescription());
	}

}
