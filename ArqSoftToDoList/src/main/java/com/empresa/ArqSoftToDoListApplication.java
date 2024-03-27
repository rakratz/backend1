package com.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empresa.model.Employee;

@SpringBootApplication
public class ArqSoftToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArqSoftToDoListApplication.class, args);
		
		Employee funcionario1 = new Employee();
		String nome = funcionario1.getName();
		
	}

}
