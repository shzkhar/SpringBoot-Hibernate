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

import com.bean.Address;
import com.repository.AddressRepo;

@RestController
public class AddressController {

	@Autowired
	AddressRepo addressrepo;
	
	@PostMapping("/addAddressData")
	public Address addData(@RequestBody Address address)
	{
		addressrepo.save(address);
		return address; 
	}
	
	@GetMapping("/getAddressDataById/{id}")
	public Address getDataById(@PathVariable("id") Integer id)
	{
		Optional<Address> opt = addressrepo.findById(id);
		
		
		if(opt.isEmpty())
		{
			return null;
		}
		else
		{
			return opt.get();
		}
	}
	
	    @GetMapping("/getAllAddress")
	    public List<Address> getAllProduct(){
	    	return addressrepo.findAll();
	    } 
	    
	 
	    
	    @DeleteMapping("/deleteAddressById/{id}")
	    public Address deleteProductById(@PathVariable("id") Integer id)
	    {
	    	Address address = addressrepo.findById(id).get();
	    	addressrepo.deleteById(id);
	    	return address;
	    } 
	    
	    @PutMapping("/updateAddress")
	    public Address updateData(@RequestBody Address address)
	    {
	    	addressrepo.save(address);
	    	return address;
	    }

}
