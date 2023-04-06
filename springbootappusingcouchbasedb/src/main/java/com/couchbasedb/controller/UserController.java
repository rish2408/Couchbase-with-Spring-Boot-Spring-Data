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

import com.couchbasedb.dao.UserRepository;
import com.couchbasedb.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveUser(@RequestBody User user)
	{
		userRepository.save(user);
		return "User Saved Successfully";
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
		
	}
	
	
}
