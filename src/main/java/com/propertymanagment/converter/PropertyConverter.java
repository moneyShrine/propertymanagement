package com.propertymanagment.converter;

import org.springframework.stereotype.Component;

import com.propertymanagment.dto.PropertyDTO;
import com.propertymanagment.model.Property;

/*
 *This is to ensure loose coupling, so that incase the 
 *database column changes it wont affect the controller layer	
 */
@Component
public class PropertyConverter {

	//Converts Property Data Transfer Object to Property Entity/Model
	public Property convertToEntity(PropertyDTO propertyDTO) {
		System.out.println("\nSTARTS Convert To Entity");
		
		Property property = new Property();
		property.setTitle(propertyDTO.getTitle());
		property.setDescription(propertyDTO.getDescription());
		property.setPrice(propertyDTO.getPrice());
		property.setAddress(propertyDTO.getAddress());
		property.setOwnerName(propertyDTO.getOwnerName());
		property.setOwnerEmail(propertyDTO.getOwnerEmail());
		
		System.out.println("ENDS Convert To Entity");
		return property; 
	}
	
	public PropertyDTO convertToDTO(Property propertyEntity) {
		System.out.println("\nSTARTS Convert To DTO");
	
		PropertyDTO propertyDTO = new PropertyDTO();
		propertyDTO.setId(propertyEntity.getId());
		propertyDTO.setTitle(propertyEntity.getTitle());
		propertyDTO.setDescription(propertyEntity.getDescription());
		propertyDTO.setPrice(propertyEntity.getPrice());
		propertyDTO.setAddress(propertyEntity.getAddress());
		propertyDTO.setOwnerName(propertyEntity.getOwnerName());
		propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());

		System.out.println("ENDS Convert To DTO");
		return propertyDTO;
	}
}
