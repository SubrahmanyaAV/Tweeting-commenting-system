package com.cruds.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruds.tweet.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
