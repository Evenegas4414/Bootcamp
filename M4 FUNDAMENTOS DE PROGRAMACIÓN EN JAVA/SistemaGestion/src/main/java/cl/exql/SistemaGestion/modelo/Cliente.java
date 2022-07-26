package cl.exql.SistemaGestion.modelo;

public class Cliente {
	
	private int idCliente;
	private static int idSiguiente = 1;	
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	public Cliente() {
		this.idCliente = Cliente.idSiguiente;
		Cliente.idSiguiente++;
	}
	
	public Cliente( String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = CategoriaEnum.ACTIVO;
		this.idCliente = Cliente.idSiguiente;
		Cliente.idSiguiente++;
	}
	
	public Cliente( String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoriaEnum nombreCategoria) {
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
		this.idCliente = Cliente.idSiguiente;
		Cliente.idSiguiente++;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int id) {
		this.idCliente = id;
	}

	public static int getIdSiguiente() {
		return idSiguiente;
	}

	public static void setIdSiguiente(int idSiguiente) {
		Cliente.idSiguiente = idSiguiente;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String anioCliente) {
		this.aniosCliente = anioCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", runCliente=" + runCliente + ", nombreCliente=" + nombreCliente
				+ ", apellidoCliente=" + apellidoCliente + ", anioCliente=" + aniosCliente + ", nombreCategoria="
				+ nombreCategoria + "]";
	}
}
