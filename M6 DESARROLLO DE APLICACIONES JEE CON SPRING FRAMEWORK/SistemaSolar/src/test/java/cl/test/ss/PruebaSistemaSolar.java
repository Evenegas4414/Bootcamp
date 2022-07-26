package cl.test.ss;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import cl.exql.ss.model.Luna;
import cl.exql.ss.model.Planeta;

public class PruebaSistemaSolar {

	@Test
	public void nombrePlaneta() {
		Luna lunaNeptuno1 = new Luna("Despina", 160.0, 0.40);
		Luna lunaNeptuno2 = new Luna("Galatea", 140.0, 0.33);
		Planeta neptuno = new Planeta("Neptuno", 49532.0, 4504300000.0,
				new ArrayList<Luna>(Arrays.asList(lunaNeptuno1, lunaNeptuno2)));
		assertTrue(neptuno.getNombre().equals("Neptuno"));
	}

	@Test
	public void nombreLuna() {
		Luna lunaUrano1 = new Luna("Ariel", 1160.0, 2.520);
		Luna lunaUrano2 = new Luna("Belinda", 66.0, 0.624);
		Planeta urano = new Planeta("Urano", 51118.0, 2870990000.0,
				new ArrayList<Luna>(Arrays.asList(lunaUrano1, lunaUrano2)));
		assertTrue(urano.getListaLunas().get(0).getNombre().equals("Ariel"));
	}

	@Test
	public void cantidadLunasPlaneta() {
		Luna lunaSaturno1 = new Luna("Aegir", 6.0, 1116.5);
		Luna lunaSaturno2 = new Luna("Albiorix", 30.0, 783.0);
		Planeta saturno = new Planeta("Saturno", 108728.0, 1429400000.0,
				new ArrayList<Luna>(Arrays.asList(lunaSaturno1, lunaSaturno2)));
		assertEquals(2, saturno.getListaLunas().size(), 0);
	}

	@Test
	public void cantidadLunas() {
		Luna lunaJupiter1 = new Luna("Adastea", 416.0, 0.298);
		Luna lunaJupiter2 = new Luna("Aitne", 3.0, 736.0);
		Planeta jupiter = new Planeta("Jupiter", 142984.0, 778330000.0,
				new ArrayList<Luna>(Arrays.asList(lunaJupiter1, lunaJupiter2)));
		assertTrue(jupiter.getListaLunas().size() == 2);
	}
}
