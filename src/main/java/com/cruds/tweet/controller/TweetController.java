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

import com.cruds.tweet.entity.Tweet;
import com.cruds.tweet.service.TweetService;

@RestController
public class TweetController {
	
	@Autowired
	private TweetService service;
	
	@GetMapping("/tweets")
	public List<Tweet> getAll(){
		return service.listAll();
	}

	@PostMapping("/tweets")
	public Tweet saveTweets(@RequestBody Tweet tweet) {
		return service.saveTweet(tweet);
	}
	
	@GetMapping("/tweets/{id}")
	public Tweet getTweets(@PathVariable Integer id) {
		return service.getTweet(id);
	}

	@DeleteMapping("/tweets/{id}")
	public void deleteTweets(@PathVariable Integer id) {
		service.deleteTweet(id);
	}

	@PutMapping("/tweets/{id}/content")
	public Tweet updateTweetContent(@PathVariable Integer id, @RequestParam String content) {
		return service.updateTweet(id, content);
	}

}
