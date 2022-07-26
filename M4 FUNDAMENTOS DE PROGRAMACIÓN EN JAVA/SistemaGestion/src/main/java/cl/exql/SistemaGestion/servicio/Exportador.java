package cl.exql.SistemaGestion.servicio;

import java.util.InputMismatchException;
import java.util.Scanner;

import cl.exql.SistemaGestion.utilidades.Utilidad;

public abstract class Exportador {
	static Scanner scanner = new Scanner(System.in);
	static ExportadorCsv exportadorCsv = new ExportadorCsv();
	static ExportadorTxt exportadorTxt = new ExportadorTxt();
	
	public abstract void exportar();
	
	public static void confirmarExportacion() {
		if (ClienteServicio.listaClientes.size() != 0) {
			System.out.println("---------Exportar Datos-----------");
			System.out.println("Seleccione el formato a exportar: ");
			System.out.println("1. Formato csv");
			System.out.println("2. Formato txt");
			System.out.print("\nIngrese la opción para exportar: ");
			int i = scanner.nextInt();
			scanner.nextLine();
			try {
				switch (i) {
				case 1:
					
					exportadorCsv.exportar();
					break;
				case 2:
					exportadorTxt.exportar();
					break;
				default:
					Utilidad.limpiarConsola();
					System.out.print("Opción no valida.");
				}
			} catch (InputMismatchException e) {
				Utilidad.limpiarConsola();
				System.out.print("Opción no valida.");
			}
		} else {
			System.out.print("No hay clientes para exportar");
		}
	}
	
}
