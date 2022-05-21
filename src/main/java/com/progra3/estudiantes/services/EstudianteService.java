package com.progra3.estudiantes.services;

import java.util.List;

import com.progra3.estudiantes.entities.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> findAll();
	public Estudiante findById(Long id);
	public void createEstudiante(Estudiante estudiante);
	public void modifyEstudiante(Long id, Estudiante estudiante);
	public void deleteEstudiante(Long id);

}
