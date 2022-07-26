package cl.exql.ca.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.exql.ca.model.Alumno;
import cl.exql.ca.repository.IAlumnoRepository;
import cl.exql.ca.service.IAlumnoService;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	IAlumnoRepository alumnoRepository;
	
	@Override
	public void save(Alumno alumno) {
		
		alumnoRepository.save(alumno);
	}

	@Override
	public ArrayList<Alumno> findAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Alumno>) alumnoRepository.findAll();
	}

}
