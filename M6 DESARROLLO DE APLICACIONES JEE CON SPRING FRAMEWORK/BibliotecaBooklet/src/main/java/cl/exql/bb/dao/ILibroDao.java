package cl.exql.bb.dao;

import java.util.ArrayList;

import cl.exql.bb.model.Libro;

public interface ILibroDao {

	public ArrayList<Libro> findAll();
	public Libro findById(Integer idLibro);
	public int add(Libro libro);
	public int update(Libro libro);
	public int delete(Libro libro);
	public ArrayList<Libro> findByTituloOrAutor(String textoBuscado);

}
