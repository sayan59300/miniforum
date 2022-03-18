package com.miniforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InscriptionController {
	
	@GetMapping(value = "/inscription" )
	public String inscription() {
		
		return "inscription";
		
	}

}