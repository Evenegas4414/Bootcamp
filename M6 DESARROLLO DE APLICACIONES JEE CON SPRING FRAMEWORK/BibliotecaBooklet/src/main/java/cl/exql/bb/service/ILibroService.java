package cl.exql.bb.service;

import cl.exql.bb.model.Libro;
import cl.exql.bb.vo.LibroVO;

public interface ILibroService {
	
	public LibroVO findAll();
	public LibroVO findById(Integer idLibro);
	public LibroVO add(Libro usuario);
	public LibroVO update(Libro usuario);
	public LibroVO delete(Libro usuario);
	public LibroVO findByTituloOrAutor(String textoBuscado);

}
