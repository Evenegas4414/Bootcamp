package cl.exql.ss.model;

import java.util.ArrayList;

public class Planeta implements IPlaneta {

	private String nombre;
	private Double tamanio;
	private Double distanciaSol;
	// Se ignora debido a que diferentes planetas y tienen
	// diferentes cantidades de lunas.
	//private Double distanciaLuna;
	private ArrayList<Luna> listaLunas;

	public Planeta() {
	}

	public Planeta(String nombre, Double tamanio, Double distanciaSol,
			ArrayList<Luna> listaLunas) {
		this.nombre = nombre;
		this.tamanio = tamanio;
		this.distanciaSol = distanciaSol;
		this.listaLunas = listaLunas;
	}
	
	public boolean agregarLuna( Luna l) {
		listaLunas.add(l);
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTamanio() {
		return tamanio;
	}
 
	public void setTamanio(Double tamanio) {
		this.tamanio = tamanio;
	}

	public Double getDistanciaSol() {
		return distanciaSol;
	}

	public void setDistanciaSol(Double distanciaSol) {
		this.distanciaSol = distanciaSol;
	}

	public ArrayList<Luna> getListaLunas() {
		return listaLunas;
	}

	public void setListaLunas(ArrayList<Luna> listaLunas) {
		this.listaLunas = listaLunas;
	}
 
	@Override
	public String toString() {
		
		return "Planeta: Tierra está a " + distanciaSol + " km del sol, su tamaño es de " 
				+ tamanio + " km de diámetro y tiene " + listaLunas.size() + " lunas, ";
	}	

	
}
