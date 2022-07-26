
public class Cliente {

	protected String rut;
	protected String nombre;
	protected int edad;

	public Cliente(String rut, String nombre, int edad) {
		this.rut = rut;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getRut() {
		return rut;
	}

	void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	void setEdad(int edad) {
		this.edad = edad;
	}

}
