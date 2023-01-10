package com.hrishabhmishra.propertymanagement.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hrishabhmishra.propertymanagement.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	//Following method name is standard format to help JPA create a custom Query for us.
	Optional<UserEntity> findByEmailAndPassword (String email, String password);

}
