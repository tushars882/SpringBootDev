package com.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.User;
import com.springsecurity.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping("")
public class UserController {
	
	
	@Autowired
	private UserService service;
	

//	@GetMapping("/")
//	public String getSessionId(HttpServletRequest request) {
//		return "Session id is : "+ request.getSession().getId();
//	}
	
	@GetMapping("/getUser")
	public List<User> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{username}")
	public User getByName(@PathVariable String username) {
		
		return this.service.getByName(username);
		
	}
	
	
	@PostMapping("/add")
	public void addUser(@RequestBody User user) {
		this.service.addUser(user);
	}
	
	
	@DeleteMapping("/{username}")
	public void deleteByName(@PathVariable String username) {
		this.service.deleteUser(username);
	}
}
