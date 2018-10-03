package com.harsh.GooglePlaces;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.harsh.GooglePlaces.consumer.ConsumePlace;
import com.harsh.GooglePlaces.model.Place;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GooglePlacesApplicationTest {
	ConsumePlace cp;
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
