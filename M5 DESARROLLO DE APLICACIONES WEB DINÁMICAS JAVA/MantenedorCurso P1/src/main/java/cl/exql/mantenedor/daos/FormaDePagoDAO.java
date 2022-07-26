package cl.exql.mantenedor.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.mantenedor.entidades.FormaDePagoDTO;

public class FormaDePagoDAO {

	final String URL = "jdbc:oracle:thin:@//localhost:1521/orcl";
	final String USER = "c##exequiel";
	final String PASS = "admin";
	String consultaSql = "SELECT id_forma_pago, descripcion, recargo FROM forma_pago";

	public List<FormaDePagoDTO> obtieneFormasDePago() throws SQLException, ClassNotFoundException {

		List<FormaDePagoDTO> listaDeCursos = new ArrayList<FormaDePagoDTO>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		conn = DriverManager.getConnection(URL, USER, PASS);

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(consultaSql);
			while (rs.next()) {
				FormaDePagoDTO formaPago = new FormaDePagoDTO();
				formaPago.setIdFormaDePago(rs.getString("id_forma_pago"));
				formaPago.setDescripcion(rs.getString("descripcion"));
				formaPago.setRecargo(rs.getString("recargo"));
				listaDeCursos.add(formaPago);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaDeCursos;
	}
}