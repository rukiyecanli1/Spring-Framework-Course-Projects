package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.DataAccessLayel.ICityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;

//CityManager-iş kodu sınıfı
@Service
public class CityManager implements ICityService {

	private ICityDal cityDal;
	
    //dependency injection
	
	//@Autowired: "otomatik olarak ICityDal'a uygun olan objeyi ver"
	//HibernateCityDal verilecek çünkü ICityDal'ı implement eden başka nesne yok
	@Autowired
	//(required = false)
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	//@Transactional: session başlangıç ve bitiş 
	//kodlarını otomatik koyuyor
	@Transactional
	public List<City> getAll() {
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
	   //burada müşterinin taleplerine göre iş kuralları yazılır
       this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		//iş kuralları
		 this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		//iş kuralları
		 this.cityDal.delete(city);
		
	}

	@Override
	@Transactional
	public City getById(int id) {
		//iş kuralları
	return this.cityDal.getById(id);
		
	}




}
