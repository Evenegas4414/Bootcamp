package cl.exql.SistemaGestion.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.exql.SistemaGestion.servicio.ArchivoServicio;

@DisplayName ("Test ArchivoServicio")
class ArchivoServicioTest {
	
	ArchivoServicio archivoServicioTest = new ArchivoServicio();	
	
	@Test
	@DisplayName ("Metodo: void cargarDatos(String fileName)")
	void cargarDatosTest() {		
		assertTrue(archivoServicioTest.cargarDatos("src/main/java/cl/exql/SistemaGestion/resources"));		
	}
}
