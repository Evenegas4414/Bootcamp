package cl.exql.SistemaGestion.test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test; 

import cl.exql.SistemaGestion.servicio.ClienteServicio;
import cl.exql.SistemaGestion.servicio.ExportadorCsv;

@DisplayName("Test ExportadorCsv")
class ExportadorCsvTest {

	ClienteServicio clienteServicioTest = new ClienteServicio();
	ExportadorCsv exportadorCsvTest = new ExportadorCsv();

	@Test
	@DisplayName("Metodo: void exportar()")
	void exportarTest() {
		
	}
}
