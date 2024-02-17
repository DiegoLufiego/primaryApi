package com.kopek.stockAndSales.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainRestController {

	
	@RequestMapping ("/helloss")
	public String getString() {
		return "Hola Munditoooooo";
	}
	
}
