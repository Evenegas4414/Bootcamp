package cl.exql.ic.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorConexion {

	protected static Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	protected Connection crearConexion() {
		
		final String usuario = "c##exequiel";
		final String contrasena = "admin";
		final String driver = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, contrasena);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	protected Connection generaConexion() {
		if (conn == null) {
			conn = crearConexion();
			return conn;
		} else {
			return conn;
		}
	}
}