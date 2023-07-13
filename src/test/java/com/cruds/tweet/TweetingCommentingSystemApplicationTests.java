package com.cruds.tweet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cruds.tweet.entity.Tweet;
import com.cruds.tweet.entity.User;
import com.cruds.tweet.repository.TweetRepository;
import com.cruds.tweet.repository.UserRepository;
import com.cruds.tweet.service.TweetService;
import com.cruds.tweet.service.UserService;

@SpringBootTest
class TweetingCommentingSystemApplicationTests {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private TweetRepository tweetRepo;

	@Test
	public void testCreate() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "secret";
		String encodedPassword = passwordEncoder.encode(password);
		User user = new User("Subrahmanya", "subrahmanya@gmail.com", encodedPassword);
		Tweet tweets = new Tweet("Hello, This is my first tweet.", LocalDateTime.now(), user);

		Tweet tweet = tweetRepo.save(tweets);
		assertThat(tweet.getId()).isNotNull();
	}
	
	@Test
	public void listAll(){
		List<User> list = userRepo.findAll();
		list.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void listAllTweets() {
		List<Tweet> list = tweetRepo.findAll();
		list.forEach(tweet -> System.out.println(tweet));
	}
	
	@Test
	public void findByUserId() {
		
		User user = userRepo.findById(1).get();
		System.out.println(user);
		assertThat(user.getId()).isNotNull();
		
		Tweet tweet = tweetRepo.findById(1).get();
		System.out.println(tweet);
		assertThat(tweet.getId()).isNotNull();
	}
	
	@Test
	public void testUpdateUser() {
		User user = userRepo.findById(1).get();
		user.setEmail("subbu@gmail.com");
		userRepo.save(user);
	}
	
	@Test
	public void testEditTweet() {
		Tweet tweet = tweetRepo.findById(1).get();
		tweet.setContent("Hello :), just updating my tweet");
		tweetRepo.save(tweet);
	}
	
	@Test
	public void testDeleteTweet() {
		
		Integer id = 1;
		tweetService.deleteTweet(id);
		
		assertFalse(tweetRepo.existsById(id));
	}
	
	@Test
	public void testDeleteUser() {
		
		Integer userId = 1;
		userRepo.deleteById(userId);
		
	}
}
