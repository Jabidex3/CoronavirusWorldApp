package com.cognixia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Task:
	Create Maven Project to implement the following application using Spring Boot: 
	-Print all Countries along with their Capitals (atleast 5 countries)
	-Based on the country, print the population of the country using path variables.
	Note: Do not connect to database. Ensure a model and a controller class are present.

 */
@SpringBootApplication
public class SBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SBootApplication.class, args);
	}
}
