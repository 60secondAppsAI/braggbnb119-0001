package com.braggbnb119.dao;

import java.util.List;

import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.domain.Property;





public interface PropertyDAO extends GenericDAO<Property, Integer> {
  
	List<Property> findAll();
	






}


