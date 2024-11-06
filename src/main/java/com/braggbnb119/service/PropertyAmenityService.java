package com.braggbnb119.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.braggbnb119.domain.PropertyAmenity;
import com.braggbnb119.dto.PropertyAmenityDTO;
import com.braggbnb119.dto.PropertyAmenitySearchDTO;
import com.braggbnb119.dto.PropertyAmenityPageDTO;
import com.braggbnb119.dto.PropertyAmenityConvertCriteriaDTO;
import com.braggbnb119.service.GenericService;
import com.braggbnb119.dto.common.RequestDTO;
import com.braggbnb119.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PropertyAmenityService extends GenericService<PropertyAmenity, Integer> {

	List<PropertyAmenity> findAll();

	ResultDTO addPropertyAmenity(PropertyAmenityDTO propertyAmenityDTO, RequestDTO requestDTO);

	ResultDTO updatePropertyAmenity(PropertyAmenityDTO propertyAmenityDTO, RequestDTO requestDTO);

    Page<PropertyAmenity> getAllPropertyAmenitys(Pageable pageable);

    Page<PropertyAmenity> getAllPropertyAmenitys(Specification<PropertyAmenity> spec, Pageable pageable);

	ResponseEntity<PropertyAmenityPageDTO> getPropertyAmenitys(PropertyAmenitySearchDTO propertyAmenitySearchDTO);
	
	List<PropertyAmenityDTO> convertPropertyAmenitysToPropertyAmenityDTOs(List<PropertyAmenity> propertyAmenitys, PropertyAmenityConvertCriteriaDTO convertCriteria);

	PropertyAmenityDTO getPropertyAmenityDTOById(Integer propertyAmenityId);







}





