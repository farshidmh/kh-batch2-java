package com.kh.factConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.kh.factConsumer.model.Fact;

@SpringBootApplication
public class FactsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactsConsumerApplication.class, args);	
	}
	
	

}
