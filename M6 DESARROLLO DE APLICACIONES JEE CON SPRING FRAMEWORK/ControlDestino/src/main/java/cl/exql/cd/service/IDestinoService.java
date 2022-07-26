package cl.exql.cd.service;

import java.util.ArrayList;

import cl.exql.cd.model.Destino;

public interface IDestinoService  {

	public void save(Destino destino);
	public ArrayList<Destino> findAll();
}
