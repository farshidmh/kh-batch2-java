package com.kh.userManager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.userManager.model.User;
import com.kh.userManager.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	@GetMapping(value = "/users")
	public List<User> getUserController(  
			@RequestParam( value="age" , required = false, defaultValue = "19" ) int age, 
			@RequestParam(value="name") String name  
			){
		
		User u1 = new User(name, "Doe", age);
		User u2 = new User("Jane","Doe",age);
		
		List<User> userList = new ArrayList<>();
		
		userList.add(u2);
		userList.add(u1);
		
		
		return userList;		
	}
	
	
	@PostMapping( value = "/users" )
	public ResponseEntity< Map > createNewUserController(
			@RequestParam String name,
			@RequestParam String family,
			@RequestParam int age

			) {

			
		return ResponseEntity.status(HttpStatus.CREATED).body( userService.createUser(name, family, age) );		
	}	
	
	@PutMapping(value = "/users")
	public Map<String,String> putUserController() {
		
		HashMap<String, String> createUserReturn = new HashMap<>();		
		createUserReturn.put("message", "Users has been updated");		
		
		return createUserReturn;		
	}
	
	
	@PatchMapping( value = "/users/{id}" )
	public Map<String,String> patchUserController(
			@PathVariable int id
			) {
		
		HashMap<String, String> createUserReturn = new HashMap<>();		
		createUserReturn.put("message", "User has been updated");
		createUserReturn.put("RequestedID", String.valueOf( id ) );
				
		return createUserReturn;		
	}
	
	@DeleteMapping(value = "/users" )
	public Map<String,String> deleteUserController() {
		
		HashMap<String, String> createUserReturn = new HashMap<>();		
		createUserReturn.put("message", "User has been removed");		
		
		return createUserReturn;
		
	}
	
}
