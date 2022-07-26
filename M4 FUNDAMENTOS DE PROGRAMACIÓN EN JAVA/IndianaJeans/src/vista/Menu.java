package vista;

import java.util.Scanner;

import servicio.ExportarTxt;
import servicio.ProductoServicio;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	
	public static void imprimirMenuPrincipal() {
		System.out.println("Tienda Indiana Jeans");
		System.out.println("1 Listar Producto");
		System.out.println("2 Agregar Producto");
		System.out.println("3 Exportar Datos");
		System.out.println("4 Salir");
		System.out.print("Ingrese una opción: ");	
	}
	
	public static void salir() {
		System.out.println("Abandonando el sistema de productos...");
		System.out.println("Acaba de salir del sistema.");
	}
}
