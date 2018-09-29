package com.harsh.GooglePlaces.consumer;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.json.JSONObject;
import org.json.JSONArray;

import com.harsh.GooglePlaces.model.Place;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ConsumePlace {

	@Value("${app.key}")
	static String key;
	private static final Logger logger = LoggerFactory.getLogger(ConsumePlace.class);
	
	public Place consumePlaceID(String name) {
		Place place;
		logger.info("Key value is : "+ key);
		String inLine="";
		try {
			
			URL url=new URL("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input="+name+"&inputtype=textquery&key=AIzaSyAtfJTrmBGkUjvhw4NH6ML_VAvgJW0UM60");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			int responsecode = conn.getResponseCode();
			logger.info("Response code is : "+ responsecode);
			
			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode : "+ responsecode);
			else {
				Scanner sc=new Scanner(url.openStream());
				while(sc.hasNext()) {
					inLine+=sc.nextLine();
				}
				System.out.println("\nJSON Response in String format"); 
				System.out.println(inLine);
				sc.close();
			}
			
			JSONObject root = new JSONObject(inLine);
			System.out.println("Root Object is : "+root);
			JSONArray candidates = root.getJSONArray("candidates");
			System.out.println("Candidate Array is: "+candidates);
			JSONObject place_details=candidates.getJSONObject(0);
            System.out.println("place_details Object is : "+place_details);
            String place_id = place_details.getString("place_id");            
            System.out.println("place_id from place_id1 string: "+ place_id);
            place = new Place(name,place_id);
            return place;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
}
