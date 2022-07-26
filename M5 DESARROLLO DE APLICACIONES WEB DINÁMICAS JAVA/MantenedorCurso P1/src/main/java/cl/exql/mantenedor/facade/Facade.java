package cl.exql.mantenedor.facade;

import java.sql.SQLException;
import java.util.List;

import cl.exql.mantenedor.daos.CursoDAO;
import cl.exql.mantenedor.daos.FormaDePagoDAO;
import cl.exql.mantenedor.daos.InscripcionDAO;
import cl.exql.mantenedor.entidades.CursoDTO;
import cl.exql.mantenedor.entidades.FormaDePagoDTO;
import cl.exql.mantenedor.entidades.InscripcionDTO;

public class Facade {

	public boolean registrarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {

		InscripcionDAO dao = new InscripcionDAO();
		return dao.insertarInscripcion(dto);
	}

	public List<CursoDTO> obtenerCursos() throws SQLException, ClassNotFoundException {

		CursoDAO dao = new CursoDAO();
		return dao.obtieneCursos();
	}

	public List<FormaDePagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException {

		FormaDePagoDAO dao = new FormaDePagoDAO();
		return dao.obtieneFormasDePago();
	}

	// DESAFIO GUIADO REQUISITO 1
	
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.obtieneInscripciones();
	}
}