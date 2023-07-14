package com.cruds.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserId(id);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

	@PutMapping("/users/{id}/email")
	public User updateEmail(@PathVariable Integer id, @RequestParam String email) {
		return userService.updateEmail(id, email);
	}
	
	@GetMapping("/users/email/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/users/search")
	public List<User> searchEmployee(@RequestParam("username") String username,
										 @RequestParam("email") String email)
	{
		return userService.searchUser(username, email);
	}


}
