package cl.exql.ca.service;

import java.util.ArrayList;

import cl.exql.ca.model.Alumno;

public interface IAlumnoService {
	
	public void save(Alumno alumno);
	public ArrayList<Alumno> findAll();

}
