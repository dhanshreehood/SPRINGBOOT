package com.cybage.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cybage.bean.Department;
import com.cybage.bean.Employee;
import com.cybage.config.ConfigurationClass;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {

/*		//		xml based configuration

//		SpringApplication.run(SpringCoreApplication.class, args);		
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("employee.xml");
	
//		typecasting object into Employee and getting bean id employee from xml
		Employee employee=(Employee)beanFactory.getBean("employee");

		System.out.println(employee.getId()) 
		System.out.println(employee.getName());
		System.out.println(employee.getAddress());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSalary());
*/
		
//		Annotation based configuration
//		Employee
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ConfigurationClass.class);
		Employee employee=(Employee)context.getBean("employee");
		/*
//		setter injection
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getAddress());
		System.out.println(employee.getEmail());
		System.out.println(employee.getSalary());
		*/
		
//		constructor injection
		System.out.println(employee);
		
//		for Department
		AnnotationConfigApplicationContext context1= new AnnotationConfigApplicationContext(ConfigurationClass.class);
		Department department=(Department)context1.getBean("department");
		
//		setter injection
//		System.out.println(department.getDepartment());
		
//		constructor injection
		System.out.println(department);
		
		//only one object will be created; if you write the same thing it will return the same object.
		
		//prototype scope
		Department department2=(Department)context1.getBean("department");
		System.out.println(department);
		
//		it will destroy all the object created by the constructor
		context.close();
	}
}