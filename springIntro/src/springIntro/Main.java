package springIntro;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//xml dosyasından bilgi okuma

public class Main {

	public static void main(String[] args) {
		
		//  CustomerManager manager = new CustomerManager(new MySqlCustomerDal());
        //  manager.add();
		
		// reading xml file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// new operator with xml file
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
