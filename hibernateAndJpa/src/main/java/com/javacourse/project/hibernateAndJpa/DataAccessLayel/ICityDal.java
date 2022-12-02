package com.javacourse.project.hibernateAndJpa.DataAccessLayel;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javacourse.project.hibernateAndJpa.Entities.City;


public interface ICityDal {
	
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
	
}
