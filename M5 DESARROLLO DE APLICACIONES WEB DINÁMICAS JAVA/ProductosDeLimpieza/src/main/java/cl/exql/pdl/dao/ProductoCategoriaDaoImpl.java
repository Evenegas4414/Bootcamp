package cl.exql.pdl.dao;

import java.util.ArrayList;
import java.util.List;

import cl.exql.pdl.conexion.Conexiones;
import cl.exql.pdl.modelo.Categoria;
import cl.exql.pdl.modelo.Producto;
import cl.exql.pdl.modelo.ProductoCategoria;

public class ProductoCategoriaDaoImpl extends Conexiones implements IProductoCategoriaDao {
	
	private IProductoDao productoDao = new ProductoDaoImpl();
	private ICategoriaDao categoriaDao = new CategoriaDaoImpl();

	@Override
	public List<ProductoCategoria> listarProductoCategoria() {				

			List<ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
			List<Producto> listaProductos = productoDao.listarProductos();

			for (Producto p : listaProductos) {
				Categoria c = categoriaDao.obtenerCategoria(p.getIdCategoria());
				ProductoCategoria pc = new ProductoCategoria();
				pc.setProducto(p);
				pc.setCategoria(c);
				listaProductoCategoria.add(pc);
			}
			return listaProductoCategoria;
	}
}