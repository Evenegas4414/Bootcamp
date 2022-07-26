package cl.exql.mantenedor.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.mantenedor.entidades.InscripcionDTO;

public class InscripcionDAO {

	final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
	final String USER = "c##exequiel";
	final String PASS = "admin";
	String insertarInscripcion = "INSERT INTO inscripcion(idInsc, nombre, celular, idCurso, idFormaDePago)"
			+ " VALUES (inscripcion_sec.NEXTVAL, ?, ?, ?, ?)";
	String consultaSql = "SELECT * FROM inscripcion";

	public boolean insertarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USER, PASS);
		
		try ( PreparedStatement pstmt = conn.prepareStatement(insertarInscripcion);) {
				pstmt.setString(1, dto.getNombre());
				pstmt.setInt(2, dto.getCelular());
				pstmt.setString(3, dto.getIdCurso());
				pstmt.setString(4, dto.getIdFormaDePago());
				if (pstmt.executeUpdate() != 1) {
					throw new RuntimeException("Error: No se ha podido ingresar la inscripcion");
				}
			} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error: " + e);
		}
		return true;
	}
	
	// DESAFIO GUIADO REQUISITO 2
	
	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {
		
		List<InscripcionDTO> listaDeInscripcion = new ArrayList<InscripcionDTO>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USER, PASS);
		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(consultaSql);
			while (rs.next()) {
				InscripcionDTO inscripcionDto = new InscripcionDTO();
				inscripcionDto.setIdInsc(rs.getInt(1));
				inscripcionDto.setNombre(rs.getString(2));
				inscripcionDto.setCelular(rs.getInt(3));
				inscripcionDto.setIdCurso(rs.getString(4));
				inscripcionDto.setIdFormaDePago(rs.getString(5));
				listaDeInscripcion.add(inscripcionDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeInscripcion;		
	}
}
