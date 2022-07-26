package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import servicio.ExportarTxt;
import servicio.ProductoServicio;
import utilidades.Utilidad;
import vista.Menu;

public class Main {
	static ExportarTxt exportarTxt = new ExportarTxt();

	public static void main(String[] args) {
		int i = 0;

		do {
			Utilidad.limpiarConsola();
			Menu.imprimirMenuPrincipal();
			try {
				i = Menu.sc.nextInt();
				Utilidad.limpiarConsola();
				if (i > 0 && i < 5) {
					switch (i) {
					case 1:
						ProductoServicio.listarProductos();
						Utilidad.esperar(4000);
						Utilidad.limpiarConsola();
						break;
					case 2:
						ProductoServicio.agregarProducto();
						Utilidad.esperar();
						Utilidad.limpiarConsola();
						break;
					case 3:
						exportarTxt.confirmarExportacion();
						Utilidad.esperar();
						Utilidad.limpiarConsola();
						break;
					case 4:
						Menu.salir();
						Utilidad.esperar();
						Utilidad.limpiarConsola();
						break;
					default:
					}
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
		} while (i != 4);
	}
}
