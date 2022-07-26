package cl.exql.bb.dao.impl;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.exql.bb.dao.ILibroDao;
import cl.exql.bb.model.Libro;
import cl.exql.bb.model.LibroMapper;


@Repository
public class LibroDaoImpl implements ILibroDao {

	JdbcTemplate jdbcTemplate;

	String SQL_LISTAR = "SELECT * FROM libro ORDER BY id_libro";
	String SQL_BUSCAR_ID = "SELECT * FROM libro WHERE id_libro = ? ORDER BY id_libro";
	String SQL_AGREGAR = "INSERT INTO libro (id_libro, anio, titulo, autor, imprenta, disponible) "
			+ "VALUES (sq_libro.nextval, ?, ?, ?, ?, ?)";
	String SQL_ACTUALIZAR = "UPDATE libro SET  anio = ?, titulo = ?, autor = ?, imprenta = ?, "
			+ "disponible = ? WHERE id_libro = ?";
	String SQL_ELIMINAR = "DELETE FROM libro WHERE id_libro = ?";
	String SQL_TEXTO_BUSQUEDA = "SELECT * FROM libro WHERE titulo LIKE ? OR autor LIKE ? ORDER BY id_libro";

	@Autowired
    public LibroDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public ArrayList<Libro> findAll() {
		
		return (ArrayList<Libro>) jdbcTemplate.query(SQL_LISTAR, new LibroMapper());
	}

	@Override
	public Libro findById(Integer idLibro) {
		
		return jdbcTemplate.queryForObject(SQL_BUSCAR_ID, new LibroMapper(), idLibro);
	}

	@Override
	public int add(Libro libro) {
		System.out.println("LibroDaoImpl.java" + libro.toString());
		return jdbcTemplate.update(SQL_AGREGAR, libro.getAnio(), libro.getTitulo(), libro.getAutor(),
				libro.getImprenta(), libro.getDisponibilidad());
	}

	@Override
	public int update(Libro libro) {
		
		return jdbcTemplate.update(SQL_ACTUALIZAR, libro.getAnio(), libro.getTitulo(), libro.getAutor(),
				libro.getImprenta(), libro.getDisponibilidad(), libro.getIdLibro());
	}

	@Override
	public int delete(Libro libro) {
		
		return jdbcTemplate.update(SQL_ELIMINAR, libro.getIdLibro());
	}

	@Override
	public ArrayList<Libro> findByTituloOrAutor(String textoBuscado) {

		String texto = "%"+textoBuscado+"%";
        return (ArrayList<Libro>) jdbcTemplate.query(SQL_TEXTO_BUSQUEDA, new LibroMapper(), texto, texto);
	}

}
