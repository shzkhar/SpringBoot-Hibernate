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

import com.bean.PersonDetails;
import com.repository.AddressRepo;
import com.repository.PersonRepo;

@RestController
public class PersonController {
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	AddressRepo addressRepo;
	
	@PostMapping("/addPersonData")
	public PersonDetails addData(@RequestBody PersonDetails personDetails)
	{
		addressRepo.save(personDetails.getAddress());
		personRepo.save(personDetails);
		return personDetails; 
	}
	
	@GetMapping("/getPersonDataById/{id}")
	public PersonDetails getDataById(@PathVariable("id") Integer id)
	{
		Optional<PersonDetails> opt = personRepo.findById(id);
		
		
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			return opt.get();
		}
	}
	
	    @GetMapping("/getAllPerson")
	    public List<PersonDetails> getAllProduct(){
	    	return personRepo.findAll();
	    } 
	    
	 
	    
	    @DeleteMapping("/deletePersonById/{id}")
	    public PersonDetails deleteProductById(@PathVariable("id") Integer id)
	    {
	    	PersonDetails personDetails = personRepo.findById(id).get();
	    	personRepo.deleteById(id);
	    	return personDetails;
	    } 
	    
	    @PutMapping("/updatePerson")
	    public PersonDetails updateDat(@RequestBody PersonDetails personDetails)
	    {
	    	personRepo.save(personDetails);
	    	return personDetails;
	    }

}
