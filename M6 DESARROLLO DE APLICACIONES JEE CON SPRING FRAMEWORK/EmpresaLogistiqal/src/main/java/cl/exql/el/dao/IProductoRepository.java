package cl.exql.el.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.exql.el.model.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("FROM Producto WHERE nombre LIKE %?1% ORDER BY id_producto")
	public ArrayList<Producto> findByName(String nombre);
	
	@Query("FROM Producto ORDER BY id_producto")
    public ArrayList<Producto> findAllByOrderByIdAsc();

}
