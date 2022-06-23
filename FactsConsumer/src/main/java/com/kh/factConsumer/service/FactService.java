package com.kh.factConsumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kh.factConsumer.model.Fact;

@Service
public class FactService {

	public List<Fact> getFact(int numberOfFacts) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		List<Fact> facts = new ArrayList<>();
		
		for(int i=0;i<numberOfFacts;i++) {
			
			Fact fact = restTemplate.getForObject("https://catfact.ninja/fact", Fact.class);
			
			facts.add(fact);
			
		}

		return facts;
	}
	
	
}
