package cl.exql.cd.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_destino", initialValue = 1, allocationSize = 1)
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_destino")
	private Integer idDestino;
	private String ciudad;
	private String pais;
	private String fecha;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pasajero", referencedColumnName = "idPasajero")
	private Pasajero pasajero;

	public Destino() {
	}

	public Destino(Integer idDestino, String ciudad, String pais, String fecha, Pasajero pasajero) {
		this.idDestino = idDestino;
		this.ciudad = ciudad;
		this.pais = pais;
		this.fecha = fecha;
		this.pasajero = pasajero;
	}

	public Integer getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	@Override
	public String toString() {
		return ciudad + ", " + pais;
	}

}
