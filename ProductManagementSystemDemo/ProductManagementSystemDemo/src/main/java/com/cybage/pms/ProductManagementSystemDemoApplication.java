package com.cybage.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cybage")
public class ProductManagementSystemDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementSystemDemoApplication.class, args);
	}

}
