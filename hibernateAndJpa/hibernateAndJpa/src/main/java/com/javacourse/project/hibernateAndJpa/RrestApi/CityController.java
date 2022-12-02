package com.javacourse.project.hibernateAndJpa.RrestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.ICityService;
import com.javacourse.project.hibernateAndJpa.Entities.City;

@RestController

//bu sınıftaki bütün operasyonlar api ile başlayacak
@RequestMapping("/api")
public class CityController {
	
	private ICityService cityService;

	
	//cityService'e otomatik olarak CityManager objesi verilecek
	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	//client'e veri getirme
	@GetMapping("/cities")
	public List<City> get() {
		return cityService.getAll();
	}
	
	//server'a veri gönderme
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		this.cityService.add(city);
	}
	
	//server'a veri gönderme
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		this.cityService.add(city);
	}
	
	//server'a veri gönderme
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		this.cityService.add(city);
	}
	
	//client'e veri getirme
	//@PathVariable ile {id} içerisindeki değeri okunacak
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id) {
		return this.cityService.getById(id);
	}
}
