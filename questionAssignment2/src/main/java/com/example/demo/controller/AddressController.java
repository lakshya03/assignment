package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;

@RestController
public class AddressController {

	@Autowired
	List<Address> addressList;
	
	@GetMapping("/address")
	public List<Address> getProduct()
	{
		return addressList;
	}

	private Address filterProductById(long pid)
	{
		return	this.addressList.stream().filter(eachProduct->eachProduct.getPassCode()==pid).findFirst().orElse(null);
	}
	@GetMapping("/address/{passCode}")
	public Address findProductById(@PathVariable("passCode")Long passCode)
	{
	return filterProductById(passCode);
	
	}
	@PostMapping(value="/address",consumes="application/json",produces="application/json")
	public Address addProduct(@RequestBody Address address)
	{
		this.addressList.add(address);
		return address;
		
	}
	
	
}
