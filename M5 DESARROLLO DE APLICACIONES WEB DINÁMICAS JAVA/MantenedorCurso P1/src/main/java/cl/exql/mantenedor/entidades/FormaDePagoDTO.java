package cl.exql.mantenedor.entidades;

public class FormaDePagoDTO {
	
	private String idFormaDePago;
	private String descripcion;
	private String recargo;

	public String getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(String idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRecargo() {
		return recargo;
	}

	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}
}