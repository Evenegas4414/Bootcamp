package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Producto;
import utilidades.Utilidad;
import vista.Menu;

public class ExportarTxt extends ExportadorTxt {
	static String ruta = "";

	public void exportar() {
		File miArchivo = new File(ruta + "/clientes.txt");
		miArchivo.getParentFile().mkdirs();
		if (miArchivo.exists() == false) {
			try {
				miArchivo.createNewFile();
				try {
					FileWriter fw = new FileWriter(miArchivo);
					BufferedWriter bw = new BufferedWriter(fw);
					if (ProductoServicio.listaProductos.size() != 0) {
						for (Producto p : ProductoServicio.listaProductos) {
							bw.write("Datos del Producto: ");
							bw.newLine();
							bw.write("Nombre articulo: " + p.getArticulo());
							bw.newLine();
							bw.write("Código: " + p.getCodigo());
							bw.newLine();
							bw.write("Marca: " + p.getMarca());
							bw.newLine();
							bw.write("Color: " + p.getColor());
							bw.newLine();
							bw.write("Descripción: " + p.getDescripcion());
							bw.newLine();
							bw.write("Precio: " + p.getPrecio());
							bw.newLine();
							bw.write("Talla: " + p.getTalla());
							bw.newLine();
							bw.newLine();
						}
						System.out.println("\nDatos de clientes exportados correctamente en formato .txt");
						System.out.println("Exportados en: " + miArchivo.getAbsolutePath());
					} else {
						System.out.println("No hay productos en la lista para exportar");
					}
					bw.close();
				} catch (IOException e) {
					System.out.println("Error al escribir archivo.");
					System.out.println("Error: " + e);
				}
			} catch (IOException e) {
				System.out.println("Error al crear archivo.");
				System.out.println("Error: " + e);
			}
		} else {
			System.out.println("Error al crear archivo.");
			System.out.println("El archivo ya existe.");
		}
	}

	public void confirmarExportacion() {
		System.out.println("Exportar Datos ");
		System.out.print("Ingrese la opción 1 para exportar: ");
		try {
			if (Menu.sc.nextInt() == 1) {
				System.out.println("Exportar Datos ");
				System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
				Menu.sc.nextLine();
				ruta = Menu.sc.nextLine();
				exportar();
			} else {
				Menu.sc.nextLine();
				Utilidad.limpiarConsola();
				System.out.print("Opción no valida.");
				Utilidad.esperar();
			}
		} catch (InputMismatchException e) {
			Menu.sc.nextLine();
			Utilidad.limpiarConsola();
			System.out.print("Opción no valida.");
			Utilidad.esperar();
		}
	}
}
