package com.cybage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cybage.bean.Department;
import com.cybage.bean.Employee;

@Configuration //it will configure your bean
public class ConfigurationClass {

	@Bean(name="employee") //returns bean object
	public Employee getEmployee() 
	{
//		setter injection
/*		Employee employee=new Employee();
		employee.setId(1001);
		employee.setName("Dhanshree");
		employee.setEmail("vijayalaxmi@gmail.com");
		employee.setAddress("Pune");
		employee.setSalary(1000000);
*/
		
//		constructor injection
		Employee employee = new Employee(10003, "Meena", "m@gmail.com", "Himachal Pradesh", 50000);
		return employee;
	}
	
	@Bean(name="department")
	@Scope(value = "prototype") // will create instance everytime you'll call
	public Department getDepartment()
	{
		Department employee=new Department();
		employee.setDepartment("Trainee Software Engineer");
		System.out.println("New constructor created...");
		return employee;
	}
}