package com.javacourse.project.hibernateAndJpa.DataAccessLayel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;

//JPA-Java Persistence Api

//@Autowired ile repository aranacak
@Repository
public class HibernateCityDal implements ICityDal {
 
	//@PersistenceContext
	private EntityManager entityManager;
	
	//JPA ile hızlı bir şekilde hangi implementasyonu 
    //istiyorsak ona erişebiliriz
    //Paketlerimiz içersinde hibernate olduğu için
	//entityManager hibernate ile işlem yapacak
	//*** Otomatik olarak Hibernate injeksiyonu ***
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	//AOP-Aspect Oriented Programming
	//Kod build olduğunda kodun önüne ve sonuna session
	//açma ve kapama kodlarını otomatik koyuyor
	//Artık hibernateDemo projesinde kullandığımız
	//session.beginTransaction().. gibi kodlara
	//gerek yok
	@Transactional
	public List<City> getAll() {
	   //session nesnesi ataması
	   Session session = entityManager.unwrap(Session.class);
	   List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		  Session session = entityManager.unwrap(Session.class);
		  session.saveOrUpdate(city);
		
	}

	@Override
	public void update(City city) {
		  Session session = entityManager.unwrap(Session.class);
		  session.saveOrUpdate(city);
		
	}

	@Override
	public void delete(City city) {
		  Session session = entityManager.unwrap(Session.class);
		  City cityToDelete = session.get(City.class, city.getId());
		  session.delete(cityToDelete);
		  
		
	}

	@Override
	public City getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		City city = session.get(City.class, id);
		return city;
	}

}
