package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")

public class MenuControler {

	@GetMapping("/botones")
	public String vistaMenu() {
		
		return "vistaMenuGeneral";
	}
	
	
	
	//falta  1.b 2.e 2.f y toda la 3 abc
}
