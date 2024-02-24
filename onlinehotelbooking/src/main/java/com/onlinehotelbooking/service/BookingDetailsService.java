package com.onlinehotelbooking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinehotelbooking.dto.Feedback;
import com.onlinehotelbooking.model.BookingDetails;
import com.onlinehotelbooking.model.User;
import com.onlinehotelbooking.repository.BookingDetailsRepository;

@Service
public class BookingDetailsService {
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	public void saveBooking(String email,LocalDate checkIn,LocalDate checkOut,int noOfPeople,int hotelId) {
		bookingDetailsRepository.save(new BookingDetails(email,hotelId,checkIn,checkOut,noOfPeople));
	}
	public List<Feedback> searchByEmailId(String emailId){
		return bookingDetailsRepository.findByEmail(emailId);
	}
}