package com.progra3.estudiantes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.progra3.estudiantes.entities.Estudiante;
import com.progra3.estudiantes.services.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	EstudianteService estudianteService;
	
	@GetMapping
	public List<Estudiante> listarEstudiantes(){
		return estudianteService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Estudiante obtenerEstudiante(@PathVariable Long id) {
		return estudianteService.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void crearEstudiante(@Valid @RequestBody Estudiante estudiante) {
		estudianteService.createEstudiante(estudiante);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void modificarEstudiante (@PathVariable Long id, @RequestBody Estudiante estudiante) {
		estudianteService.modifyEstudiante(id, estudiante);
	}
	
	@DeleteMapping("/{id}")
	public void borrarEstudiante(@PathVariable Long id) {
		estudianteService.deleteEstudiante(id);
	}
	
	 @ResponseStatus(code = HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public Map<String, String> handleValidationExceptions(
	   MethodArgumentNotValidException ex) {
	     Map<String, String> errors = new HashMap();
	     ex.getBindingResult().getAllErrors().forEach((error) -> {
	         String fieldName = ((FieldError) error).getField();
	         String errorMessage = error.getDefaultMessage();
	         errors.put(fieldName, errorMessage);
	     });
	     return errors;
	 }

}
