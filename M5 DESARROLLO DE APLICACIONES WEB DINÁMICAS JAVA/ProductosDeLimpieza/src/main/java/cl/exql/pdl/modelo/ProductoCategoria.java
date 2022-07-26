package cl.exql.pdl.modelo;

public class ProductoCategoria {

	private Producto producto;
	private Categoria categoria;

	public ProductoCategoria() {
	}

	public ProductoCategoria(Producto producto, Categoria categoria) {
		this.producto = producto;
		this.categoria = categoria;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductoCategoria [producto=" + producto + ", categoria=" + categoria + "]";
	}
}