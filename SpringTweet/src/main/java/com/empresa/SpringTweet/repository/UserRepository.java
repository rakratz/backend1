package com.empresa.SpringTweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.SpringTweet.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	 User findByScreenName(String screenName);
}
