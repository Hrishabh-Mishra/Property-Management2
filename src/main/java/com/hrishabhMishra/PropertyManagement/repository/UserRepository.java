package com.hrishabhMishra.PropertyManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.hrishabhMishra.PropertyManagement.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
