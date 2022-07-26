import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LibroVenta {

	String nombreVenta;
	String fechaVenta;

	public LibroVenta(String nombreVenta, String fechaVenta) {
		this.nombreVenta = nombreVenta;
		this.fechaVenta = fechaVenta;
	}

	public String getNombreVenta() {
		return nombreVenta;
	}

	void setNombreVenta(String nombreVenta) {
		this.nombreVenta = nombreVenta;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public void guardarVenta(Cliente cliente, Vehiculo vehiculo) {
		ArrayList<String> datosVenta = new ArrayList<String>();
		datosVenta.add("Patente: " + vehiculo.patente);
		datosVenta.add("Edad de Cliente: " + cliente.edad);
		datosVenta.add("Fecha de la venta: " + fechaVenta);
		datosVenta.add("Nombre de venta: " + nombreVenta);
		
		
		File miDirectorio = new File("src/ficheros");
		File miArchivo = new File("src/ficheros/" + nombreVenta + ".txt");
		if (miDirectorio.exists() == false) {
			miDirectorio.mkdir();
		} else {
			System.out.println("Error al crear directorio.");
			System.out.println("El directorio ya existe.");
		}

		if (miArchivo.exists() == false) {
			try {
				miArchivo.createNewFile();
			} catch (IOException e) {
				System.out.println("Error al crear archivo.");
				System.out.println("Error: " + e);
			}
		} else {
			System.out.println("Error al crear archivo.");
			System.out.println("El archivo ya existe.");
		}
		
		try {
			FileWriter fw = new FileWriter(miArchivo);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (String dato : datosVenta) {				
				bw.write(dato);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir archivo.");
			System.out.println("Error: " + e);
		}
	}
}
