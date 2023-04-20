package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.Address;
@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
	List<Address> findAll();
}
