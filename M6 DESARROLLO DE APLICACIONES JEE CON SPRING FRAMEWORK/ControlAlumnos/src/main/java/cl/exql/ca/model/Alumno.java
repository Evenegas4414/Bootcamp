package cl.exql.ca.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_alumno", initialValue = 1, allocationSize = 1)
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alumno")
	private Integer idAlumno;
	private String rut;
	private String nombre;
	private String apellido;
	private String email;
	private Integer edad;
	private String fechaIngreso;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "direccion", referencedColumnName = "idDireccion")
	private Direccion direccion;

	public Alumno() {
	}

	public Alumno(Integer idAlumno, String rut, String nombre, String apellido, String email, Integer edad,
			String fechaIngreso, Direccion direccion) {
		this.idAlumno = idAlumno;
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
		this.direccion = direccion;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", edad=" + edad + ", fechaIngreso=" + fechaIngreso + ", direccion=" + direccion
				+ "]";
	}

}