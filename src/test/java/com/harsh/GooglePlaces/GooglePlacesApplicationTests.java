package com.harsh.GooglePlaces;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.harsh.GooglePlaces.consumer.ConsumePlace;
import com.harsh.GooglePlaces.model.Place;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GooglePlacesApplicationTests {
	ConsumePlace cp=new ConsumePlace();
	Place pl=new Place("Ranchi","ChIJ3bddqgTh9DkRPvSZaJ3UCdw");
	@Test
	public void contextLoads() {
		assertEquals(cp.consumePlaceID("Ranchi"),pl);
	}

}
