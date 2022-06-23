package com.kh.userManager.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	
	
	public HashMap<String, String> createUser( String name, String family, int age  ) {
		
		
		HashMap<String, String> createUserReturn = new HashMap<>();		
		createUserReturn.put("message", "User has been created");
		createUserReturn.put("firstName", name );
		createUserReturn.put("lastName", family );
		
		if( age > 20 ) {			
			createUserReturn.put("age", "Hello" );			
		}else {			
			createUserReturn.put("age", "Goodbye" );	
		}
	
		return createUserReturn;
		
	}
	
	
	

}
