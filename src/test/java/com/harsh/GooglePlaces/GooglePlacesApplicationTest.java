package com.harsh.GooglePlaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.harsh.GooglePlaces.consumer.ConsumePlace;
import com.harsh.GooglePlaces.model.Place;

public class GooglePlacesApplicationTest {
	ConsumePlace cp=new ConsumePlace();
	Place place = new Place("Ranchi","ChIJ3bddqgTh9DkRPvSZaJ3UCdw");
	Place cplace;
	@Test
	public void TestPlaceID() {
		cplace = cp.consumePlaceID("Ranchi");
		System.out.println("Place : "+place);
		System.out.println("cPlace : "+cplace);
		assertEquals(place.toString(),cplace.toString());
	}

}
