package com.onlinehotelbooking.service;

import java.util.List;

import com.onlinehotelbooking.dto.RegistrationView;
import com.onlinehotelbooking.model.Seller;

public interface SellerService {
	Seller saveSeller(Seller seller);
	List<Seller> getAllSellers();
	Seller updatePrice(int hotel_id, double price);
	void deleteSellerById(int id);
	List<RegistrationView> searchByLocation(String city);
	String getSellerMobileNumber(int id);

}
