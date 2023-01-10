package com.hrishabhmishra.propertymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrishabhmishra.propertymanagement.dto.UserDTO;
import com.hrishabhmishra.propertymanagement.converter.UserObjectConverter;
import com.hrishabhmishra.propertymanagement.entity.UserEntity;
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
		UserEntity userEntity = converter.userDTOtoEntityConverter(userDTO);
		userEntity = userRepository.save(userEntity);
		userDTO = converter.userEntitytoDTOConverter(userEntity);
		return userDTO;
	}

	@Override
	public UserDTO login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
