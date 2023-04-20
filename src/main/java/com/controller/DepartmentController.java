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

import com.bean.Department;
import com.bean.ProductBean;
import com.repository.DepartmentRepo;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepo departmentRepo;
	
	@PostMapping("/addDeptData")
	public Department addDeptData(@RequestBody Department department)
	{
		departmentRepo.save(department);
		return department;
	}
	
	@GetMapping("/getDeptById/{deptid}")
	public Department getDataById(@PathVariable("deptid") Integer deptid)
	{
	   Optional<Department> opt = departmentRepo.findById(deptid);
	   
	   if(opt.isEmpty())
	   {
		   return null;
	   }
	   else
	   {
		   return opt.get();
	   }
	}
	
	@GetMapping("/grtAllData")
	public List<Department> getAllData()
	{
		return departmentRepo.findAll();
	}
	
	@DeleteMapping("/deleteDataById/{deptid}")
	public Department deleteDataById(@PathVariable("deptid") Integer deptid)
	{
		Department department = departmentRepo.findById(deptid).get();
		departmentRepo.deleteById(deptid);
    	return department;
	}
	
	  @PutMapping("/updateData")
	    public Department updateData(@RequestBody Department department)
	    {
		  departmentRepo.save(department);
	    	return department;
	    }
}
