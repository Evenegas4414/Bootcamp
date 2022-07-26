package cl.exql.el.service;

import cl.exql.el.model.Producto;
import cl.exql.el.vo.ProductoVO;

public interface IProductoService {
	
	public ProductoVO getAllProductos();
	public ProductoVO findById(Integer idProducto);
	public ProductoVO findByNombre(String textoBuscado);	
	public ProductoVO add(Producto producto);
	public ProductoVO update(Producto producto);
	public ProductoVO delete(Producto producto);

}
