package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bean.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	List<Employee> findAll();
}
