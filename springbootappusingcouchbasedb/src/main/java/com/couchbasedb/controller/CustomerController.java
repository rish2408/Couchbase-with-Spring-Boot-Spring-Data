package com.couchbasedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.couchbasedb.dao.CustomerRepository;
import com.couchbasedb.entity.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveCustomer(@RequestBody Customer customer)
	{
		customerRepository.save(customer);
		return "Customer Saved Successfully";
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> getAllCustomers()
	{
		return customerRepository.findAll();
		
	}
}
