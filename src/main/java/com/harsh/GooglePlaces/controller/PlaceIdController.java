package com.harsh.GooglePlaces.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harsh.GooglePlaces.consumer.ConsumePlace;
import com.harsh.GooglePlaces.model.Place;



@RestController
public class PlaceIdController {
	private static Map<String, Place> placeID = new HashMap<>();
	Place newPlace;
	ConsumePlace cp=new ConsumePlace();
	//Handle Request from EndUser via browser to search placeID for a place
	@RequestMapping(value="/place/{name}", method=RequestMethod.GET)
	public ResponseEntity<Object> getPlaceId(@PathVariable("name") String name){
		//If placeID is in memory
		if(placeID.containsKey(name))
		{
			System.out.println("Returning from In Memory");
		}
		//If placeID not in memory, fetch it from google places API using consumePlaceID method
		else {
		System.out.println("Returning after fetching from API");
		newPlace = cp.consumePlaceID(name);
		placeID.put(name, newPlace);
		}
		return new ResponseEntity<>(placeID.get(name), HttpStatus.OK);			
	}
	   
}
