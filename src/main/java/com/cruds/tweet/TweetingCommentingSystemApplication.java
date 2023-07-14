package com.cruds.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cruds.tweet")
public class TweetingCommentingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetingCommentingSystemApplication.class, args);
	}

}
