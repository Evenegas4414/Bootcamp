package cl.exql.ss.main;

import java.util.ArrayList;
import java.util.Arrays;

import cl.exql.ss.model.Luna;
import cl.exql.ss.model.Planeta;
import cl.exql.ss.model.SistemaSolar;

public class Main {
 
	public static void main(String[] args) {
		
		Luna lunaTierra1= new Luna("Luna", 3476.0, 27.322);
		
		Luna lunaMarte1= new Luna("Deimos", 8.0, 1.263);
		Luna lunaMarte2= new Luna("Phobos", 560.0, 0.3);
		
		Luna lunaJupiter1 = new Luna("Adastea", 416.0, 0.298);
		Luna lunaJupiter2 = new Luna("Aitne", 3.0, 736.0);
		
		Luna lunaSaturno1 = new Luna("Aegir", 6.0, 1116.5);
		Luna lunaSaturno2 = new Luna("Albiorix", 30.0, 783.0);
		
		Luna lunaUrano1 = new Luna("Ariel", 1160.0, 2.520);
		Luna lunaUrano2 = new Luna("Belinda", 66.0, 0.624);
		
		Luna lunaNeptuno1 = new Luna("Despina", 160.0, 0.40);
		Luna lunaNeptuno2 = new Luna("Galatea", 140.0, 0.33);
		
		Planeta mercurio = new Planeta("Mercurio", 4880.0, 57910000.0, 
				new ArrayList<Luna>());
		Planeta venus = new Planeta("Venus", 12104.0, 108200000.0, 
				new ArrayList<Luna>());
		Planeta tierra = new Planeta("Tierra", 12756.0, 149600000.0, 
				new ArrayList<Luna>(Arrays.asList(lunaTierra1)));
		Planeta marte = new Planeta("Marte", 6794.0, 227940000.0, 
				new ArrayList<Luna>(Arrays.asList(lunaMarte1,lunaMarte2)));
		Planeta jupiter = new Planeta("Jupiter", 142984.0, 778330000.0, 
				new ArrayList<Luna>(Arrays.asList(lunaJupiter1,lunaJupiter2)));
		Planeta saturno = new Planeta("Saturno", 108728.0, 1429400000.0, 
				new ArrayList<Luna>(Arrays.asList(lunaSaturno1,lunaSaturno2)));
		Planeta urano = new Planeta("Urano", 51118.0, 2870990000.0, 
				new ArrayList<Luna>(Arrays.asList(lunaUrano1,lunaUrano2)));
		Planeta neptuno = new Planeta("Neptuno", 49532.0, 4504300000.0, 
				new ArrayList<Luna>(Arrays.asList(lunaNeptuno1,lunaNeptuno2)));
		
		SistemaSolar sistemaSolar = new SistemaSolar();
		sistemaSolar.agregarPlaneta(mercurio);
		sistemaSolar.agregarPlaneta(venus);
		sistemaSolar.agregarPlaneta(tierra);
		sistemaSolar.agregarPlaneta(marte);
		sistemaSolar.agregarPlaneta(jupiter);
		sistemaSolar.agregarPlaneta(saturno);
		sistemaSolar.agregarPlaneta(urano);
		sistemaSolar.agregarPlaneta(neptuno);
		
		sistemaSolar.informacionLunasPlanetas();

		
		
		
		
		
		
		
		
		
	}

}
