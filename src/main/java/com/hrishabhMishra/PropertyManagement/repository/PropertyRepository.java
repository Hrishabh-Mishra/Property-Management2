package com.hrishabhMishra.PropertyManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.hrishabhMishra.PropertyManagement.entity.PropertyEntity;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long>{

}
