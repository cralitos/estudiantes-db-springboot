package com.progra3.estudiantes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursosController {
	
	@GetMapping(value = "/tets")
	public String test() {
		return "test";
	}

}
