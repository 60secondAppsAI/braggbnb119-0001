package com.braggbnb119.dao;

import java.util.List;

import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.domain.Listing;





public interface ListingDAO extends GenericDAO<Listing, Integer> {
  
	List<Listing> findAll();
	






}


