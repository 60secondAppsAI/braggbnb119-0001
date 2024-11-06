package com.braggbnb119.dao;

import java.util.List;

import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.domain.Amenity;





public interface AmenityDAO extends GenericDAO<Amenity, Integer> {
  
	List<Amenity> findAll();
	






}


