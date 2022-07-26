
public class Taxi extends Vehiculo {

	private int valorPasaje;
	
	public Taxi() {
		
	}

	public Taxi(String color, String patente, int valorPasaje) {
		super(color, patente);
		this.valorPasaje = valorPasaje;
	}

	public int getValorPasaje() {
		return valorPasaje;
	}

	void setValorPasaje(int valorPasaje) {
		this.valorPasaje = valorPasaje;
	}

	public int pagarPasaje(int monto) {
		if (monto >= valorPasaje) {
			return monto - valorPasaje;
		} else {
			return monto;
		}
	}
	
	@Override
	public String toString() {
		return "Taxi [valorPasaje=" + valorPasaje + ", color=" + color + ", patente=" + patente + "]";
	}
}
