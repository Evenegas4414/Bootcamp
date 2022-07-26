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
import cl.exql.mantenedor.utilidades.DatosConnexion;

public class InscripcionDAO {

	final String URL = DatosConnexion.URL;
	final String USER = DatosConnexion.USER;
	final String PASS = DatosConnexion.PASS;
	String insertarInscripcion = "INSERT INTO inscripcion VALUES (inscripcion_seq.nextval,?,?,?,?)";
	String consultaSql = "SELECT * FROM inscripcion ORDER BY id_inscripcion";

	public boolean insertarInscripcion(InscripcionDTO dto) throws SQLException, ClassNotFoundException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DriverManager.getConnection(URL, USER, PASS);

		try {
			pstmt = conn.prepareStatement(insertarInscripcion);
			pstmt.setString(1, dto.getNombre());
			pstmt.setString(2, dto.getTelefono());
			pstmt.setString(3, dto.getIdCurso());
			pstmt.setString(4, dto.getIdFormaPago());
			if (pstmt.executeUpdate() != 1) {
				throw new RuntimeException("Error: No se ha podido ingresar la inscripcion");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error: " + e);
		}
		return true;
	}

	public List<InscripcionDTO> obtieneInscripciones() throws SQLException, ClassNotFoundException {

		List<InscripcionDTO> listaDeInscripcion = new ArrayList<InscripcionDTO>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DriverManager.getConnection(URL, USER, PASS);

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(consultaSql);
			while (rs.next()) {
				InscripcionDTO inscripcionDto = new InscripcionDTO();
				inscripcionDto.setIdInscripcion(rs.getInt(1));
				inscripcionDto.setNombre(rs.getString(2));
				inscripcionDto.setTelefono(rs.getString(3));
				inscripcionDto.setIdCurso(rs.getString(4));
				inscripcionDto.setIdFormaPago(rs.getString(5));
				listaDeInscripcion.add(inscripcionDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeInscripcion;
	}
}
