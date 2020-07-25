package com.capgemini.flightManagement;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FlightManagementSystemApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Flight Management Running.");
		
	}

}
