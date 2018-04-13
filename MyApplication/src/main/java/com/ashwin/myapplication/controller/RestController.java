package com.ashwin.myapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwin.myapplication.model.User;
import com.ashwin.myapplication.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String hello() {
		return "this is home page";
	}
	
	
	@GetMapping("/saveuser")
	public String saveUser(@RequestParam String userName,
			@RequestParam String firstName,@RequestParam String lastName,
			@RequestParam int age,@RequestParam String password) {
		User user=new User(firstName, lastName, age, password,userName);
		userService.saveMyUser(user);
		return "saved";
	}
}
