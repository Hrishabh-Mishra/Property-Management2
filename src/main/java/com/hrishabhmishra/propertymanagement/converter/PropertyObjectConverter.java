package com.hrishabhmishra.propertymanagement.converter;

import org.springframework.context.annotation.Configuration;

import com.hrishabhmishra.propertymanagement.dto.PropertyDTO;
import com.hrishabhmishra.propertymanagement.entity.PropertyEntity;

/**
 * 
 * @author hrishabh
 *	Added another layer between Service and repository layer.
 *	This helps keep my code clean.
 */

@Configuration
public class PropertyObjectConverter {
	
	public PropertyEntity propropertyDTOtoEntityConverter(PropertyDTO propertyDTO) {
		
		PropertyEntity propertyEntity = new PropertyEntity();
		/**
		 * This variable conversion thst we are doing here is a part of
		 * STRUCTURAL DESIGN PATTERN.
		 * 
		 * It is known as Adapter design pattern.
		 */
		propertyEntity.setTitle(propertyDTO.getTitle());
		propertyEntity.setAddress(propertyDTO.getAddress());
		propertyEntity.setDescription(propertyDTO.getDescription());
		propertyEntity.setPrice(propertyDTO.getPrice());
		
		return propertyEntity;
		
	}
	
	public PropertyDTO propropertyEntitytoDTOConverter(PropertyEntity propertyEntity) {
		
		PropertyDTO propertyDTO = new PropertyDTO();
		/**
		 * This variable conversion thst we are doing here is a part of
		 * STRUCTURAL DESIGN PATTERN.
		 * 
		 * It is known as Adapter design pattern.
		 */
		
		propertyDTO.setTitle(propertyEntity.getTitle());
		propertyDTO.setAddress(propertyEntity.getAddress());
		propertyDTO.setDescription(propertyEntity.getDescription());
		propertyDTO.setPrice(propertyEntity.getPrice());
		
		return propertyDTO;
		
	}

}
