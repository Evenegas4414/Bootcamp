package cl.exql.ca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_direccion", initialValue = 1, allocationSize = 1)
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_direccion")
	private Integer idDireccion;
	private String calle;
	private String numero;
	private String ciudad;
	private TipoDireccion tipo;

	public Direccion() {
	}

	public Direccion(Integer idDireccion, String calle, String numero, String ciudad, TipoDireccion tipo) {
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.tipo = tipo;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public TipoDireccion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDireccion tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return calle + " " + numero + ", "	+ ciudad;
	}

}
