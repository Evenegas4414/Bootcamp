package cl.exql.SistemaGestion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.exql.SistemaGestion.servicio.ClienteServicio;

@DisplayName ("Test ClienteServicio")
class ClienteServicioTest {
	
	ClienteServicio clienteServicioTest = new ClienteServicio();

	@Test
	@DisplayName ("Metodo: boolean listarClientes()")
	void listarClientesTest() {
		clienteServicioTest.agregarCliente();
				assertTrue(clienteServicioTest.listarClientes());
	}
	
	@Test
	@DisplayName ("Metodo: Cliente editarCliente(Cliente c)")
	void editarClienteTest() {
		assertNotNull(clienteServicioTest.agregarCliente());
		
	}
	
	@Test
	@DisplayName ("Metodo: Cliente agregarCliente()")
	void agregarClienteTest() {		
		assertNotNull(clienteServicioTest.agregarCliente());
		
	}
	
	

}
