package com.hrishabhMishra.PropertyManagement.service;

import com.hrishabhMishra.PropertyManagement.DTO.UserDTO;

public interface UserService {
	
	UserDTO register(UserDTO userDTO);
	UserDTO login(String email, String password);

}
