package com.cruds.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cruds.tweet.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.email = :email")
	public User getUserByEmail(@Param("email") String email);
	
	public List<User> findByUsername(String username);
	
	public List<User> searchUserByUsernameAndEmail(String username, String email);

}
