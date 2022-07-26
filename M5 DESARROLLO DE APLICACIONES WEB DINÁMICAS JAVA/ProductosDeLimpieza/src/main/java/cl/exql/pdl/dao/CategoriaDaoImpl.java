package cl.exql.pdl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.pdl.conexion.Conexiones;
import cl.exql.pdl.modelo.Categoria;

public class CategoriaDaoImpl extends Conexiones implements ICategoriaDao {

	private final String SQL_LISTAR = "SELECT * FROM categoria ORDER BY id_categoria";
	private final String SQL_OBTENER = "SELECT * FROM categoria WHERE id_categoria = ?";
	private final String SQL_AGREGAR = "INSERT INTO categoria VALUES ( categoria_seq.nextval, ?)";
	private final String SQL_MODIFICAR = "UPDATE categoria SET nombre_categoria = ? WHERE id_categoria = ?";
	private final String SQL_ELIMINAR = "DELETE FOM categoria WHERE id_categoria = ?";

	@Override
	public List<Categoria> listarCategorias() {

		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		conn = generaConexion();

		try (Statement stmt = conn.createStatement()) {
			rs = stmt.executeQuery(SQL_LISTAR);
			while 
				(rs.next()) {
				Categoria c = new Categoria();
				c.setIdCategoria(rs.getInt("id_categoria"));
				c.setNombreCategoria(rs.getString("nombre_categoria"));
				listaCategorias.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCategorias;
	}

	@Override
	public Categoria obtenerCategoria(int idCategoria) {

		Categoria c = new Categoria();
		conn = generaConexion();

		try (PreparedStatement pstmt = conn.prepareStatement(SQL_OBTENER)) {
			pstmt.setInt(1, idCategoria);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				c.setIdCategoria(rs.getInt("id_categoria"));
				c.setNombreCategoria(rs.getString("nombre_categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean agregarCategoria(Categoria c) {

		conn = generaConexion();

		try (PreparedStatement pstmt = conn.prepareStatement(SQL_AGREGAR)) {
			pstmt.setString(1, c.getNombreCategoria());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean modificarCategoria(Categoria c) {

		conn = generaConexion();

		try (PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFICAR)) {
			pstmt.setString(1, c.getNombreCategoria());
			pstmt.setInt(2, c.getIdCategoria());
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean eliminarCategoria(int idCategoria) {

		conn = generaConexion();

		try (PreparedStatement pstmt = conn.prepareStatement(SQL_ELIMINAR)) {
			pstmt.setInt(1, idCategoria);
			if (pstmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}