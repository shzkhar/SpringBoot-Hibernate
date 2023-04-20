package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bean.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {

	List<Department> findAll();
}
