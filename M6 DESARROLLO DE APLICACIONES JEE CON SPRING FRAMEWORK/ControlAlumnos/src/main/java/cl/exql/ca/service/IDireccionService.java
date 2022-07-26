package cl.exql.ca.service;

import java.util.ArrayList;

import cl.exql.ca.model.Direccion;

public interface IDireccionService  {

	public void save(Direccion direccion);
	public ArrayList<Direccion> findAll();
}
