package com.onlinehotelbooking.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String email;
	private int hotelId;
   	private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfPeople;

    // Constructors, getters, and setters (if needed)

    // Example constructor
    // Getters and setters (you can generate these using your IDE or manually)
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
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
    public BookingDetails(String email, int hotelId, LocalDate checkInDate, LocalDate checkOutDate,
			int numberOfPeople) {
		super();
		this.email = email;
		this.hotelId = hotelId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfPeople = numberOfPeople;
	}

	public BookingDetails() {
		super();
	}
}

