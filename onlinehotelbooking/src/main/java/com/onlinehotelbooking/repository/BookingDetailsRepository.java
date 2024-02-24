package com.onlinehotelbooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinehotelbooking.dto.Feedback;
import com.onlinehotelbooking.model.BookingDetails;
@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails,Integer> {
	@Query("SELECT new com.onlinehotelbooking.dto.Feedback(s.hotelId,s.checkInDate, s.checkOutDate,s.numberOfPeople) FROM BookingDetails s where s.email = :emailId")
	List<Feedback> findByEmail(String emailId);
	

}
