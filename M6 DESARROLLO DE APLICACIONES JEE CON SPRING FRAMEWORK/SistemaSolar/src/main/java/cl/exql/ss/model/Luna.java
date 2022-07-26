package cl.exql.ss.model;

public class Luna implements ILuna {

	private String nombre;
	private Double diametro;
	private Double tiempoOrbita;

	public Luna() {
	}

	public Luna(String nombre, Double diametro, Double tiempoOrbita) {
		this.nombre = nombre;
		this.diametro = diametro;
		this.tiempoOrbita = tiempoOrbita;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getDiametro() {
		return diametro;
	}

	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}

	public Double getTiempoOrbita() {
		return tiempoOrbita;
	}

	public void setTiempoOrbita(Double tiempoOrbita) {
		this.tiempoOrbita = tiempoOrbita;
	}

	@Override
	public String toString() {

		return "Luna de nombre" + nombre + " que mide " + diametro + " km de diámetro y el tiempo de órbita es de "
				+ tiempoOrbita + " días.";
	}

}
