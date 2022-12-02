package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//xml dosyası yerine config class'ından bilgi okuma

public class Main {

	public static void main(String[] args) {
		
		//  CustomerManager manager = new CustomerManager(new MySqlCustomerDal());
        //  manager.add();
		
		// reading xml file
		//ClassPathXmlApplicationContext context = 
		//		new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// reading configuration class 
		AnnotationConfigApplicationContext context = 
		    	new AnnotationConfigApplicationContext(IocConfig.class);
		
		
		// new operator for database with xml file
		ICustomerService customerService = context.getBean("service", ICustomerService.class);
			
		customerService.add();

	}
	
	// IoC- Inversion of Control
	// Depedency Injection
	// the important thing is to code that 
	// does not resist any change
	// !! SOLID principles
	// a class must not create object from another class ( must not use "new" operator)

}
