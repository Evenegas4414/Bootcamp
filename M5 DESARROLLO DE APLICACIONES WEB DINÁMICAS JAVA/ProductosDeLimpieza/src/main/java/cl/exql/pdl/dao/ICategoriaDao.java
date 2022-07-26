package cl.exql.pdl.dao;

import java.util.List;

import cl.exql.pdl.modelo.Categoria;

public interface ICategoriaDao {
	
	public List<Categoria> listarCategorias();
	public Categoria obtenerCategoria(int idCategoria);
	public boolean agregarCategoria(Categoria c);
	public boolean modificarCategoria(Categoria c);
	public boolean eliminarCategoria(int idCategoria);

}