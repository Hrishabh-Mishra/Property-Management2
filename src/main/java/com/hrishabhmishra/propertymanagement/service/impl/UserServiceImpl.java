package com.hrishabhmishra.propertymanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrishabhmishra.propertymanagement.dto.UserDTO;
import com.hrishabhmishra.propertymanagement.converter.UserObjectConverter;
import com.hrishabhmishra.propertymanagement.entity.UserEntity;
import com.hrishabhmishra.propertymanagement.exception.BusinessException;
import com.hrishabhmishra.propertymanagement.exception.ErrorModel;
import com.hrishabhmishra.propertymanagement.repository.UserRepository;
import com.hrishabhmishra.propertymanagement.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserObjectConverter converter;
	
	@Override
	public UserDTO register(UserDTO userDTO) {
		Optional<UserEntity> userEntityOp = userRepository.findByEmail(userDTO.getEmail());
		if(userEntityOp.isPresent()) {
			ErrorModel em = new ErrorModel();
			em.setErrCode("REGISTERED_TRUE");
			em.setErrMsg("User already registered with this email. Please login.");
			List<ErrorModel> errList = List.of(em);
			
			throw new BusinessException(errList);
		}
		UserEntity userEntity = converter.userDTOtoEntityConverter(userDTO);
		userEntity = userRepository.save(userEntity);
		userDTO = converter.userEntitytoDTOConverter(userEntity);
		return userDTO;
	}

	@Override
	public UserDTO login(String email, String password) {
		Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email, password);
		if(userEntity.isPresent()) {
			return converter.userEntitytoDTOConverter(userEntity.get());
		}
		ErrorModel em = new ErrorModel();
		em.setErrCode("INVALID_LOGIN");
		em.setErrMsg("Incorrect Email or Password.");
		List<ErrorModel> errList = List.of(em);
		
		throw new BusinessException(errList);
	}

}
