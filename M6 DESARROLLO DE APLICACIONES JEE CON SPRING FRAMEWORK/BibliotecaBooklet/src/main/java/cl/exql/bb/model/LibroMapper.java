package cl.exql.bb.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Libro libro = new Libro();
		libro.setIdLibro(rs.getInt("id_libro"));
        libro.setAnio(rs.getInt("anio"));
        libro.setTitulo(rs.getString("titulo"));
        libro.setAutor(rs.getString("autor"));
        libro.setImprenta(rs.getString("imprenta"));
        libro.setDisponibilidad(rs.getInt("disponible"));
		return libro;
	}

}
