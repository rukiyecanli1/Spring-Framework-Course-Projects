package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//xml dosyası kullamak yerine annotasyon bazlı
//class kullanacağız
@Configuration 

//database için paketteki tüm sınıfları arayacak
//--"@Component("database")" araması--
@ComponentScan("com.springdemo") 

//değerleri bu kaynakta alacak
@PropertySource("classpath:values.properties")

public class IocConfig {
	@Bean
    public ICustomerDal database() {
    	return new MsSqlCustomerDal();
    }
	
	@Bean
    public ICustomerService service() {
    	return new CustomerManager(database());
    }
}
