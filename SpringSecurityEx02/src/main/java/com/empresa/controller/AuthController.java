package com.empresa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	@GetMapping("/free")
	public String sayFreeHello() {
		return "Endpoint: Hello World sem Autenticação";
	}
	
	@GetMapping("/auth")
	public String sayAuthHello() {
		return "Endpoint: Hello World com Autenticação";
	}
}
