package com.onlinehotelbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlinehotelbooking.model.User;
import com.onlinehotelbooking.service.UserService;

import jakarta.servlet.http.HttpSession;
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String RegisteringProperty() {
		return "Main.html";
	}
	@PostMapping("/createaccount")
    public String createAccount(@ModelAttribute("user") User user, BindingResult result,ModelMap model) {
        if (result.hasErrors()) {
            return "Main.html";
        }
        //this.emailIdbooking=user.getEmailId();
        userService.saveUser(user.getName(), user.getEmailId(), user.getPassword());
        model.addAttribute("SuccessMessage","Account created successfully! please login");
        return "Main.html";
    }

	    @PostMapping("/login")
	    public String login(@RequestParam String emailId, @RequestParam String password,ModelMap model,HttpSession session) {
	        User loggedInUser = userService.findByEmailAndPassword(emailId, password);
	        if (loggedInUser != null) {
	        	session.setAttribute("user", loggedInUser);
	            return "SearchPage.html";
	        } else {
	        	model.addAttribute("errorMessage","The password you entered is incorrect");
	            return "Main.html";
	        }
	}

}
