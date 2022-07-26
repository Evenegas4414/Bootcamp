package cl.exql.Calculadora;

import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests Clase Calculadora")
class CalculadoraTest { 
	
	private static Logger logger = Logger.getLogger("cl.desafiolatam.servicios.ServicioPersonaTest");
	private final Calculadora calculadora = new Calculadora();


	
	@Test
	void testRestar() {
		//logger.info("info test restar");
		assertEquals(6, calculadora.restar(9,3));
	}
	
	@Test
	void testSumar() {
		//logger.info("info test sumar");
		assertEquals(12, calculadora.sumar(9,3));
	}
	
	@Test
	void testMultiplicar() {
		//logger.info("info test multiplicar");
		assertEquals(27, calculadora.multiplicar(9,3));
	}
	
	@Test
	void testDividir() {
		//logger.info("info test dividir");
		assertEquals(3, calculadora.dividir(9,3));
	}
	
	
	

}
