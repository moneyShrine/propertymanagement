package com.propertymanagment.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertymanagment.converter.PropertyConverter;
import com.propertymanagment.dto.PropertyDTO;
import com.propertymanagment.model.Property;
import com.propertymanagment.repository.PropertyRepository;
import com.propertymanagment.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService
{
	@Autowired
	private PropertyRepository propertyRepository;
	@Autowired
	private PropertyConverter propertyConverter;

	@Override
	public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
		System.out.println("\nStart Save Property In Service Property Impl");
		
		Property propertyEntity = propertyConverter.convertToEntity(propertyDTO);
		propertyEntity = propertyRepository.save(propertyEntity);
		
		propertyDTO = propertyConverter.convertToDTO(propertyEntity);		

		System.out.println("\nEnd Save Property In Service Property Impl");
		return propertyDTO;
	}

	@Override
	public Collection<PropertyDTO> getAllProperties() {
		Collection<Property> list_of_propertyEntity = propertyRepository.findAll();
		Collection<PropertyDTO> propertyDTO_List = new ArrayList<>();
		
		for(Property propertyEntity : list_of_propertyEntity) {
			PropertyDTO dto = propertyConverter.convertToDTO(propertyEntity);
			
			propertyDTO_List.add(dto);
		}
		return propertyDTO_List;
	}

	@Override
	public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
		Optional<Property> optEnt = propertyRepository.findById(propertyId);
		PropertyDTO dto = null;
		
		if(optEnt.isPresent()) {
			Property propertyEntity = optEnt.get(); //Gets the entire value from the database 
			
			propertyEntity.setTitle(propertyDTO.getTitle());
			propertyEntity.setDescription(propertyDTO.getDescription());
			propertyEntity.setPrice(propertyDTO.getPrice());
			propertyEntity.setAddress(propertyDTO.getAddress());
			propertyEntity.setOwnerName(propertyDTO.getOwnerName());
			propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());

			dto = propertyConverter.convertToDTO(propertyEntity); //Double checks that the inputed value is updated into database
		
			propertyRepository.save(propertyEntity);
		}
		
		return dto;
	}

	@Override
	public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
		System.out.println("Start Update Property Description");
		Optional<Property> optEnt = propertyRepository.findById(propertyId);
		PropertyDTO dto = null;
		
		if(optEnt.isPresent()) {
			Property propertyEntity = optEnt.get(); //Gets the entire value from the database 
			
			propertyEntity.setDescription(propertyDTO.getDescription());
			
			dto = propertyConverter.convertToDTO(propertyEntity); //Double checks that the inputed value is updated into database
			
			propertyRepository.save(propertyEntity);			
		}
		
		return dto;
	}

	@Override
	public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
		Optional<Property> optEnt = propertyRepository.findById(propertyId);
		PropertyDTO dto = null;
		
		if(optEnt.isPresent()) {
			Property propertyEntity = optEnt.get(); //Gets the entire value from the database 
			
			propertyEntity.setPrice(propertyDTO.getPrice());
			
			propertyRepository.save(propertyEntity);
			dto = propertyConverter.convertToDTO(propertyEntity); //Double checks that the inputed value is updated into database
		}
		
		return dto;
	}

	@Override
	public void deleteProperty(Long propertyId) {
		if(propertyRepository.findById(propertyId).isPresent()) {
			propertyRepository.deleteById(propertyId);
		}
		
	}

}
