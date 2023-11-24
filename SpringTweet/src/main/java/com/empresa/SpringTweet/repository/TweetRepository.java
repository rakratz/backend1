package com.empresa.SpringTweet.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.SpringTweet.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer> {
}
