package cl.exql.mantenedor.facade;

import java.sql.SQLException;
import java.util.List;

import cl.exql.mantenedor.daos.CursoDAO;
import cl.exql.mantenedor.daos.FormaPagoDAO;
import cl.exql.mantenedor.daos.InscripcionDAO;
import cl.exql.mantenedor.entidades.CursoDTO;
import cl.exql.mantenedor.entidades.FormaPagoDTO;
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

	public List<FormaPagoDTO> obtenerFormasDePago() throws SQLException, ClassNotFoundException {

		FormaPagoDAO dao = new FormaPagoDAO();
		return dao.obtieneFormasDePago();
	}

	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		InscripcionDAO dao = new InscripcionDAO();
		return dao.obtieneInscripciones();
	}
}