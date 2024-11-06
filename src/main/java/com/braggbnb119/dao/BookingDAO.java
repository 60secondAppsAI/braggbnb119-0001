package com.braggbnb119.dao;

import java.util.List;

import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.domain.Booking;





public interface BookingDAO extends GenericDAO<Booking, Integer> {
  
	List<Booking> findAll();
	






}


