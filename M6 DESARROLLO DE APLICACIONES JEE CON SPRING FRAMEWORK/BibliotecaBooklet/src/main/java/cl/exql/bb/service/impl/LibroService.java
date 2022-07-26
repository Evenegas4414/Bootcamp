package cl.exql.bb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.exql.bb.dao.ILibroDao;
import cl.exql.bb.model.Libro;
import cl.exql.bb.service.ILibroService;
import cl.exql.bb.vo.LibroVO;

@Service
public class LibroService implements ILibroService {

	@Autowired
	ILibroDao iLibroDao;
	LibroVO respuesta;

	@Override
	public LibroVO findAll() {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error.", "101");
		try {
			respuesta.setLibros(new ArrayList<>());
			respuesta.setLibros(iLibroDao.findAll());
			respuesta.setMensaje("Cantidad de libros encontrados: " + respuesta.getLibros().size() + ".");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findById(Integer idLibro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error al buscar.", "102");
		try {
			respuesta.setLibros(new ArrayList<>());
			respuesta.getLibros().add(iLibroDao.findById(idLibro));
			respuesta.setMensaje("Cantidad de libros encontrados: " + respuesta.getLibros().size() + ".");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO add(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "103");
		try {
			System.out.println("LibroDaoImpl.java" + libro.toString());
			int registrosActualizados = iLibroDao.add(libro);
			if (registrosActualizados == 1) {
				respuesta.setMensaje("Se ha agregado el libro correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("No se ha podido agregar el libro.");
			}
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO update(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "104");
		try {
			int registrosActualizados = iLibroDao.update(libro);
			respuesta.setMensaje("Se ha actualizado correctamente el libro: " + libro.getTitulo() + ".");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO delete(Libro libro) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "105");
		try {
			int registrosActualizados = iLibroDao.delete(libro);
			if (registrosActualizados == 1) {
				respuesta.setMensaje("Se ha eliminado correctamente el libro: " + libro.getTitulo() + ".");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("No se pudo eliminar el libro: " + libro.getTitulo() + ".");
			}
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findByTituloOrAutor(String textoBuscado) {
		respuesta = new LibroVO(new ArrayList<Libro>(), "Ha ocurrido un error", "107");
		try {
			respuesta.setLibros(new ArrayList<>(iLibroDao.findByTituloOrAutor(textoBuscado)));
			respuesta.setMensaje("Cantidad de libros encontrados: " + respuesta.getLibros().size() + ".");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			System.err.print(e);
		}
		return respuesta;
	}

}
