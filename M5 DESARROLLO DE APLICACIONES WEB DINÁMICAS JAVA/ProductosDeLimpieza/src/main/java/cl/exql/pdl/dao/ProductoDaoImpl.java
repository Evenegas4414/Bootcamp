package cl.exql.pdl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.exql.pdl.conexion.Conexiones;
import cl.exql.pdl.modelo.Producto;

public class ProductoDaoImpl extends Conexiones implements IProductoDao {

	private final String SQL_LISTAR = "SELECT * FROM producto ORDER BY id_producto";	
	private final String SQL_OBTENER = "SELECT * FROM producto WHERE id_producto = ?";
	private final String SQL_AGREGAR = "INSERT INTO producto VALUES ( producto_seq.nextval, ?, ?, ?, ?)";
	private final String SQL_MODIFICAR = "UPDATE producto SET nombre_producto = ?, precio_producto = ?, "
			+ "descripcion_producto = ? , id_categoria = ? WHERE id_producto = ?";
	private final String SQL_ELIMINAR = "DELETE FROM producto WHERE id_producto = ?";
	
	
	@Override
	public List<Producto> listarProductos() {
		
		List<Producto> listaProductos = new ArrayList<Producto>();		
		conn = generaConexion();
		
		try ( Statement stmt = conn.createStatement()){
			rs = stmt.executeQuery(SQL_LISTAR);
			while (rs.next()) {
				Producto p = new Producto();
				p.setIdProducto(rs.getInt("id_producto"));
				p.setNombreProducto(rs.getString("nombre_producto"));
				p.setPrecioProducto(rs.getInt("precio_producto"));
				p.setDescripcionProducto(rs.getString("descripcion_producto"));
				p.setIdCategoria(rs.getInt("id_categoria"));
				listaProductos.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return listaProductos;
	}

	@Override
	public Producto obtenerProducto(int idProducto) {
		
		Producto p = new Producto();
		conn = generaConexion();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(SQL_OBTENER)) {
			pstmt.setInt(1, idProducto);
			rs = pstmt.executeQuery();			
			if (rs.next()) {
				p.setIdProducto(rs.getInt("id_producto"));
				p.setNombreProducto(rs.getString("nombre_producto"));
				p.setPrecioProducto(rs.getInt("precio_producto"));
				p.setDescripcionProducto(rs.getString("descripcion_producto"));
				p.setIdCategoria(rs.getInt("id_categoria"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return p;
	}

	@Override
	public boolean agregarProducto(Producto p) {
		
		conn = generaConexion();
		
		try (PreparedStatement pstmt = conn.prepareStatement(SQL_AGREGAR)) {
			pstmt.setString(1, p.getNombreProducto());
			pstmt.setInt(2, p.getPrecioProducto());
			pstmt.setString(3, p.getDescripcionProducto());
			pstmt.setInt(4, p.getIdCategoria());			
			pstmt.executeUpdate();		
		} catch (SQLException e) {
			e.printStackTrace();
			return false; 
		}		
		return true;
	}

	@Override
	public boolean modificarProducto(Producto p) {
		
		conn = generaConexion();
		
		try (PreparedStatement pstmt = conn.prepareStatement(SQL_MODIFICAR)) {
			pstmt.setString(1, p.getNombreProducto());
			pstmt.setInt(2, p.getPrecioProducto());
			pstmt.setString(3, p.getDescripcionProducto());
			pstmt.setInt(4, p.getIdCategoria());
			pstmt.setInt(5, p.getIdProducto());
			if (pstmt.executeUpdate() == 1) {
				return true;
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public boolean eliminarProducto(int idProducto) {
		
		conn = generaConexion();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(SQL_ELIMINAR)) {
			pstmt.setInt(1, idProducto);
			if (pstmt.executeUpdate() == 1) {
				return true;
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}