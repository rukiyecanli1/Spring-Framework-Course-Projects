package com.javacourse.project.hibernateAndJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.javacourse.project.hibernateAndJpa.DataAccessLayel.HibernateCityDal;

@SpringBootApplication
@EnableJpaRepositories("com.javacourse.project.hibernateAdJpa.Entities")
public class HibernateAndJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HibernateAndJpaApplication.class, args);
	}

	  @Autowired
	  HibernateCityDal hbcd;
	  
	  
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
