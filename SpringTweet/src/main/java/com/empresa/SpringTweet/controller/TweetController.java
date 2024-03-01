package com.empresa.SpringTweet.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.SpringTweet.model.Tweet;
import com.empresa.SpringTweet.repository.TweetRepository;

@RestController
@RequestMapping("/api/tweets")
// Ambiente desenvolvido no Visual Code incluir linha abaixo
//@CrossOrigin(origins = "http://127.0.0.1:5500") 
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping
    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tweet getTweetById(@PathVariable Integer id) {
        return tweetRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Tweet createTweet(@RequestBody Tweet tweet) {
    	tweet.setPostTime(new Date());
        return tweetRepository.save(tweet);
    }

    @PutMapping("/{id}")
    public Tweet updateTweet(@PathVariable Integer id, @RequestBody Tweet updatedTweet) {
        Tweet existingTweet = tweetRepository.findById(id).orElse(null);

        if (existingTweet != null) {
            // Remova a linha que define postTime para a hora atual
            existingTweet.setContent(updatedTweet.getContent());
            existingTweet.setTweetUser(updatedTweet.getTweetUser());
            // Mantenha a hora original do tweet
            return tweetRepository.save(existingTweet);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTweet(@PathVariable Integer id) {
        tweetRepository.deleteById(id);
    }
}
