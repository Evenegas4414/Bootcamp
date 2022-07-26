package cl.exql.cd.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.exql.cd.model.Pasajero;
import cl.exql.cd.repository.IPasajeroRepository;
import cl.exql.cd.service.IPasajeroService;

@Service
public class PasajeroServiceImpl implements IPasajeroService {

	@Autowired
	IPasajeroRepository pasajeroRepository;
	
	@Override
	public void save(Pasajero pasajero) {
		
		pasajeroRepository.save(pasajero);
	}

	@Override
	public ArrayList<Pasajero> findAll() {
		
		return (ArrayList<Pasajero>) pasajeroRepository.findAll();
	}

}
