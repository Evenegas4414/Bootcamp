package cl.exql.ca.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.exql.ca.model.Direccion;
import cl.exql.ca.repository.IDireccionRepository;
import cl.exql.ca.service.IDireccionService;

@Service
public class DireccionServiceImpl implements IDireccionService {

	@Autowired
	IDireccionRepository direccionRepository;

	@Override
	public void save(Direccion direccion) {

		direccionRepository.save(direccion);
	}

	@Override
	public ArrayList<Direccion> findAll() {

		return (ArrayList<Direccion>) direccionRepository.findAll();
	}

}
