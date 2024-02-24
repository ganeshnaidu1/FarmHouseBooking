package com.onlinehotel.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onlinehotelbooking.model.User;
import com.onlinehotelbooking.repository.UserRepository;
import com.onlinehotelbooking.service.UserService;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testFindByEmailAndPassword() {
        // Arrange
        String emailId = "john.doe@example.com";
        String password = "password";
        User user = new User("John Doe", emailId, password);
        when(userRepository.findByEmailIdAndPassword(emailId, password)).thenReturn(user);

        // Act
        User result = userService.findByEmailAndPassword(emailId, password);

        // Assert
        assertEquals(user, result);
    }
}