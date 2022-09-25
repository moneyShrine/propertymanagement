package com.propertymanagment.service;

import java.util.Collection;


import com.propertymanagment.dto.PropertyDTO;

public interface PropertyService {
	PropertyDTO saveProperty(PropertyDTO propertyDTO);
	Collection<PropertyDTO> getAllProperties();
	PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
	PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
	PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
	void deleteProperty(Long propertyId);
}
