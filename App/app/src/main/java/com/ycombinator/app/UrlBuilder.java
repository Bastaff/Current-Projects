package com.ycombinator.app;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class UrlBuilder {

	public static void url(String base_url) throws IOException {

		String format = ".json?print=pretty";
		String authkey = base_url + format;

		URL url = new URL(authkey);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	}
	
	public static String response(HttpURLConnection connection) {
		
		
		
		HashMap<String, String> response = new HashMap<String, String>();
		
		try {
		    String url = UrlBuilder.response(connection);;;
		    List<NameValuePair> parameters = url..parse(new URI(url), "UTF-8");
		    for (NameValuePair p : parameters) {
		        response.put(p.getName(), p.getValue());
		    }
		} catch (URISyntaxException e) {
		    e.printStackTrace();
		}

		
		
		System.out.println(response.toString());

		
	}
	
	public static void top() {
		
		String top = "";
	}

}
