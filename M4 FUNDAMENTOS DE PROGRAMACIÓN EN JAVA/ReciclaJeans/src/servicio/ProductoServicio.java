package servicio;

import java.util.ArrayList;
import java.util.InputMismatchException;

import modelo.Producto;
import utilidades.Utilidad;
import vista.Menu;

public class ProductoServicio {
	public static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	static int opcion = -1;

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

	public static void editarProducto(Producto p, int opcion) {
		Menu.sc.nextLine();
		switch (opcion) {
		case 1:
			System.out.println("Ingrese el nuevo nombre del articulo:");
			p.setArticulo(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break;
		case 2:
			System.out.println("Ingrese el nuevo código del producto:");
			p.setCodigo(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break;
		case 3:
			System.out.println("Ingrese el nuevo color del producto:");
			p.setCodigo(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break;
		case 4:
			System.out.println("Ingrese la nueva descripción del producto:");
			p.setDescripcion(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break;
		case 5:
			System.out.println("Ingrese la nueva marca del producto:");
			p.setMarca(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break;
		case 6:
			System.out.println("Ingrese el nuevo precio del producto:");
			p.setPrecio(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break;
		case 7:
			System.out.println("Ingrese la nueva talla del producto:");
			p.setTalla(Menu.sc.nextLine());
			System.out.print("\nProducto editado exitosamente.");
			break; 
		default:
			Utilidad.limpiarConsola();
			System.out.print("Opción no valida.");
			Utilidad.esperar();
		}
	}

	public static void confirmarEditar() {
		boolean existeCodigo = true;
		if (ProductoServicio.listaProductos.size() != 0) {
			System.out.println("Editar Producto");
			System.out.println("Ingrese el número 1 para editar los datos ingresados del Producto");
			try {
				if (Menu.sc.nextInt() == 1) {
					Menu.sc.nextLine();
					System.out.println("Código del producto:");
					String codigoBuscado = Menu.sc.nextLine();
					existeCodigo = false;
					for (Producto p : listaProductos) {
						if (p.getCodigo().equalsIgnoreCase(codigoBuscado)) {
							existeCodigo = true;
							System.out.println("1.-El nombre del articulo actual es: " + p.getArticulo());
							System.out.println("2.-El código del producto: " + p.getCodigo());
							System.out.println("3.-El color del producto: " + p.getColor());
							System.out.println("4.-La descripción del producto: " + p.getDescripcion());
							System.out.println("5.-La marca del producto: " + p.getMarca());
							System.out.println("6.-El precio del producto: " + p.getPrecio());
							System.out.println("7.-La talla del producto: " + p.getTalla());
							System.out.println("Ingrese la opción a editar de los datos del producto:");
							try {
								opcion = Menu.sc.nextInt();
								if (opcion > 0 || opcion < 8) {
									ProductoServicio.editarProducto(p, opcion);
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
					if (!existeCodigo) {
						Menu.sc.nextLine();
						Utilidad.limpiarConsola();
						System.out.print("No hay productos que coincidan con ese código");
						Utilidad.esperar();
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
		} else {
			Menu.sc.nextLine();
			Utilidad.limpiarConsola();
			System.out.print("No hay productos para editar.");
			Utilidad.esperar();
		}
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
