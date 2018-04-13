package com.ashwin.myapplication.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Optional;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashwin.myapplication.model.User;
import com.ashwin.myapplication.service.UserService;

@Controller
public class ApplicationController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcome";
	}
	
	@RequestMapping("/register")
	public String registeration(HttpServletRequest request) {
		request.setAttribute("mode","MODE_REGISTER");
		return "welcome";
				
	}
	
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute User user,
			BindingResult bindingResult,HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode","MODE_HOME");
		return "home";
	}
	
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "home";
				
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id,HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users",userService.showAllUsers());
		request.setAttribute("mode","ALL_USERS");
		return "home";
				
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		
		request.setAttribute("user",userService.editMyUser(id).get());
		request.setAttribute("mode","MODE_UPDATE");
		return "home";
				
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode","MODE_LOGIN");
		return "welcome";
	}
	
	@RequestMapping("/login-user")
	public String loginUser(@ModelAttribute User user,HttpServletRequest request) {
		if(userService.findByUsernameandPassword(user.getUsername(),user.getPassword())!=null) {
			request.setAttribute("mode","MODE_HOME");
			return "home";
		}
		else {
			request.setAttribute("error","INvalid username and password");
			request.setAttribute("mode","MODE_LOGIN");
			return "welcome";
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.setAttribute("mode","MODE_HOME");
		return "welcome";
	}
	
}
