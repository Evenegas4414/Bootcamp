package cl.exql.mantenedor.entidades;

public class InscripcionDTO {
	
	private int idInsc;
	private String nombre;
	private int celular;
	private String idCurso;
	private String idFormaDePago;

	public int getIdInsc() {
		return idInsc;
	}

	public void setIdInsc(int idInsc) {
		this.idInsc = idInsc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(String idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}
}