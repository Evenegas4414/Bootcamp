package cl.exql.SistemaGestion.servicio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import cl.exql.SistemaGestion.modelo.CategoriaEnum;
import cl.exql.SistemaGestion.modelo.Cliente;
import cl.exql.SistemaGestion.utilidades.Utilidad;

public class ClienteServicio {

	public static List<Cliente> listaClientes;
	Scanner scanner = new Scanner(System.in);
	boolean existeRun = false;

	public ClienteServicio() {
		ClienteServicio.listaClientes = new ArrayList<Cliente>();
	}

	public boolean listarClientes() {
		if (listaClientes.size() != 0) {
			for (Cliente c : listaClientes) {
				System.out.println("\n-------------Datos del Cliente-------------\n");
				System.out.println("RUN del Cliente: " + c.getRunCliente());
				System.out.println("Nombre del Cliente: " + c.getNombreCliente());
				System.out.println("Apellido del Cliente: " + c.getApellidoCliente());
				System.out.println("Años como Cliente: " + c.getAniosCliente());
				System.out.println("Categoria del Cliente: " + c.getNombreCategoria());
				System.out.print("\n-------------------------------------------");
			}
			return true;
		} else {
			
			System.out.print("No hay clientes registrados");
			return false;
		}
	}

	public Cliente agregarCliente() {
		ArrayList<String> nuevoCliente = new ArrayList<String>();
		System.out.println("-------------Crear Cliente-------------\n");
		System.out.println("Ingresa RUN del Cliente: ");
		nuevoCliente.add(scanner.nextLine());
		System.out.println("Nombre del Cliente: ");
		nuevoCliente.add(scanner.nextLine());
		System.out.println("Apellido del Cliente: ");
		nuevoCliente.add(scanner.nextLine());
		System.out.println("Años como Cliente: ");
		nuevoCliente.add(scanner.nextLine());
		Cliente miNuevoCliente = new Cliente(nuevoCliente.get(0), nuevoCliente.get(1), nuevoCliente.get(2), nuevoCliente.get(3));
		listaClientes.add(miNuevoCliente);
		Utilidad.limpiarConsola();
		System.out.print("Cliente agregado exitosamente.");
		return miNuevoCliente;
	}

	public Cliente editarCliente(Cliente c) {

		System.out.println("----Actualizando datos del Cliente-----");
		System.out.println("1. El RUN del Cliente es: " + c.getRunCliente());
		System.out.println("2. El Nombre del Cliente es: " + c.getNombreCliente());
		System.out.println("3. El Apellido del Cliente es: " + c.getApellidoCliente());
		System.out.println("4. Los años como Cliente son: " + c.getAniosCliente());
		System.out.println("Ingrese opcion a editar de los datos del cliente: ");
		try {
			int i = scanner.nextInt();
			scanner.nextLine();
			if (i > 0 && i < 5) {
				switch (i) {
				case 1:
					System.out.println("Ingrese el nuevo RUN del cliente:");
					c.setRunCliente(scanner.nextLine());
					break;
				case 2:
					System.out.println("Ingrese el nuevo Nombre del cliente:");
					c.setRunCliente(scanner.nextLine());
					break;
				case 3:
					System.out.println("Ingrese el nuevo Apellido del cliente:");
					c.setRunCliente(scanner.nextLine());
					break;
				case 4:
					System.out.println("Ingrese los Años como cliente:");
					c.setRunCliente(scanner.nextLine());
					break;
				default:
					Utilidad.limpiarConsola();
					System.out.print("Opción no valida.");
				}
				Utilidad.limpiarConsola();				
				System.out.print("Datos cambiados con exito");
				return c;
			} else {
				Utilidad.limpiarConsola();
				System.out.print("Opción no valida.");				
			}
		} catch (InputMismatchException e) {
			scanner.nextLine();
			Utilidad.limpiarConsola();
			System.out.print("Opción no valida.");
		}
		return c;
	}

	public void editarEstadoCliente(Cliente c) {
		System.out.println("-----Actualizando estado del Cliente----");
		System.out.println("El estado actual es: " + c.getNombreCategoria().getEstado());
		System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
		System.out.println("2.- Si desea cambiar el estado del cliente a Activo");
		System.out.print("\nIngrese opción: ");
		try {
			int i = scanner.nextInt();
			scanner.nextLine();
			switch (i) {
			case 1:
				c.setNombreCategoria(CategoriaEnum.INACTIVO);
				Utilidad.limpiarConsola();
				System.out.println("El estado del cliente se ha cambiado.");
				System.out.print("Cliente: " + c.getRunCliente() + " Estado actual: " + c.getNombreCategoria().getEstado());
				break;
			case 2:
				c.setNombreCategoria(CategoriaEnum.ACTIVO);
				Utilidad.limpiarConsola();
				System.out.println("El estado del cliente se ha cambiado.");
				System.out.print("Cliente: " + c.getRunCliente() + " Estado actual: " + c.getNombreCategoria().getEstado());
				break;
			default:
				Utilidad.limpiarConsola();
				System.out.print("Opción no valida.");
			}
		} catch (InputMismatchException e) {
			scanner.nextLine();
			Utilidad.limpiarConsola();
			System.out.print("Opción no valida.");
		}		
	}

	public void confirmarEditar() {
		if (listaClientes.size() != 0) {
			System.out.println("-------------Editar Cliente-------------");
			System.out.println("Seleccione que desea hacer: ");
			System.out.println("1.- Cambiar el estado del Cliente");
			System.out.println("2.- Editar los datos ingresados del Cliente\n");
			System.out.print("Ingrese opción: ");
			try {
				int i = scanner.nextInt();
				scanner.nextLine();
				boolean existeRun = false;
				if (i == 1 || i == 2) {
					System.out.print("Ingrese RUN del Cliente a editar: ");
					String run = scanner.nextLine();
					for (Cliente c : listaClientes) {
						if (c.getRunCliente().equalsIgnoreCase(run)) {
							existeRun = true;
							switch (i) {
							case 1:
								Utilidad.limpiarConsola();
								editarEstadoCliente(c);
								break;
							case 2:
								Utilidad.limpiarConsola();
								editarCliente(c);
								break;
							default:
								Utilidad.limpiarConsola();
								System.out.print("Opción no valida. A");
							}
						}
					}
					if (!existeRun) {
						Utilidad.limpiarConsola();
						System.out.print("El RUN no coincide con algun cliente");
					}
				} else {
					Utilidad.limpiarConsola();
					System.out.print("Opción no valida. C");
				}
			} catch (InputMismatchException e) {
				scanner.nextLine();
				Utilidad.limpiarConsola();
				System.out.print("Opción no valida. D");
			}
		} else {
			System.out.print("No hay clientes para editar");
		}
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	@SuppressWarnings("unused")
	private void setListaClientes(List<Cliente> listaClientes) {
		ClienteServicio.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}

}
