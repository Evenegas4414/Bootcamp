package cl.exql.mantenedor.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.mantenedor.entidades.CursoDTO;

public class CursoDAO {
	
	final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
	final String USER = "c##exequiel";
	final String PASS = "admin";
	String consultaSql = "SELECT id_curso, descripcion, precio FROM curso";

	public List<CursoDTO> obtieneCursos() throws SQLException, ClassNotFoundException {

		List<CursoDTO> listaDeCursos = new ArrayList<CursoDTO>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USER, PASS);

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(consultaSql);
			while (rs.next()) {
				CursoDTO cursoDto = new CursoDTO();
				cursoDto.setIdCurso(rs.getString("id_curso"));
				cursoDto.setDescricion(rs.getString("descripcion"));
				cursoDto.setPrecio(rs.getDouble("precio"));
				listaDeCursos.add(cursoDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeCursos;
	}
}