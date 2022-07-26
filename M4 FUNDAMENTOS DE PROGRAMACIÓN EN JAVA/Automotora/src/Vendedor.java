
public class Vendedor extends Persona {

	String direccion;
	
	public Vendedor() {
		
	}

	public Vendedor(String rut, String nombre, int edad, String direccion) {
		super(rut, nombre, edad);
		this.direccion = direccion;
	}

	public String getDireccion() {
		return direccion;
	}

	void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Vendedor [direccion=" + direccion + ", rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
}
