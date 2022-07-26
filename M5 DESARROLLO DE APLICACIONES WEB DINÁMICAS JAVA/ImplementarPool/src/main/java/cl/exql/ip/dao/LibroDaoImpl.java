package cl.exql.ip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import cl.exql.ip.conexion.PoolConexiones;
import cl.exql.ip.modelo.Libro;

public class LibroDaoImpl extends PoolConexiones implements ILibroDao {

	public LibroDaoImpl() {
		conn = generaPoolConexion();
	}

	@Override
	public ArrayList<Libro> listarLibros() {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		final String SQL = "SELECT * FROM libro";
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Libro libroTemp = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3));
				listaLibros.add(libroTemp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaLibros;
	}
}
