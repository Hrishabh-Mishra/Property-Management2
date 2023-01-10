package com.hrishabhmishra.propertymanagement.service;

import com.hrishabhmishra.propertymanagement.dto.UserDTO;

public interface UserService {
	
	UserDTO register(UserDTO userDTO);
	UserDTO login(String email, String password);

}
