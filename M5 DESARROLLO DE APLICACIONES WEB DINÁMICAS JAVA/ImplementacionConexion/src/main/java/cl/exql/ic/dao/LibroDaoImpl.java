package cl.exql.ic.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import cl.exql.ic.conexion.AdministradorConexion;
import cl.exql.ic.modelo.Libro;

public class LibroDaoImpl extends AdministradorConexion implements ILibroDao {

	public LibroDaoImpl() {
		conn = generaConexion();
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
