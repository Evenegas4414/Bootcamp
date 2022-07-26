
public class MiniBus extends Bus {

	private String tipoViaje;

	public MiniBus() {
		
	}
	
	public MiniBus(String color, String patente, int cantidadDeAsientos, String tipoViaje) {
		super(color, patente, cantidadDeAsientos);
		this.tipoViaje = tipoViaje;
	}

	public void imprimeBus() {
		toString();
	}

	public String getTipoViaje() {
		return tipoViaje;
	}

	void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}

	@Override
	public String toString() {
		return "MiniBus [tipoViaje=" + tipoViaje + ", cantidadDeAsientos=" + cantidadDeAsientos
				+ ", asientosDisponibles=" + asientosDisponibles + ", color=" + color + ", patente=" + patente + "]";
	}

}
