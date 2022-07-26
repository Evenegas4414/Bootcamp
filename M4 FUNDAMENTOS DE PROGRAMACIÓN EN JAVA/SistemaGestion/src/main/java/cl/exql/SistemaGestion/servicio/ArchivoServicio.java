package cl.exql.SistemaGestion.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import cl.exql.SistemaGestion.modelo.Cliente;
import cl.exql.SistemaGestion.utilidades.Utilidad;

public class ArchivoServicio extends Exportador {

	Scanner scanner = new Scanner(System.in);

	public boolean cargarDatos(String fileName) {
		
		// El archivo se encuentra en src/main/java/cl/exql/SistemaGestion/resources
		File miArchivoTexto = new File(fileName + "/DBClientes.csv");
		if (miArchivoTexto.exists()) {
			try {
				FileReader fr = new FileReader(miArchivoTexto);
				BufferedReader br = new BufferedReader(fr);
				String miLinea = "";
				while ((miLinea = br.readLine()) != null) {
					String[] atributosCliente = miLinea.split(",");
					Cliente miNuevoCliente = new Cliente(atributosCliente[0], atributosCliente[1], atributosCliente[2],
							atributosCliente[3]);
					ClienteServicio.listaClientes.add(miNuevoCliente);
				}
				Utilidad.limpiarConsola();
				System.out.print("Datos cargados correctamente en la lista");
				br.close();
				return true;
			} catch (Exception e) {
				Utilidad.limpiarConsola();
				System.out.print("Error al leer archivo");
				return true;
			}
		} else {
			Utilidad.limpiarConsola();
			System.out.print("No se encuentra el archivo");
		}
		return false;
	}

	public void confirmarImportar() {
		System.out.print("---------Cargar Datos en ");
		if (System.getProperty("os.name").contains("Win")) {
			System.out.println("Windows---------------");
		} else {
			System.out.println("Linux o Mac-----------");
		}
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		String fileName = scanner.nextLine();
		cargarDatos(fileName);
	}

	@Override
	public void exportar() {
	}
}
