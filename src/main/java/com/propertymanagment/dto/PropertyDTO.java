package com.propertymanagment.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDTO {

	private Long id;	
	private String title;
	private String description;
	private String ownerName;
	private String ownerEmail;	
	private float price;
	private String address;
}
