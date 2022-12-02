package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Entity;
public class Main {

	public static void main(String[] args) {
		
	   //session'lar veri tabanına arka arkaya sorgu 
       //gonderebilecegimiz yapılardır
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
	    
		//Burada Unit of Work tasarım deseni uygulanıyor
		Session session = factory.getCurrentSession();
		
		//eger yeni bir şehir eklerken, gunceller, silerken vb. 
		//hata olursa tum islemler iptal edilir
		//hibernate-session ile bunu otomatik olarak saglatıyoruz
		
		try {
			session.beginTransaction();
			
			//HQL-->Hibernate Query Language dili ile sorgu yapıyoruz
			
			//Çok kolay!!! :)))) 
			//.createQuery(), createQuery().executeUpdate()... 
			//gibi sıkıcı işlemlerden kurtulduk!!!
			//artık stackoverflow'u daha az ziyaret edicem :D
			
			//HQL Ornekleri:
			
			//"Select * from city where countryCode='TUR' OR 
			//counrtyCode='USA'" verilerini list'e atama
			//List<City> cities = session.createQuery("from City c where c.countryCode='TUR'"
			//		+ "OR c.countryCode='USA'").getResultList();
			
			// içinde "kar" geçen şehir isimlerini list'e atama
			//List<City> cities = session.createQuery("from City c where c.name LIKE '%kar%'").getResultList();
			
			//Şehirleri isme gore alfabetik olarak sıralayıp list^'e atama
			//ASC-Ascending-Yukselen A-->Z 
			//DESC-Descending-Alcalan Z-->A
			//List<City> cities = session.createQuery("from City c ORDER BY c.name ASC").getResultList();
			
			//ülke kodlarına göre gruplayıp list'e atama
			//burada String bir list oluşturmalıyız çünkü
			//select c.countryCode ile ülke kodlarını tek çekiyoruz
			//List<String> countryCodes = session.createQuery("select c.countryCode from City c GROUP BY c.countryCode").getResultList();
			//for(String countryCode:countryCodes) {
			//	System.out.println(countryCode);
			//}
			
			
			//CRUD Create Read Update Delete
			
			
			/*INSERT-veri tabanına yeni veri ekleme
			Hibernate: insert into city (CountryCode, District, Name, Population, ID)
			values (?, ?, ?, ?, ?)
			City city = new City();
			city.setName("Duzce 10");
			city.setCountryCode("TUR");
			city.setDistrict("Karadeniz");
			city.setPopulation(100000);
			session.save(city);
			System.out.println("Sehir eklendi!");
			*/
			
		    /*UPDATE-veri tabanındaki veriyi guncelleme
			4080 id'li veriyi session.get() ile getiriyoruz
			Hibernate: select city0_.ID as ID1_0_0_, city0_.CountryCode as CountryC2_0_0_, city0_.District as District3_0_0_, city0_.Name as Name4_0_0_, city0_.Population as Populati5_0_0_ from city city0_ where city0_.ID=?
			City c = session.get(City.class, 4081); 
			Hibernate: update city set CountryCode=?, District=?, Name=?, Population=? where ID=?
			c.setPopulation(90000);
			session.save(c);
			System.out.println("Sehir guncellendi!");
			*/
			
		    /*DELETE-veri tabanından veri silme
			Hibernate: select city0_.ID as ID1_0_0_, city0_.CountryCode as CountryC2_0_0_, city0_.District as District3_0_0_, city0_.Name as Name4_0_0_, city0_.Population as Populati5_0_0_ from city city0_ where city0_.ID=?
			City c2 = session.get(City.class, 4081);
			Hibernate: delete from city where ID=?
			session.delete(c2);
			System.out.println("Sehir silindi!");
			*/
			
			//session'i gerceklestirme
		    session.getTransaction().commit();
			
	
		}
		
		//hibernate hataları otomatik aldığı için 
		//catch'e gerek yok
		
		finally {
			factory.close();
		}
				
	}

}
