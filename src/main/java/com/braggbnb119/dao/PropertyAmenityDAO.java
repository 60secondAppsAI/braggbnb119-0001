package com.braggbnb119.dao;

import java.util.List;

import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.domain.PropertyAmenity;





public interface PropertyAmenityDAO extends GenericDAO<PropertyAmenity, Integer> {
  
	List<PropertyAmenity> findAll();
	






}


