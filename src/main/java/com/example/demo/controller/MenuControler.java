package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")

public class MenuControler {
	
	private static final Logger LOG = Logger.getLogger(MenuControler.class);

	// http://localhost:8080/renta/menu/botones
	@GetMapping("/botones")
	public String vistaMenu() {
		
		LOG.info("botones");
		
		return "vistaMenuGeneral";
	}
	//falta  1.b 2.e 2.f y toda la 3 abc
}
