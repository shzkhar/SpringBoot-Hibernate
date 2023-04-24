package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Employee;
import com.repository.DepartmentRepo;
import com.repository.EmployeeRepo;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	DepartmentRepo deptRepo;
	
	@PostMapping("/addEmployeeData")
	public Employee addEmployeeData(@RequestBody Employee employee)
	{
		deptRepo.save(employee.getDepartment());
		employeeRepo.save(employee);
		return employee;
	}
	
	@GetMapping("/grtEmpAllData")
	public List<Employee> getAllData()
	{
	    return employeeRepo.findAll();
	}
	
	@GetMapping("/getEmpDataById/{id}")
	public Employee getDataById(@PathVariable("id") Integer id)
	{
	   Optional<Employee> opt = employeeRepo.findById(id);
	   
	   if(opt.isEmpty())
	   {
		   return null;
	   }
	   else
	   {
		   return opt.get();
	   }
	}
	
	
	
	@DeleteMapping("/deleteEmpDataById/{id}")
	public Employee deleteDataById(@PathVariable("id") Integer id)
	{
		Employee employee = employeeRepo.findById(id).get();
		employeeRepo.deleteById(id);
    	return employee;
	}
	
	  @PutMapping("/updateEmpData")
	    public Employee updateData(@RequestBody Employee employee)
	    {
		  employeeRepo.save(employee);
	    	return employee;
	    }
}
