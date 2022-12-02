package com.javacourse.springBootDemo.restApiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
   
	//Ürün listelemek için get metodu yazıyoruz
	//Uygulamayı çalıştırdığımızda hiçbir şey 
	//yapmasak da ekrana bu gelecek
	@GetMapping("/")
	public String get() {
		return "Laptop";
	}
	
	@GetMapping("/products")
	public String get2() {
		return "Laptop 3";
	}
	
	
	/*Eğer port ile ilgili sorun varsa
	  komut satırını admin olarak çalıştır,
	  netstat -ano | findstr :8080(port number)
	  output: TCP    0.0.0.0:8080           0.0.0.0:0              LISTENING       16508
	  taskkill/PID 16508 /F
	  output: SUCCESS: The process with PID 16508 has been terminated.
	*/
}
