package com.ycombinator.app;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;
public class UrlBuilder {

	public static void url(String base_url) throws IOException {

		String format = ".json?print=pretty";
		String authkey = base_url + format;

		URL url = new URL(authkey);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	}
	
	public static void response(HttpURLConnection connection) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine = null;
		StringBuffer response = new StringBuffer();

		
		response.append(inputLine);


		
		
		System.out.println(response.toString());

		
	}
	
	public static void top() {
		
		String top = "";
	}

}
