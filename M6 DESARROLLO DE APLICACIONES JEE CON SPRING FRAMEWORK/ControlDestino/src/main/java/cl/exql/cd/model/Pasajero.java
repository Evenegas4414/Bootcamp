package cl.exql.cd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "seq_pasajero", initialValue = 1, allocationSize = 1)
public class Pasajero {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pasajero")	
	private Integer idPasajero;
	private String rut;
	private String nombre;
	private String apellido;
	private Integer edad;
	private String ciudadNatal;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasajero")
	private List<Destino> destinos = new ArrayList<Destino>();

	public Pasajero() {
	}

	public Pasajero(Integer idPasajero, String rut, String nombre, String apellido, Integer edad, String ciudadNatal,
			List<Destino> destinos) {
		this.idPasajero = idPasajero;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudadNatal = ciudadNatal;
		this.destinos = destinos;
	}

	public Integer getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(Integer idPasajero) {
		this.idPasajero = idPasajero;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getCiudadNatal() {
		return ciudadNatal;
	}

	public void setCiudadNatal(String ciudadNatal) {
		this.ciudadNatal = ciudadNatal;
	}

	public List<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

}