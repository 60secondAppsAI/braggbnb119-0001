package com.braggbnb119.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PropertySearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer propertyId;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String zipCode;
	
	private String country;
	
}
