package com.cruds.tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruds.tweet.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer>{

	
}
