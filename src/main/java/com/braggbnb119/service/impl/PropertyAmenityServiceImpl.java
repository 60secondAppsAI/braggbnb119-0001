package com.braggbnb119.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.braggbnb119.dao.GenericDAO;
import com.braggbnb119.service.GenericService;
import com.braggbnb119.service.impl.GenericServiceImpl;
import com.braggbnb119.dao.PropertyAmenityDAO;
import com.braggbnb119.domain.PropertyAmenity;
import com.braggbnb119.dto.PropertyAmenityDTO;
import com.braggbnb119.dto.PropertyAmenitySearchDTO;
import com.braggbnb119.dto.PropertyAmenityPageDTO;
import com.braggbnb119.dto.PropertyAmenityConvertCriteriaDTO;
import com.braggbnb119.dto.common.RequestDTO;
import com.braggbnb119.dto.common.ResultDTO;
import com.braggbnb119.service.PropertyAmenityService;
import com.braggbnb119.util.ControllerUtils;





@Service
public class PropertyAmenityServiceImpl extends GenericServiceImpl<PropertyAmenity, Integer> implements PropertyAmenityService {

    private final static Logger logger = LoggerFactory.getLogger(PropertyAmenityServiceImpl.class);

	@Autowired
	PropertyAmenityDAO propertyAmenityDao;

	


	@Override
	public GenericDAO<PropertyAmenity, Integer> getDAO() {
		return (GenericDAO<PropertyAmenity, Integer>) propertyAmenityDao;
	}
	
	public List<PropertyAmenity> findAll () {
		List<PropertyAmenity> propertyAmenitys = propertyAmenityDao.findAll();
		
		return propertyAmenitys;	
		
	}

	public ResultDTO addPropertyAmenity(PropertyAmenityDTO propertyAmenityDTO, RequestDTO requestDTO) {

		PropertyAmenity propertyAmenity = new PropertyAmenity();

		propertyAmenity.setPropertyAmenityId(propertyAmenityDTO.getPropertyAmenityId());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		propertyAmenity = propertyAmenityDao.save(propertyAmenity);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<PropertyAmenity> getAllPropertyAmenitys(Pageable pageable) {
		return propertyAmenityDao.findAll(pageable);
	}

	public Page<PropertyAmenity> getAllPropertyAmenitys(Specification<PropertyAmenity> spec, Pageable pageable) {
		return propertyAmenityDao.findAll(spec, pageable);
	}

	public ResponseEntity<PropertyAmenityPageDTO> getPropertyAmenitys(PropertyAmenitySearchDTO propertyAmenitySearchDTO) {
	
			Integer propertyAmenityId = propertyAmenitySearchDTO.getPropertyAmenityId(); 
 			String sortBy = propertyAmenitySearchDTO.getSortBy();
			String sortOrder = propertyAmenitySearchDTO.getSortOrder();
			String searchQuery = propertyAmenitySearchDTO.getSearchQuery();
			Integer page = propertyAmenitySearchDTO.getPage();
			Integer size = propertyAmenitySearchDTO.getSize();

	        Specification<PropertyAmenity> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, propertyAmenityId, "propertyAmenityId"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<PropertyAmenity> propertyAmenitys = this.getAllPropertyAmenitys(spec, pageable);
		
		//System.out.println(String.valueOf(propertyAmenitys.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(propertyAmenitys.getTotalPages()));
		
		List<PropertyAmenity> propertyAmenitysList = propertyAmenitys.getContent();
		
		PropertyAmenityConvertCriteriaDTO convertCriteria = new PropertyAmenityConvertCriteriaDTO();
		List<PropertyAmenityDTO> propertyAmenityDTOs = this.convertPropertyAmenitysToPropertyAmenityDTOs(propertyAmenitysList,convertCriteria);
		
		PropertyAmenityPageDTO propertyAmenityPageDTO = new PropertyAmenityPageDTO();
		propertyAmenityPageDTO.setPropertyAmenitys(propertyAmenityDTOs);
		propertyAmenityPageDTO.setTotalElements(propertyAmenitys.getTotalElements());
		return ResponseEntity.ok(propertyAmenityPageDTO);
	}

	public List<PropertyAmenityDTO> convertPropertyAmenitysToPropertyAmenityDTOs(List<PropertyAmenity> propertyAmenitys, PropertyAmenityConvertCriteriaDTO convertCriteria) {
		
		List<PropertyAmenityDTO> propertyAmenityDTOs = new ArrayList<PropertyAmenityDTO>();
		
		for (PropertyAmenity propertyAmenity : propertyAmenitys) {
			propertyAmenityDTOs.add(convertPropertyAmenityToPropertyAmenityDTO(propertyAmenity,convertCriteria));
		}
		
		return propertyAmenityDTOs;

	}
	
	public PropertyAmenityDTO convertPropertyAmenityToPropertyAmenityDTO(PropertyAmenity propertyAmenity, PropertyAmenityConvertCriteriaDTO convertCriteria) {
		
		PropertyAmenityDTO propertyAmenityDTO = new PropertyAmenityDTO();
		
		propertyAmenityDTO.setPropertyAmenityId(propertyAmenity.getPropertyAmenityId());

	

		
		return propertyAmenityDTO;
	}

	public ResultDTO updatePropertyAmenity(PropertyAmenityDTO propertyAmenityDTO, RequestDTO requestDTO) {
		
		PropertyAmenity propertyAmenity = propertyAmenityDao.getById(propertyAmenityDTO.getPropertyAmenityId());

		propertyAmenity.setPropertyAmenityId(ControllerUtils.setValue(propertyAmenity.getPropertyAmenityId(), propertyAmenityDTO.getPropertyAmenityId()));



        propertyAmenity = propertyAmenityDao.save(propertyAmenity);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public PropertyAmenityDTO getPropertyAmenityDTOById(Integer propertyAmenityId) {
	
		PropertyAmenity propertyAmenity = propertyAmenityDao.getById(propertyAmenityId);
			
		
		PropertyAmenityConvertCriteriaDTO convertCriteria = new PropertyAmenityConvertCriteriaDTO();
		return(this.convertPropertyAmenityToPropertyAmenityDTO(propertyAmenity,convertCriteria));
	}







}
