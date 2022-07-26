package cl.exql.SistemaGestion.modelo;

public enum CategoriaEnum {
	ACTIVO ("Activo", true),
	INACTIVO ("Inactivo", false);
	
	private final String estado;
	private final boolean esActivo;
	
	CategoriaEnum(String estado, boolean esActivo) {
		this.estado = estado;
		this.esActivo = esActivo;
	}

	public String getEstado() {
		return estado;
	}

	public boolean isEsActivo() {
		return esActivo;
	}	
}