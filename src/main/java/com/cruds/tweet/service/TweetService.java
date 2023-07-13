package com.cruds.tweet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.tweet.entity.Tweet;
import com.cruds.tweet.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepo;
	
	public Tweet createUser(Tweet tweet) {
		return tweetRepo.save(tweet);
	}

	public Tweet getTweet(Integer tweetId) {
        return tweetRepo.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("Tweet not found"));
    }
	
	public void deleteTweet(Integer tweetId) {
		Tweet tweet = tweetRepo.findById(tweetId)
                .orElseThrow(() -> new IllegalArgumentException("Tweet not found"));
		//to just delete tweet and not the user
        tweet.setUser(null); // Dissociate tweet from the user
        tweetRepo.save(tweet); // Save the updated tweet without the user
        tweetRepo.deleteById(tweetId); // Delete the tweet
    }
}
