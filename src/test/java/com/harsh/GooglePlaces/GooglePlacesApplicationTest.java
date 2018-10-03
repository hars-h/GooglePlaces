package com.harsh.GooglePlaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.harsh.GooglePlaces.consumer.ConsumePlace;
import com.harsh.GooglePlaces.model.Place;

public class GooglePlacesApplicationTest {
	ConsumePlace cp=new ConsumePlace();
	Place place = new Place("Ranchi","ChIJ3bddqgTh9DkRPvSZaJ3UCdw");
	Place brplace;
	@Test
	public void TestPlaceID() {
		brplace = cp.consumePlaceID("Ranchi");
		System.out.println("Place : "+place);
		System.out.println("brPlace : "+brplace);
		assertEquals(place.toString(),brplace.toString());
	}

}
