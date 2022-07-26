package servicio;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Producto;
import vista.Menu;

public class ProductoServicio {
	static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	static public void listarProductos() {		
		if (listaProductos.size() != 0) {
			for (Producto p : listaProductos) {
				System.out.println("Datos del Producto: \n");
				System.out.println("Nombre articulo: " + p.getArticulo());
				System.out.println("Código: " + p.getCodigo());
				System.out.println("Marca: " + p.getMarca());
				System.out.println("Color: " + p.getColor());
				System.out.println("Descripción: " + p.getDescripcion());
				System.out.println("Precio: " + p.getPrecio());
				System.out.println("Talla: " + p.getTalla());
				System.out.println("---------------------------\n");
			}
			System.out.print("El numero de productos es: " + listaProductos.size());
		} else {
			System.out.print("No hay productos para mostrar.");			
		}		
	}

	public static void agregarProducto() {
		ArrayList<String> productoNuevo = new ArrayList<String>();	
		Menu.sc.nextLine();
		System.out.println("Crear Producto");		
		System.out.println("Ingresa nombre articulo: ");
		productoNuevo.add(Menu.sc.nextLine());
		System.out.println("Ingresa precio: ");
		productoNuevo.add(Menu.sc.nextLine());
		System.out.println("Ingresa descripción: ");
		productoNuevo.add(Menu.sc.nextLine());
		System.out.println("Ingresa código: ");
		productoNuevo.add(Menu.sc.nextLine());
		System.out.println("Ingresa talla: ");
		productoNuevo.add(Menu.sc.nextLine());
		System.out.println("Ingresa marca: ");
		productoNuevo.add(Menu.sc.nextLine());
		System.out.println("Ingresa color: ");
		productoNuevo.add(Menu.sc.nextLine());
		
		listaProductos.add(new Producto(productoNuevo.get(0), productoNuevo.get(1), productoNuevo.get(2),
				productoNuevo.get(3), productoNuevo.get(4), productoNuevo.get(5), productoNuevo.get(6)));
		
		System.out.print("\nProducto agregado exitosamente.");
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	@SuppressWarnings("unused")
	private void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	@Override
	public String toString() {
		return "ProductoServicio [listaProductos=" + listaProductos + "]";
	}
}
