package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

//import org.springframework.stereotype.Component;

//@Component("database")
public class MySqlCustomerDal implements ICustomerDal {

	// value config dosyasından okunacak
	@Value("${database.connectionString}")
	String connectionString;
	
	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	@Override
	public void add() {
		System.out.println("Baglanti string i : "+this.connectionString);
		System.out.println("Mysql veri tabanına eklendi.");
		
	}

}
