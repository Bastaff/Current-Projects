package com.correlate.twitter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserList;
@SpringBootApplication
public class CorrelateApplication {

	public static void main(String[] args) throws IOException, TwitterException {
		SpringApplication.run(CorrelateApplication.class, args);
		
		   Twitter twitter = TwitterFactory.getSingleton();
		    Query query = new Query("(CEO) -buy -sell -entrepreneur -gold min_retweets:300 -filter:replies");
		    QueryResult result = twitter.search(query);
		    for (Status status : result.getTweets()) {
		        System.out.println("@" + status.getUser().getScreenName() + ":");
		    }
		    UserList list = twitter.createUserList("test2", true, "test2");
            System.out.println("Successfully created a list (id:" + list.getId() + ", slug:" + list.getSlug() + ").");
	    }
		
		}

