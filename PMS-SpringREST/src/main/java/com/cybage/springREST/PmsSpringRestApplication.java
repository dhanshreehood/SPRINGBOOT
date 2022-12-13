package com.cybage.springREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cybage")
public class PmsSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmsSpringRestApplication.class, args);
	}

}