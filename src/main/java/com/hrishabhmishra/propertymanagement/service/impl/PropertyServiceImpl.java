package com.hrishabhmishra.propertymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrishabhmishra.propertymanagement.dto.PropertyDTO;
import com.hrishabhmishra.propertymanagement.converter.PropertyObjectConverter;
import com.hrishabhmishra.propertymanagement.entity.PropertyEntity;
import com.hrishabhmishra.propertymanagement.repository.PropertyRepository;
import com.hrishabhmishra.propertymanagement.service.PropertyService;

@Service
/**
 * 
 *@Service - To create a singleton bean of this class by the spring itself during runtime.
 *Singleton bean is memory efficient.
 *Prototype bean - opposite of singleton.
 *					Multiple instances will be created and will get destroyed at runtime.
 *Other annotations that would have done the same thing are
 *@Configuration
 *@Component
 *@Repository
 *
 *but since this is a service class, we used @service
 *
 */
public class PropertyServiceImpl implements PropertyService{

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyObjectConverter converter;
	
	/**
	 * By default these methods are prototype bean.
	 * To have multiple save operations for different properties (Like land, apartment etc.)
	 */
	@Override
	public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
		
		PropertyEntity pe = converter.propropertyDTOtoEntityConverter(propertyDTO);
		pe = propertyRepository.save(pe);
		
		propertyDTO = converter.propropertyEntitytoDTOConverter(pe);
		
		return propertyDTO;
	}

	@Override
	public List<PropertyDTO> getAll() {
		List<PropertyEntity> propertyListEntity = (List<PropertyEntity>)propertyRepository.findAll();
		List<PropertyDTO> propertyListDTO = new ArrayList<>();
		for(PropertyEntity propertyEntity:propertyListEntity) {
			propertyListDTO.add(converter.propropertyEntitytoDTOConverter(propertyEntity));
		}
		return propertyListDTO;
	}

	@Override
	public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
		Optional<PropertyEntity> propertyEntityOp = propertyRepository.findById(propertyId);
		if(propertyEntityOp.isPresent()) {
			PropertyEntity propertyEntity = converter.propropertyDTOtoEntityConverter(propertyDTO);
			propertyEntity.setId(propertyId);
			propertyRepository.save(propertyEntity);
			propertyDTO = converter.propropertyEntitytoDTOConverter(propertyEntity);
			propertyDTO.setId(propertyId);
		}
		return propertyDTO;
	}

	@Override
	public PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyId) {
		Optional<PropertyEntity> propertyEntityOp = propertyRepository.findById(propertyId);
		PropertyEntity propertyEntity;
		if(propertyEntityOp.isPresent()) {
			propertyEntity = propertyEntityOp.get();
			propertyEntity.setTitle(propertyDTO.getTitle());
			propertyEntity.setId(propertyId);
			propertyRepository.save(propertyEntity);
			propertyDTO = converter.propropertyEntitytoDTOConverter(propertyEntity);
			propertyDTO.setId(propertyId);
		}
		return propertyDTO;
	}

	@Override
	public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
		Optional<PropertyEntity> propertyEntityOp = propertyRepository.findById(propertyId);
		PropertyEntity propertyEntity;
		if(propertyEntityOp.isPresent()) {
			propertyEntity = propertyEntityOp.get();
			propertyEntity.setDescription(propertyDTO.getDescription());
			propertyEntity.setId(propertyId);
			propertyRepository.save(propertyEntity);
			propertyDTO = converter.propropertyEntitytoDTOConverter(propertyEntity);
			propertyDTO.setId(propertyId);
		}
		return propertyDTO;
	}

	@Override
	public PropertyDTO updatePropertyAddress(PropertyDTO propertyDTO, Long propertyId) {
		Optional<PropertyEntity> propertyEntityOp = propertyRepository.findById(propertyId);
		PropertyEntity propertyEntity;
		if(propertyEntityOp.isPresent()) {
			propertyEntity = propertyEntityOp.get();
			propertyEntity.setAddress(propertyDTO.getAddress());
			propertyEntity.setId(propertyId);
			propertyRepository.save(propertyEntity);
			propertyDTO = converter.propropertyEntitytoDTOConverter(propertyEntity);
			propertyDTO.setId(propertyId);
		}
		return propertyDTO;
	}

	@Override
	public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
		Optional<PropertyEntity> propertyEntityOp = propertyRepository.findById(propertyId);
		PropertyEntity propertyEntity;
		if(propertyEntityOp.isPresent()) {
			propertyEntity = propertyEntityOp.get();
			propertyEntity.setPrice(propertyDTO.getPrice());
			propertyEntity.setId(propertyId);
			propertyRepository.save(propertyEntity);
			propertyDTO = converter.propropertyEntitytoDTOConverter(propertyEntity);
			propertyDTO.setId(propertyId);
		}
		return propertyDTO;
	}

	@Override
	public void deleteProperty(Long propertyId) {
		propertyRepository.deleteById(propertyId);
	}

}
