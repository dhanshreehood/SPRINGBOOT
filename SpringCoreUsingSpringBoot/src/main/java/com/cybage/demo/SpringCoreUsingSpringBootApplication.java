package com.cybage.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cybage.bean.Employee;

@SpringBootApplication(scanBasePackages = "com.cybage") //@Configuration + @EnableAutoConfiguration + @ComponentScan
public class SpringCoreUsingSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCoreUsingSpringBootApplication.class, args);
		Employee employee = context.getBean(Employee.class); //blank object- by using default constructor
		employee.setId(5020);
		employee.setName("Dhanshree Hood");
		employee.setEmail("d@gmail.com");
		employee.setAddress("NGP");
		employee.setSalary(500000);
	}
}