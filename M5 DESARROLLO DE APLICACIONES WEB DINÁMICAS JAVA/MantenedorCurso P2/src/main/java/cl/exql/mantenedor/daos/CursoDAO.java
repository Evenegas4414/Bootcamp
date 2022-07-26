package cl.exql.mantenedor.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.mantenedor.entidades.CursoDTO;
import cl.exql.mantenedor.utilidades.DatosConnexion;

public class CursoDAO {
	
	final String URL = DatosConnexion.URL;
	final String USER = DatosConnexion.USER;
	final String PASS = DatosConnexion.PASS;
	String consultaSql = "SELECT * FROM curso";

	public List<CursoDTO> obtieneCursos() throws SQLException, ClassNotFoundException {

		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DriverManager.getConnection(URL, USER, PASS);

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(consultaSql);
			while (rs.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(rs.getString(1));
				cursoDto.setDescripcion(rs.getString(2));
				cursoDto.setPrecio(rs.getDouble(3));
				listaDeCursos.add(cursoDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeCursos;
	}
}