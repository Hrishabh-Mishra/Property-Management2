package com.hrishabhMishra.PropertyManagement.converter;

import org.springframework.context.annotation.Configuration;

import com.hrishabhMishra.PropertyManagement.DTO.UserDTO;
import com.hrishabhMishra.PropertyManagement.entity.UserEntity;

@Configuration
public class UserObjectConverter {
	
	public UserEntity userDTOtoEntityConverter(UserDTO udto) {
		UserEntity ue = new UserEntity();
		ue.setOwnerName(udto.getOwnerName());
		ue.setEmail(udto.getEmail());
		ue.setPhone(udto.getPhone());
		ue.setPassword(udto.getPassword());
		
		return ue;
	}
	
	public UserDTO userEntitytoDTOConverter(UserEntity ue) {
		UserDTO udto = new UserDTO();
		udto.setId(ue.getUserId());
		udto.setOwnerName(ue.getOwnerName());
		udto.setEmail(ue.getEmail());
		udto.setPhone(ue.getPhone());
		
		return udto;
	}

}
