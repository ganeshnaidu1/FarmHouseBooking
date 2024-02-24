package com.onlinehotelbooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Registered_Properties")
public class Seller 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelId;
	private String location;
	@Column(name = "mobile_no")
	private String mobileNo;
	@Column(name = "no_of_beds")
	private int noOfBeds;
	private double price;
	public int getHotelId() {
		return hotelId;
	}
	public void setHotel_id(int hotel_id) {
		this.hotelId = hotel_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	
 
}
