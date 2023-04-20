package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.PersonDetails;
@Repository
public interface PersonRepo extends CrudRepository<PersonDetails, Integer> {
	List<PersonDetails> findAll();
	
	
}
