package cl.exql.ip.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class PoolConexiones {

	protected static Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	protected Context context = null;
	
	

	protected Connection crearPoolConexion() {		
		
		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/WebLibros");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	protected Connection generaPoolConexion() {
		
		if (conn == null) {
			conn = crearPoolConexion();
			return conn;
		} else {
			return conn;
		}
	}
}