package com.cruds.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cruds.tweet.entity.User;
import com.cruds.tweet.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> listAll(){
		return userService.listAll();
	}
	
	@PostMapping("/users")
	public User saveUsers(@RequestBody User user) {
		return userService.createUser(user);
	}

}
