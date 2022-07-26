package cl.exql.el.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.exql.el.dao.IProductoRepository;
import cl.exql.el.model.Producto;
import cl.exql.el.service.IProductoService;
import cl.exql.el.vo.ProductoVO;

@Service
public class ProductoServiceImpl implements IProductoService {

	private static final Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);

	@Autowired
	IProductoRepository productoRepository;

	ProductoVO respuesta;

	@Override
	@Transactional(readOnly = true)
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Error: No se ha podido obtener la lista de productos.",
				"E101");
		try {
			List<Producto> productos = (ArrayList<Producto>) productoRepository.findAllByOrderByIdAsc();
			if (productos.size() > 0) {
				respuesta.setProductos(productos);
				respuesta.setMensaje("Se ha podido obtener la lista de productos.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("La lista está vacia. No hay registros.");
				respuesta.setCodigo("0");
			}
		} catch (Exception e) {
			log.error("Error 101: No se ha podido obtener la lista de productos.");
			System.err.println(e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findByNombre(String textoBuscado) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Error: No se ha podido buscar en la lista.", "E102");
		try {
			List<Producto> productos = productoRepository.findByName(textoBuscado);
			if (productos.size() > 0) {
				respuesta.setProductos(productos);
				respuesta.setMensaje("Se ha podido encontrar en la lista.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("No se ha encontrado coincidencias en la lista.");
				respuesta.setCodigo("0");
			}
		} catch (Exception e) {
			log.error("Error 102: No se ha podido buscar en la lista.");
			System.err.println(e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO add(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Error: No se ha podido agregar el producto.", "E103");
		try {
			productoRepository.save(producto);
			respuesta.setMensaje("Se ha podido agregar el producto.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.error("Error 103: No se ha podido agregar el producto.");
			System.err.println(e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO update(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Error: No se ha podido actualizar el producto.", "E104");
		try {
			productoRepository.save(producto);
			respuesta.setMensaje("Se ha podido actualizar el producto.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.error("Error 104: No se ha podido actualizar el producto.");
			System.err.println(e);
		}
		return respuesta;
	}

	@Override
	@Transactional
	public ProductoVO delete(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Error: No se ha podido eliminar el producto.", "E105");
		try {
			productoRepository.delete(producto);
			respuesta.setMensaje("Se ha podido eliminar el producto.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.error("Error 105: No se ha podido eliminar el producto.");
			System.err.println(e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findById(Integer idProducto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Error: No se ha podido buscar en la lista.", "E102");
		try {
			Producto producto = productoRepository.findById(idProducto).get();
			respuesta.getProductos().add(producto);
			respuesta.setMensaje("Se ha encontrado en la lista.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.error("Error 102: No se ha podido buscar en la lista.");
			System.err.println(e);
		}
		return respuesta;
	}

}
