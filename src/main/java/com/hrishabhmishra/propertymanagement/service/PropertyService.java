package com.hrishabhmishra.propertymanagement.service;

import java.util.List;

import com.hrishabhmishra.propertymanagement.dto.PropertyDTO;

public interface PropertyService {
	
	PropertyDTO saveProperty (PropertyDTO propertyDTO);//Create an entry in the property.
	List<PropertyDTO> getAll(); //Return the list of all the properties.
	PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId); //Full update of the entry.
	PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyId); //partial update (Just one or two fields) of the entry.
	PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);
	PropertyDTO updatePropertyAddress(PropertyDTO propertyDTO, Long propertyId);
	PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
	void deleteProperty(Long propertyId);
}
