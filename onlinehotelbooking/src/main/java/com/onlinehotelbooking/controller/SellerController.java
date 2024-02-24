package com.onlinehotelbooking.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mysql.cj.Session;
import com.onlinehotelbooking.dto.Feedback;
import com.onlinehotelbooking.dto.RegistrationView;
import com.onlinehotelbooking.model.Seller;
import com.onlinehotelbooking.model.User;
import com.onlinehotelbooking.repository.UserRepository;
import com.onlinehotelbooking.service.BookingDetailsService;
import com.onlinehotelbooking.service.SellerService;
import com.onlinehotelbooking.service.TwilioService;
import com.onlinehotelbooking.service.UserService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sellerapi")
public class SellerController {

    @Autowired
    private TwilioService twilioSmsService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserService userService;
	@Autowired
    private UserRepository userRepository;
	@Autowired
	private BookingDetailsService bookingDetailsService;
//	@Autowired
//	private HostController hostController;
	
	//static String emailIdbooking;
	static String generatedOtp;
	static int newUpdatingPrice;
	static int hotelIdToBeUpdated;
	static int hotelIdToBook;
//	@GetMapping("/")
//	public String RegisteringProperty() {
//		return "Main.html";
//	}
	@GetMapping("/RegisterProperty")
    public String register() {
        return "RegisteringProperty";
    }
//	@GetMapping("/SellerRegistration")
//	public String registerProperty() {
//		return "SellerRegistration.html";
//	}
	@PostMapping("/create")
	public ResponseEntity<String> createSeller(@ModelAttribute Seller seller) {
	    Seller sellerr = sellerService.saveSeller(seller);
	    return new ResponseEntity<>("Congratulations you have registered successfully! cheers to your passive income.", HttpStatus.CREATED);
	}
	@GetMapping("/all")
	public ResponseEntity<List<Seller>> getAllSellers() {
        List<Seller> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }
	@DeleteMapping("/deleteSeller/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable int id) {
        sellerService.deleteSellerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	    @GetMapping("/search")
	    public String searchByLocation(@RequestParam String city, ModelMap model) {
	        List<RegistrationView> sellers = sellerService.searchByLocation(city);
	        model.addAttribute("sellers", sellers);
	        return "search.html";
	    }
	    @GetMapping("/submit")
	    public String bookHotel(@RequestParam int hotelId, ModelMap model) {
	        model.addAttribute("hotelId", hotelId);
	        return "booking"; // Assuming "checkInModal" is the name of your view
	    }
	    @PostMapping("/feedback")
	    public String getFeedback(ModelMap model,HttpSession session) {
	    	User useee=(User) session.getAttribute("user");
	    	List<Feedback> feedback = bookingDetailsService.searchByEmailId(useee.getEmailId());
	        model.addAttribute("feedback", feedback);
	        return "BookingHistory.html";
	    }

	    
@GetMapping("sellerapi/sellerapi/booking")
public String bookHotel(
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
                         @RequestParam int noOfPeople,ModelMap model,HttpSession session) {
	User use=(User) session.getAttribute("user");

	bookingDetailsService.saveBooking(use.getEmailId(), checkIn, checkOut, noOfPeople, hotelIdToBook);
	model.addAttribute("SuccessMessage","Your booking is Succesful please logout!!");
	return "booking.html";

}
@PostMapping("sellerapi/book")
public String book(@RequestParam int hotelId) {
	//System.out.println(hotelId);
	this.hotelIdToBook=hotelId;
	return "booking.html";
    }
}
	    


