package com.correlate.twitter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.*;

import twitter4j.FilterQuery;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserList;
@SpringBootApplication
public class CorrelateApplication {

	public static void main(String[] args)
			throws IOException, TwitterException {
		SpringApplication.run(CorrelateApplication.class, args);
		

		
		Twitter twitter = TwitterFactory.getSingleton();
		Query query = new Query("Artificial Intelligence");
		query.setCount(10);
		QueryResult result = twitter.search(query);
		
		String keyword = "ai";	
		UserList list = twitter.createUserList(keyword, true, "Auto-Generated");
		
		for (Status status : result.getTweets()) {
			
			if (status.getUser().getDescription().toLowerCase().contains("ai ")) {

				twitter.createUserListMember(listId, userId)
				System.out.printf("@%s:\n%s\n",status.getUser().getScreenName(),status.getUser().getDescription());
				System.out.println("===========================================================================");
			}
			

		}
		// UserList list = twitter.createUserList("test2", true, "test2");
		// System.out.println("Successfully created a list (id:" + list.getId()
		// + ", slug:" + list.getSlug() + ").");

		Gson gson = new Gson();

	}
	
}
