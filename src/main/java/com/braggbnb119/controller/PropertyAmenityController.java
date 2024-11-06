package com.braggbnb119.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.braggbnb119.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.braggbnb119.domain.PropertyAmenity;
import com.braggbnb119.dto.PropertyAmenityDTO;
import com.braggbnb119.dto.PropertyAmenitySearchDTO;
import com.braggbnb119.dto.PropertyAmenityPageDTO;
import com.braggbnb119.service.PropertyAmenityService;
import com.braggbnb119.dto.common.RequestDTO;
import com.braggbnb119.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/propertyAmenity")
@RestController
public class PropertyAmenityController {

	private final static Logger logger = LoggerFactory.getLogger(PropertyAmenityController.class);

	@Autowired
	PropertyAmenityService propertyAmenityService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<PropertyAmenity> getAll() {

		List<PropertyAmenity> propertyAmenitys = propertyAmenityService.findAll();
		
		return propertyAmenitys;	
	}

	@GetMapping(value = "/{propertyAmenityId}")
	@ResponseBody
	public PropertyAmenityDTO getPropertyAmenity(@PathVariable Integer propertyAmenityId) {
		
		return (propertyAmenityService.getPropertyAmenityDTOById(propertyAmenityId));
	}

 	@RequestMapping(value = "/addPropertyAmenity", method = RequestMethod.POST)
	public ResponseEntity<?> addPropertyAmenity(@RequestBody PropertyAmenityDTO propertyAmenityDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = propertyAmenityService.addPropertyAmenity(propertyAmenityDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/propertyAmenitys")
	public ResponseEntity<PropertyAmenityPageDTO> getPropertyAmenitys(PropertyAmenitySearchDTO propertyAmenitySearchDTO) {
 
		return propertyAmenityService.getPropertyAmenitys(propertyAmenitySearchDTO);
	}	

	@RequestMapping(value = "/updatePropertyAmenity", method = RequestMethod.POST)
	public ResponseEntity<?> updatePropertyAmenity(@RequestBody PropertyAmenityDTO propertyAmenityDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = propertyAmenityService.updatePropertyAmenity(propertyAmenityDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
