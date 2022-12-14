package com.propertymanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propertymanagment.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

}
