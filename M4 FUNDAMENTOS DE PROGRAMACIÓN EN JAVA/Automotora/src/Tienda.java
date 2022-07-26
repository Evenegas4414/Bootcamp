
public class Tienda {

	Vendedor vendedor;
	//Se declara Vehiculo y se usa polimorfismo para instanciar Taxi, Bus y MiniBus
	Vehiculo vehiculo;
	int stock; 
	
	public Tienda() {
		
	}
	
	public Tienda(Vendedor vendedor, Vehiculo vehiculo, int stock) {
		this.vendedor = vendedor;
		this.vehiculo = vehiculo;
		this.stock = stock;
	}
	
	public String existeStock() {
		return "Cantidad de stock es " + stock;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getStock() {
		return stock;
	}

	void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Tienda [vendedor=" + vendedor + ", vehiculo=" + vehiculo + ", stock=" + stock + "]";
	}
}
