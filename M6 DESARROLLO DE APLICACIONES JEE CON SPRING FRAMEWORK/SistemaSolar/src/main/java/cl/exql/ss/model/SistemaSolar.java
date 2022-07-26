package cl.exql.ss.model;

import java.util.ArrayList;

public class SistemaSolar {

	private ArrayList<Planeta> listaPlanetas;
	
	public SistemaSolar() {
		
		listaPlanetas = new ArrayList<Planeta>();		
	}
	
	public boolean agregarPlaneta( Planeta p) {
		listaPlanetas.add(p);
		return true;
	}

	public void informacionPlanetas() {

		for (Planeta p : listaPlanetas) {
			System.out.println(p.toString());
		}
	}

	public void informacionLunasPlanetas() {

		for (Planeta p : listaPlanetas) {
			System.out.println(p.toString());
			for (Luna l : p.getListaLunas()) {				
				System.out.println(l.toString());
			}
			System.out.println();
		}
	}

	
}
