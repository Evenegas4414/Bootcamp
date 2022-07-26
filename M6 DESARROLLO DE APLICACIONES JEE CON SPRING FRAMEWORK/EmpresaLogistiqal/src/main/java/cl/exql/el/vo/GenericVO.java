package cl.exql.el.vo;

public class GenericVO {

	private String mensaje;
	private String codigo;

	public GenericVO() {
	}

	public GenericVO(String mensaje, String codigo) {
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "GeniricVO [mensaje=" + mensaje + ", codigo=" + codigo + "]";
	}

}
