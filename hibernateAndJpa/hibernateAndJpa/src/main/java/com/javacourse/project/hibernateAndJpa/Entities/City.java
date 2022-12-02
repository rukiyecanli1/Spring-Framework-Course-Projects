package com.javacourse.project.hibernateAndJpa.Entities;

//bu import hata verdiği için pom.xml'e gidip
//data-jpa dependency ekledik
import javax.persistence.*;

//@Entity ile bu class'ın veritabanıonda
//bir tablo olduğunu ifade ediyoruz
@Entity 
@Table(name="city")
public class City {

   //Değişkenlerimizi veri tabanındaki sütunlarla eşliyoruz
   @Id
   @Column(name="ID")
   //otomatik id ataması
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   
   @Column(name="Name")
   private String name;
   
   @Column(name="CountryCode")
   private String countryCode;
   
   @Column(name="District")
   private String district;
   
   @Column(name="Population")
   private int population;
   
public City(int id, String name, String countryCode, String district, int population) {
	super();
	this.id = id;
	this.name = name;
	this.countryCode = countryCode;
	this.district = district;
	this.population = population;
}

public City() {
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCountryCode() {
	return countryCode;
}

public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}

public String getDistrict() {
	return district;
}

public void setDistrict(String district) {
	this.district = district;
}

public int getPopulation() {
	return population;
}

public void setPopulation(int population) {
	this.population = population;
}
   
   
}
