package com.onlinehotelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.onlinehotelbooking")
public class OnlinehotelbookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinehotelbookingApplication.class, args);
	}

}
