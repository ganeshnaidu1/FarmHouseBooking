package com.onlinehotelbooking.dto;

public class RegistrationView {
	private String location;
	private int noOfBeds;
	private double price;
	private int hotelId;
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public RegistrationView(String location, int noOfBeds, double price, int hotelId) {
		super();
		this.location = location;
		this.noOfBeds = noOfBeds;
		this.price = price;
		this.hotelId = hotelId;
	}
	
}
