package cl.exql.SistemaGestion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.exql.SistemaGestion.servicio.ClienteServicio;
import cl.exql.SistemaGestion.servicio.ExportadorTxt;

@DisplayName ("Test ExportadorTxt")
class ExportadorTxtTest {
	
	ClienteServicio clienteServicioTest = new ClienteServicio();
	ExportadorTxt exportadorTxtTest = new ExportadorTxt(); 

	@Test
	@DisplayName ("Metodo: void exportar()")
	void exportarTest() {
		clienteServicioTest.agregarCliente();
		exportadorTxtTest.exportar();
		assertNotNull(exportadorTxtTest.miArchivo.exists());
		
	}

}
