package com.onlinehotelbooking.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinehotelbooking.model.Seller;
import com.onlinehotelbooking.service.SellerService;
import com.onlinehotelbooking.service.TwilioService;
import com.onlinehotelbooking.service.UserService;
@Controller
@RequestMapping("/host")
public class HostController {

	@Autowired
	private SellerService sellerService;
	@Autowired
    private TwilioService twilioSmsService;
	private int hotelIdToBeUpdated;
	private String generatedOtp;
	private int newUpdatingPrice;
	
	@GetMapping("/")
    public String getRegistration() {
		return "SellerRegistration.html";
	}
	@GetMapping("/register")
    public String HostRegistration() {
		return "RegisteringProperty.html";
	}
	@PostMapping("/create")
	public String createSeller(@ModelAttribute Seller seller,ModelMap model) {
		model.addAttribute("SuccessMessages","Congratulations you have succesfully registered your property,Cheers to your passive income");
	    Seller sellerr = sellerService.saveSeller(seller);
	    return "RegisteringProperty.html";
	}
	@GetMapping("/updateSeller")
    public String  updateSellerPrice(@RequestParam int hotelId,@RequestParam int newPrice) {
    	 	String otp = generateOtp();
    	 	this.hotelIdToBeUpdated=hotelId;
    	 	this.generatedOtp=otp;
    	 	this.newUpdatingPrice=newPrice;
            String mobileNumber = sellerService.getSellerMobileNumber(hotelId);
            twilioSmsService.sendSms(mobileNumber, "Your OTP for price update: " + otp);
            return "SellerRegistration.html";

        }        
        private String generateOtp() {

            Random random = new Random();

            int otp = 1000 + random.nextInt(9000);

            return String.valueOf(otp);

        }

        @GetMapping("/verifyOtp")
        public String verifyOtp(@RequestParam String otp,ModelMap model) {
            if (otp.equals(generatedOtp)) {
            	sellerService.updatePrice(this.hotelIdToBeUpdated, this.newUpdatingPrice);
            	model.addAttribute("SuccessMessages","Your price change is succesful!!");

            } else {
            		model.addAttribute("SuccessMessages","please check your OTP and retry");

            }
            return "SellerRegistration.html";

        }
}
