package com.hrishabhMishra.PropertyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrishabhMishra.PropertyManagement.DTO.UserDTO;
import com.hrishabhMishra.PropertyManagement.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
		userDTO = userService.register(userDTO);
		ResponseEntity<UserDTO> response = new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);
		return response;
	}
	
	
	public UserDTO login(String email, String password) {
		return null;
	}
}
