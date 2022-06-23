package com.kh.factConsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.factConsumer.model.Fact;
import com.kh.factConsumer.service.FactService;

@RestController
public class FactController {

	
	@Autowired
	FactService factService;
	
	@GetMapping("/facts")
	public List<Fact> getFacts(
			@RequestParam( required = false, value = "count" , defaultValue = "1" ) int count		
			){
		
			return factService.getFact(count);
				
	
	}
	
	
	
}
