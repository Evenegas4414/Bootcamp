package cl.exql.SistemaGestion.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import cl.exql.SistemaGestion.servicio.ArchivoServicio;
import cl.exql.SistemaGestion.servicio.ClienteServicio;
import cl.exql.SistemaGestion.servicio.Exportador;
import cl.exql.SistemaGestion.servicio.ExportadorCsv;
import cl.exql.SistemaGestion.servicio.ExportadorTxt;
import cl.exql.SistemaGestion.utilidades.Utilidad;

public class Menu {

	ClienteServicio clienteServicio;
	ArchivoServicio archivoServicio;
	ExportadorCsv exportadorCsv;
	ExportadorTxt exportadorTxt;
	String fileName;
	String fileName1;
	Scanner scanner;

	public Menu() {
		super();
		this.clienteServicio = new ClienteServicio();
		this.archivoServicio = new ArchivoServicio();
		this.exportadorCsv = new ExportadorCsv();
		this.exportadorTxt = new ExportadorTxt();
		this.fileName = "Clientes";
		this.fileName1 = "DBClientes.csv";
		this.scanner = new Scanner(System.in);
	}

	public void iniciarMenu() {

		int i = 0;
		do {
			Utilidad.limpiarConsola();
			System.out.println("Bienvenido a la pasteleria \"Bon Bon Jovi\".");
			System.out.println("1. Listar Clientes");
			System.out.println("2. Agregar Cliente");
			System.out.println("3. Editar Cliente");
			System.out.println("4. Cargar Datos");
			System.out.println("5. Exportar Datos");
			System.out.println("6. Salir");
			System.out.print("Ingrese una opción: ");
			try { 
				i = scanner.nextInt();
				scanner.nextLine();
				Utilidad.limpiarConsola();
				switch (i) {
				case 1:
					clienteServicio.listarClientes();
					Utilidad.esperar(4000);
					break;
				case 2: 
					clienteServicio.agregarCliente();
					Utilidad.esperar();
					break;
				case 3:
					clienteServicio.confirmarEditar();
					Utilidad.esperar();
					break;
				case 4:
					archivoServicio.confirmarImportar();
					Utilidad.esperar();
					break;
				case 5:
					Exportador.confirmarExportacion();
					Utilidad.esperar();
					break;
				case 6:
					terminarPrograma();
					Utilidad.esperar();
					Utilidad.limpiarConsola();
					break;
				default:
					System.out.print("Opción no valida.");
					Utilidad.esperar();
				}
			} catch (InputMismatchException e) {
				Utilidad.limpiarConsola();
				scanner.nextLine();
				System.out.print("Opción no valida.");
				Utilidad.esperar();
			}
		} while (i != 6);
	}

	public void listarCliente() {

	}

	public void agregarCliente() {

	}

	public void editarCliente() {

	}

	public void importarDatos() {

	}

	public void exportarDatos() {

	}
	

	public void terminarPrograma() {
		System.out.println("Abandonando el sistema de productos...");
		System.out.print("Acaba de salir del sistema.");
	}

	public ClienteServicio getClienteServicio() {
		return clienteServicio;
	}

	public void setClienteServicio(ClienteServicio clienteServicio) {
		this.clienteServicio = clienteServicio;
	}

	public ArchivoServicio getArchivoServicio() {
		return archivoServicio;
	}

	public void setArchivoServicio(ArchivoServicio archivoServicio) {
		this.archivoServicio = archivoServicio;
	}

	public ExportadorCsv getExportadorCsv() {
		return exportadorCsv;
	}

	public void setExportadorCsv(ExportadorCsv exportadorCsv) {
		this.exportadorCsv = exportadorCsv;
	}

	public ExportadorTxt getExportadorTxt() {
		return exportadorTxt;
	}

	public void setExportadorTxt(ExportadorTxt exportadorTxt) {
		this.exportadorTxt = exportadorTxt;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName1() {
		return fileName1;
	}

	public void setFileName1(String fileName1) {
		this.fileName1 = fileName1;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public String toString() {
		return "Menu [clienteServicio=" + clienteServicio + ", archivoServicio=" + archivoServicio + ", exportadorCsv="
				+ exportadorCsv + ", exportadorTxt=" + exportadorTxt + ", fileName=" + fileName + ", fileName1="
				+ fileName1 + ", scanner=" + scanner + "]";
	}

}
