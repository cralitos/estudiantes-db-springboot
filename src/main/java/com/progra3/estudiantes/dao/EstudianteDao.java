package com.progra3.estudiantes.dao;

import org.springframework.data.repository.CrudRepository;

import com.progra3.estudiantes.entities.Estudiante;

public interface EstudianteDao extends CrudRepository<Estudiante, Long> {

}
