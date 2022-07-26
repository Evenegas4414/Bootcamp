package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import modelo.Producto;
import utilidades.Utilidad;
import vista.Menu;

public class ArchivoServicio {
	static String ruta = "";

	public static void cargarDatos(String ruta) {		
		//El archivo se encuentra en src/apoyodesafio/ProductosImportados.csv
		File miArchivoTexto = new File(ruta + "/ProductosImportados.csv");		
		if (miArchivoTexto.exists()) {
			try {

				FileReader fr = new FileReader(miArchivoTexto);
				BufferedReader br = new BufferedReader(fr);
				String miLinea = "";
				while ((miLinea = br.readLine()) != null) {

					String[] atributosProducto = miLinea.split(",");

					Producto miNuevoProducto = new Producto(atributosProducto[0], atributosProducto[1],
							atributosProducto[2], atributosProducto[3], atributosProducto[4], atributosProducto[5],
							atributosProducto[6]);

					ProductoServicio.listaProductos.add(miNuevoProducto);
				}
				Utilidad.limpiarConsola();
				System.out.print("Datos cargados correctamente en la lista");
				br.close();

			} catch (Exception e) {
				Utilidad.limpiarConsola();
				System.out.print("Error al leer archivo");
				Utilidad.esperar();
				
			}			
		} else {
			Utilidad.limpiarConsola();
			System.out.print("No se encuentra el archivo");
			Utilidad.esperar();
			
		}
		
	}

	public static void confirmarImportar() {
		System.out.println("Cargar Datos");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo");
		System.out.println("ProductosImportados.csv:");
		Menu.sc.nextLine();
		ruta = Menu.sc.nextLine();
		ArchivoServicio.cargarDatos(ruta);		
	}
}
