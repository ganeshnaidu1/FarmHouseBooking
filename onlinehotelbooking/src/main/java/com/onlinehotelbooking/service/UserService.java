package com.onlinehotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.onlinehotelbooking.model.User;
import com.onlinehotelbooking.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository ; 
	public void saveUser(String name, String emailId, String password) {
        userRepository.save(new User(name, emailId, password));
    }
	public User findByEmailAndPassword(String emailId, String password) {
		//System.out.println("in service");
		return userRepository.findByEmailIdAndPassword(emailId, password);
	}

}
