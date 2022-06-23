package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstController {
	
	@GetMapping( value="/users" )
	public List<User> getUsers() {
		
		User u1 = new User("John", "Doe", 15);
		User u2 = new User("Jane", "Doe", 51);
		User u3 = new User("Tim", "Doe", 45);
	
		List<User> listUsers = new ArrayList<User>();
		
		listUsers.add(u3);
		listUsers.add(u2);
		listUsers.add(u1);
		

		return listUsers;

		
		
	}
	
	
	@GetMapping( value="/orders" )
	public Map<String,String> getOrders(){
		
		HashMap<String,String> myReturn = new HashMap();
		
		myReturn.put("name", "John");
		myReturn.put("family", "Doe");
		//myReturn.put("age",12);
		
		
		return myReturn;
		
		
		
		
		
	}
	
	
	

}
