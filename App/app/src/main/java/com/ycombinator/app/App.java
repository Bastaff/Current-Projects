package com.ycombinator.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException  {

		String base_url = " https://hacker-news.firebaseio.com/v0/topstories";
		//[ 9129911, 9129199, 9127761, 9128141, 9128264, 9127792, 9129248, 9127092, 9128367, ..., 9038733 ]

		UrlBuilder.url(base_url);

			
		
	}
}
