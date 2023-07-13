package com.cruds.tweet.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String content;

	@Column
	private LocalDateTime timestamp;

	@ManyToOne(cascade=CascadeType.ALL/*, fetch = FetchType.EAGER*/)
	@JoinColumn(name = "user_id")
	private User user;

	public Tweet() {
		super();
	}

	public Tweet(String content, LocalDateTime timestamp) {
		super();
		this.content = content;
		this.timestamp = timestamp;
	}

	public Tweet(String content, LocalDateTime timestamp, User user) {
		super();
		this.content = content;
		this.timestamp = timestamp;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", content=" + content + ", timestamp=" + timestamp + ", user=" + user + "]";
	}

}
