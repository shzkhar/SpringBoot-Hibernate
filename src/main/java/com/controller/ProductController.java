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

import com.bean.ProductBean;
import com.repository.ProductRepository;



@RestController
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	
    @PostMapping("/addProduct")
	public ProductBean addProduct(@RequestBody ProductBean productBean)
	{
    	productRepository.save(productBean); // save method is uste to insert the data into table
		return productBean;
	}
    
    @GetMapping("/getProductById/{productid}")
    public ProductBean getProductById(@PathVariable("productid") Integer productid){
    	
    	Optional<ProductBean> proOptional = productRepository.findById(productid);
    	
    	if(proOptional.isEmpty())
    	{
    		return null;
    	}
    	else
    	{
    		return proOptional.get();
    	}
    }
    
    @GetMapping("/getAllProduct")
    public List<ProductBean> getAllProduct(){
    	return productRepository.findAll();
    } 
    
    @GetMapping("/getProductByName/{name}")
    public List<ProductBean> getProductByName(@PathVariable("name") String name){
    	return productRepository.findByName(name);  
    	   
    }
    
    @DeleteMapping("/deleteProductById/{productid}")
    public ProductBean deleteProductById(@PathVariable("productid") Integer productid)
    {
    	ProductBean productBean = productRepository.findById(productid).get();
    	productRepository.deleteById(productid);
    	return productBean;
    } 
    
    @PutMapping("/updateProduct")
    public ProductBean updateDat(@RequestBody ProductBean productBean)
    {
    	productRepository.save(productBean);
    	return productBean;
    }
}
