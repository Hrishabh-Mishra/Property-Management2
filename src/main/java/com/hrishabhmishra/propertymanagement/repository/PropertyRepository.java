package com.hrishabhmishra.propertymanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.hrishabhmishra.propertymanagement.entity.PropertyEntity;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long>{

}
