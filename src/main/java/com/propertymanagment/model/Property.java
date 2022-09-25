package com.propertymanagment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="PROPERTY_TABLE")
public class Property 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="PROPERTY_TITLE", nullable=false)
	private String title;
	private String description;
	private String ownerName;
	
	@Column(name="EMAIL", nullable=false)
	private String ownerEmail;
	
	private float price;
	private String address;
}
