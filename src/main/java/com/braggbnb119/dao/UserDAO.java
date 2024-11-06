package com.braggbnb119.dao;

import java.util.List;

import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.domain.User;

import java.util.Optional;




public interface UserDAO extends GenericDAO<User, Integer> {
  
	List<User> findAll();
	






}


