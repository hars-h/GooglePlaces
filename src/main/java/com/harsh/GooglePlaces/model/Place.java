package com.harsh.GooglePlaces.model;

public class Place {
	public Place(String placeName, String placeID) {
		super();
		this.placeName = placeName;
		this.placeID = placeID;
	}
	private String placeName;
	private String placeID;
	/**
	 * @return the placeName
	 */
	public String getPlaceName() {
		return placeName;
	}
	/**
	 * @param placeName the placeName to set
	 */
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	/**
	 * @return the placeID
	 */
	public String getPlaceID() {
		return placeID;
	}
	/**
	 * @param placeID the placeID to set
	 */
	public void setPlaceID(String placeID) {
		this.placeID = placeID;
	}
	
}
