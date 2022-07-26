package cl.exql.SistemaGestion.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import cl.exql.SistemaGestion.modelo.Cliente;
import cl.exql.SistemaGestion.utilidades.Utilidad;


public class ExportadorCsv extends Exportador {

	Scanner scanner = new Scanner(System.in);
	public File miArchivo;
	
	@Override
	public void exportar() {
		Utilidad.limpiarConsola();
		System.out.print("---------Cargar Datos en ");
		if (System.getProperty("os.name").contains("Win")) {
			System.out.println("Windows---------------");
		} else {
			System.out.println("Linux o Mac-----------");
		}
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv: ");
		String ruta = scanner.nextLine();

		miArchivo = new File(ruta + "/clientes.csv");
		miArchivo.getParentFile().mkdirs();
		if (miArchivo.exists() == false) {
			try {
				miArchivo.createNewFile();
				try {
					FileWriter fw = new FileWriter(miArchivo);
					BufferedWriter bw = new BufferedWriter(fw);
					if (ClienteServicio.listaClientes.size() != 0) {
						for (Cliente c : ClienteServicio.listaClientes) {
							bw.write(c.getRunCliente());
							bw.write(",");
							bw.write(c.getNombreCliente());
							bw.write(",");
							bw.write(c.getApellidoCliente());
							bw.write(",");
							bw.write(c.getAniosCliente());
							bw.write(",");
							bw.write(c.getNombreCategoria().getEstado());
							bw.newLine();
						}
						Utilidad.limpiarConsola();
						System.out.println("Datos de clientes exportados correctamente en formato .csv");
						System.out.print("Exportados en: " + miArchivo.getAbsolutePath());
					} else {
						System.out.print("No hay clientes en la lista para exportar");
					}
					bw.close();
				} catch (IOException e) {
					Utilidad.limpiarConsola();
					System.out.println("Error al escribir archivo.");
					System.out.print("Error: " + e);
				}
			} catch (IOException e) {
				Utilidad.limpiarConsola();
				System.out.println("Error al crear archivo.");
				System.out.print("Error: " + e);
			}
		} else {
			Utilidad.limpiarConsola();
			System.out.println("Error al crear archivo.");
			System.out.print("El archivo ya existe.");
		}
	}
}
