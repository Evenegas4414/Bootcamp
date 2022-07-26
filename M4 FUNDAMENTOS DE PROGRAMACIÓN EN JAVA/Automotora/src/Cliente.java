
public class Cliente extends Persona {
	
	public Cliente() {
		
	}

	public Cliente(String rut, String nombre, int edad) {
		super(rut, nombre, edad);
	}

	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
}
