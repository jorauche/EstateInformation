package com.estate.information.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estate.information.entity.Estate;

@Repository
public interface EstateRepository extends CrudRepository<Estate, String>{
	
	
}
