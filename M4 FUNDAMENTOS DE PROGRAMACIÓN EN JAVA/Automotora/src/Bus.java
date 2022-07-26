
public class Bus extends Vehiculo {

	protected int cantidadDeAsientos;
	protected int asientosDisponibles;
	
	public Bus() {
		
	}

	public Bus(String color, String patente, int cantidadDeAsientos) {
		super(color, patente);
		this.cantidadDeAsientos = cantidadDeAsientos;
		this.asientosDisponibles = cantidadDeAsientos;
	}

	public int asientosDisponibles() {
		return asientosDisponibles;
	}

	public void ocuparAsientos(int ocupados) {
		asientosDisponibles -= ocupados;
	}

	public void desocuparAsientos(int desocupados) {
		if ((asientosDisponibles += desocupados) > cantidadDeAsientos) {
			System.out.println("No puede haber más asientos");
		} else {
			asientosDisponibles -= desocupados;
		}
	}

	public int getCantidadDeAsientos() {
		return cantidadDeAsientos;
	}

	void setCantidadDeAsientos(int cantidadDeAsientos) {
		this.cantidadDeAsientos = cantidadDeAsientos;
	}

}
