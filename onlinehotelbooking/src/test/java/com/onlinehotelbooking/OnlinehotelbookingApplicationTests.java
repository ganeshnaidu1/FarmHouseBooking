package com.onlinehotelbooking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlinehotelbooking.model.Seller;
import com.onlinehotelbooking.model.User;
import com.onlinehotelbooking.repository.SellerRepository;
import com.onlinehotelbooking.repository.UserRepository;
import com.onlinehotelbooking.service.SellerServiceImpl;
import com.onlinehotelbooking.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlinehotelbookingApplicationTests {

    @Autowired
    private SellerServiceImpl sellerService;

    @MockBean
    private SellerRepository sellerRepository; 
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveSeller() {
        // Set up test data
        Seller seller = new Seller();
        seller.setLocation("Test Location");
        seller.setMobileNo("1234567890");
        seller.setNoOfBeds(1);
        seller.setPrice(100.0);

        // Configure the mock repository to return the saved seller
        when(sellerRepository.save(seller)).thenReturn(seller);

        // Call the method being tested
        Seller result = sellerService.saveSeller(seller);

        // Assert that the saved seller is returned
        assertEquals(seller, result);
    }

    @Test
    public void testGetAllSellers() {
        // Set up test data
        List<Seller> sellers = new ArrayList<>();
        Seller s1=new Seller();
        s1.setLocation("Hitech city");
        s1.setMobileNo("986661412");
        s1.setNoOfBeds(3);
        s1.setPrice(2900.09);
        sellers.add(s1);

        // Configure the mock repository to return the list of sellers
        when(sellerRepository.findAll()).thenReturn(sellers);

        // Call the method being tested
        List<Seller> result = sellerService.getAllSellers();

        // Assert that the list of sellers is returned
        assertEquals(sellers, result);
    }
    
    @Test
    public void testUpdatePrice() {
        // Set up test data
        int hotel_id = 1;
        double newPrice = 150.0;
        Seller seller = new Seller();
        seller.setPrice(newPrice);

        // Configure the mock repository to return the updated seller
        when(sellerRepository.findById(hotel_id)).thenReturn(Optional.of(seller));
        when(sellerRepository.save(seller)).thenReturn(seller);

        // Call the method being tested
        Seller result = sellerService.updatePrice(hotel_id, newPrice);

        // Assert that the updated seller is returned
        assertEquals(seller, result);
    }

    @Test
    public void testDeleteSellerById() {
        // Set up test data
        int id = 1;

        // Call the method being tested
        sellerService.deleteSellerById(id);

        // Assert that the repository's deleteById method was called with the correct id
        verify(sellerRepository, times(1)).deleteById(id);
    }
}