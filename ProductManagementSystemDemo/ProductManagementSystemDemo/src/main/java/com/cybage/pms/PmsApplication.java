package com.cybage.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cybage")

public class PmsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PmsApplication.class, args);
	}

}
