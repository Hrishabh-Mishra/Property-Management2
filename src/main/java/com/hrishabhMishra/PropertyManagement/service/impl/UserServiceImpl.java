package com.hrishabhMishra.PropertyManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrishabhMishra.PropertyManagement.DTO.UserDTO;
import com.hrishabhMishra.PropertyManagement.converter.UserObjectConverter;
import com.hrishabhMishra.PropertyManagement.entity.UserEntity;
import com.hrishabhMishra.PropertyManagement.repository.UserRepository;
import com.hrishabhMishra.PropertyManagement.service.UserService;

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
