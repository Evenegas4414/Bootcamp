package cl.exql.mantenedor.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.mantenedor.entidades.FormaPagoDTO;
import cl.exql.mantenedor.utilidades.DatosConnexion;

public class FormaPagoDAO {

	final String URL = DatosConnexion.URL;
	final String USER = DatosConnexion.USER;
	final String PASS = DatosConnexion.PASS;
	String consultaSql = "SELECT * FROM forma_pago";

	public List<FormaPagoDTO> obtieneFormasDePago() throws SQLException, ClassNotFoundException {

		List<FormaPagoDTO> listaFormaPago = new ArrayList<FormaPagoDTO>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		conn = DriverManager.getConnection(URL, USER, PASS);

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(consultaSql);
			while (rs.next()) {
				FormaPagoDTO formaPago = new FormaPagoDTO();
				formaPago.setIdFormaPago(rs.getString(1));
				formaPago.setDescripcion(rs.getString(2));
				formaPago.setRecargo(rs.getString(3));
				listaFormaPago.add(formaPago);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaFormaPago;
	}
}