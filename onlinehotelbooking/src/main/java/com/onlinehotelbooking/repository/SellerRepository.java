package com.onlinehotelbooking.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinehotelbooking.dto.RegistrationView;
import com.onlinehotelbooking.model.Seller;
@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer>
{
	@Query("SELECT new com.onlinehotelbooking.dto.RegistrationView(s.location, s.noOfBeds, ROUND(1.3 * s.price, -2), s.hotelId) FROM Seller s WHERE LOWER(s.location) LIKE %:city%")
    List<RegistrationView> getByLocation(@Param("city") String city);
	@Query("SELECT s.mobileNo FROM Seller s WHERE s.hotelId = :id")
	String getMobileNoByHotelId(@Param("id") int id);
}
            
