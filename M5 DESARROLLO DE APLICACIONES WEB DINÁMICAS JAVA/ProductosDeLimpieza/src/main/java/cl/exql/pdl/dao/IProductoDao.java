package cl.exql.pdl.dao;

import java.util.List;

import cl.exql.pdl.modelo.Producto;

public interface IProductoDao {
	
	public List<Producto> listarProductos();
	public Producto obtenerProducto(int idProducto);
	public boolean agregarProducto(Producto p);
	public boolean modificarProducto(Producto p);
	public boolean eliminarProducto(int idProducto);

}