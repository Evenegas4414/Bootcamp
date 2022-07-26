package cl.exql.generadorfactura.modelo;

import java.io.Serializable;

public class Item implements Serializable{
	
	private static final long serialVersionUID = -476539350824206029L;
	
	private Producto producto;
	private int cantidad;
	
	public Item(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Item [producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	

}
