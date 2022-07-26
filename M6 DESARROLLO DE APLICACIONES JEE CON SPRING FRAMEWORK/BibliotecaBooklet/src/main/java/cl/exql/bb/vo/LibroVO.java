package cl.exql.bb.vo;

import java.util.ArrayList;

import cl.exql.bb.model.Libro;

public class LibroVO {
	ArrayList<Libro> libros;
	String mensaje;
	String codigo;

	public LibroVO() {

	}

	public LibroVO(ArrayList<Libro> libros, String mensaje, String codigo) {

		this.libros = libros;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "LibroVO [libros=" + libros + ", mensaje=" + mensaje + ", codigo=" + codigo + "]" + libros.toString() + " ";
	}

}
