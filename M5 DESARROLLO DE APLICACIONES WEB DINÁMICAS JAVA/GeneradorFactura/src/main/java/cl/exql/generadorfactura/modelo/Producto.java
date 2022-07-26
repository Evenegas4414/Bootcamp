package cl.exql.generadorfactura.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
	
	private static final long serialVersionUID = -8946748422870663336L;
	
	String item;
	String descripcion;
	int valor;

	public Producto() {
		this.item = "Sin datos";
		this.descripcion = "Sin datos";
		this.valor = 0;
	}

	public Producto(String item, String descripcion, int valor) {
		this.item = item;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [item=" + item + ", descripcion=" + descripcion + ", valor=" + valor + "]";
	}
	

}
