package cl.exql.cd.service;

import java.util.ArrayList;

import cl.exql.cd.model.Pasajero;

public interface IPasajeroService {
	
	public void save(Pasajero pasajero);
	public ArrayList<Pasajero> findAll();

}
