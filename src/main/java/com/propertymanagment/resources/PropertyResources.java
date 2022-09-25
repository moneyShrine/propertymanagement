package com.propertymanagment.resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.propertymanagment.dto.PropertyDTO;
import com.propertymanagment.service.impl.PropertyServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/v1")
public class PropertyResources {

	@Autowired
	private PropertyServiceImpl propertyServiceImpl;
	
	@GetMapping(value="/hello")
	public String sayHello() {
		return "Hello guys welcome";
	}
	
	@PostMapping(value="/properties")
	public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO) {
		log.info("PROPERTY CREATION STARTED");
		
		propertyDTO = propertyServiceImpl.saveProperty(propertyDTO);
		
		ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED); 
		log.info("Property nicely saved to database. \n Now returning Property!");
		return responseEntity;
	}
	
	@GetMapping(value="/properties")
	public ResponseEntity<Collection<PropertyDTO>> getAllProperties(){
		log.info("\nGETING ALL PROPERTIES METHOD/FUNCTION");
		
		Collection<PropertyDTO> propertyList = propertyServiceImpl.getAllProperties();		
		ResponseEntity<Collection<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList, HttpStatus.OK);
		
		log.info("ALL PROPERTIES GOTTEN \n");
		return responseEntity;		
	}
	
	@PutMapping(value="/properties/{propertyId}")
	public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		log.info("\nUPDATE PROPERTY STARTED");
		
		propertyDTO = propertyServiceImpl.updateProperty(propertyDTO, propertyId);
		
		ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
		
		log.info("\nRETURNING FETCHED DATA FOR UPDATE PROPERTY STARTED");
		return responseEntity;
	}
	
	@PatchMapping(value="/properties/update-description/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		log.info("\nSTARTED Update Property Description");
		
		propertyDTO = propertyServiceImpl.updatePropertyDescription(propertyDTO, propertyId);
		
		ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
		
		log.info("\nEND OF Update Property Description");
		return responseEntity;
	}
	
	@PatchMapping(value="/properties/update-price/{propertyId}")
	public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {
		log.info("START Update Property Price FUNCTION");
		
		propertyDTO = propertyServiceImpl.updatePropertyPrice(propertyDTO, propertyId);
		
		ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.OK);
		
		log.info("\nEND OF Update Property Price");
		return responseEntity;
	}
	
	@DeleteMapping(value="/properties/{propertyId}")
	public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
		propertyServiceImpl.deleteProperty(propertyId);
		
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		return responseEntity;
	}
}
