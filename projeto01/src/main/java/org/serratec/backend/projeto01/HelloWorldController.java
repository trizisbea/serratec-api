package org.serratec.backend.projeto01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*@RestController 
public class HelloWorldController {
	
	@RequestMapping("/hello") 
	public String hello() {
		return "Olá mundo"; 
	}
	
	@RequestMapping("/hallo")
	public String hallo() {
		return "Hallo Welt";
	} */
	

	//Possibilidadade de fazer um único mapeamento: 
	 
	 @RestController
	 @RequestMapping("/api/v1")
	 public class HelloWorldController {
		 
	@GetMapping("/maiuscula")
	public String gerarMaiuscula(@RequestParam String valor) {
		return valor.toUpperCase();
	//http://localhost:8080//api/v1/maiuscula?valor=teste
		
	}
	
	@RequestMapping("/hello") 
	public String hello() {
		return "Olá mundo"; 
	//http://localhost:8080//api/v1/hello
	}
	
	@GetMapping("/hallo") 
	public String hallo() {
		return "Hallo Welt"; 
	}
	
	
	
	
}
