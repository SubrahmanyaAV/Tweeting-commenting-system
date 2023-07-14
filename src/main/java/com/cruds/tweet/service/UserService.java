package com.cruds.tweet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.tweet.entity.User;
import com.cruds.tweet.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public List<User> listAll() {
		return userRepo.findAll();
	}

	public User getUserId(Integer id) {
		return userRepo.findById(id).get();
	}

	public User updateEmail(Integer id, String email) {
		User user = userRepo.findById(id).orElse(null);
		if (user != null) {
			user.setEmail(email);
			return userRepo.save(user);
		}
		return null;
	}

	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}

	public User getUserByEmail(String email) {
		return userRepo.getUserByEmail(email);
	}

	public List<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	public List<User> searchUser(String username, String email) {
		if (username != null && email != null) {
			return userRepo.searchUserByUsernameAndEmail(username, email);
		} else if (username != null) {
			return userRepo.findByUsername(username);
		} else {
			return userRepo.findAll();
		}

	}
}
