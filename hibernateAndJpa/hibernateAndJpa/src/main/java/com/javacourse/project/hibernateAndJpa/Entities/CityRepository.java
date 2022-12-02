package com.javacourse.project.hibernateAndJpa.Entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

	public Optional<City> findById(Integer id);
}
