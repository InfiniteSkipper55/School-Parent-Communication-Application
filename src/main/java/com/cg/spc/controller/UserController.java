package com.cg.spc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spc.entities.User;
import com.cg.spc.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping("/addnewuser")
	public User addNewUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}
	
	@PostMapping("/signin")
	public User signIn(@RequestBody User user) {
		return userService.signIn(user);
	}
	
	@PostMapping("/signout")
	public User signOut(@RequestBody User user) {
		return userService.signOut(user);
	}

}
