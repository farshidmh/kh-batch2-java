package com.kh.ReviewProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

	
	
	@GetMapping(value = "/users")
	private String getUsers(
			@RequestParam( value="name", required = false,defaultValue = "Hello" ) String name
			) {
		
		
		return name;
		
	}
	
	@GetMapping(value = "/cities")
	private String getCities() {
		
		return "Bye";
		
	}
	
	
	
	
}
