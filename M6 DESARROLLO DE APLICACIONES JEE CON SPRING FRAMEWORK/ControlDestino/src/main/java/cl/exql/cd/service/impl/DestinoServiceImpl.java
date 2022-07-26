package cl.exql.cd.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.exql.cd.model.Destino;
import cl.exql.cd.repository.IDestinoRepository;
import cl.exql.cd.service.IDestinoService;

@Service
public class DestinoServiceImpl implements IDestinoService {

	@Autowired
	IDestinoRepository destinoRepository;

	@Override
	public void save(Destino destino) {

		destinoRepository.save(destino);
	}

	@Override
	public ArrayList<Destino> findAll() {

		return (ArrayList<Destino>) destinoRepository.findAll();
	}

}
