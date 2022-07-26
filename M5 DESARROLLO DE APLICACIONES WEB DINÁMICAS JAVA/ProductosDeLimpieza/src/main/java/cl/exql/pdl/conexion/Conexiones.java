package cl.exql.pdl.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexiones {

	protected static Connection conn = null;
	protected ResultSet rs = null;
	protected Context context = null;
	
	private static final String usuario = "c##limpieza";
	private static final String contrasena = "admin";
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@//localhost:1521/orcl";

	private Connection crearConexion() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, contrasena);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	@SuppressWarnings("unused")
	private Connection crearPoolConexion() {

		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/WebLimpieza");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	protected Connection generaConexion() {
		if (conn == null) {
			conn = crearConexion();			
		}
		return conn;
	}
}