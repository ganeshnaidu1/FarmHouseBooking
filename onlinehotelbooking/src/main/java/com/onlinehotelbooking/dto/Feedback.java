package com.onlinehotelbooking.dto;

import java.time.LocalDate;

public class Feedback {
	private int hotelId;
	private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfPeople;
   	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public Feedback() {
		super();
	}

	public Feedback(int hotelId, LocalDate checkInDate, LocalDate checkOutDate, int numberOfPeople) {
		super();
		this.hotelId = hotelId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfPeople = numberOfPeople;
	}
}
