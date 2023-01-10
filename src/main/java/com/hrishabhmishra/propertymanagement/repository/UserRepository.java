package com.hrishabhmishra.propertymanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.hrishabhmishra.propertymanagement.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
