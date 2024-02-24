package com.onlinehotelbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinehotelbooking.dto.RegistrationView;
import com.onlinehotelbooking.model.Seller;
import com.onlinehotelbooking.repository.SellerRepository;
@Service
public class SellerServiceImpl implements SellerService  {
	@Autowired
	private SellerRepository sellerRepository; 
	//this is the method to save a record of the seller
	public Seller saveSeller(Seller seller) {       
		return sellerRepository.save(seller);
	}
	public List<Seller> getAllSellers(){
		
		return sellerRepository.findAll();
	}
	public Seller updatePrice(int hotel_id, double newPrice) {
        Optional<Seller> existingSellerOptional = sellerRepository.findById(hotel_id);

        if (existingSellerOptional.isPresent()) {
            Seller seller = existingSellerOptional.get();
            seller.setPrice(newPrice);

            return sellerRepository.save(seller);
        } else {
            return null; 
        }
    }
	public void deleteSellerById(int id) {
		sellerRepository.deleteById(id);
    }
	public List<RegistrationView> searchByLocation(String city) {
    	//System.out.println("in service location");
    	return sellerRepository.getByLocation(city);
    }
	@Override
	public String getSellerMobileNumber(int id) {
		return sellerRepository.getMobileNoByHotelId(id);
	}

}
