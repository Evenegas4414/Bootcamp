package cl.exql.bb.model;

public class LibroBoolean {

	Integer idLibro;
	Integer anio;
	String titulo;
	String autor;
	String imprenta;
	Boolean disponibilidad = false;

	public LibroBoolean() {
	}

	public LibroBoolean(Libro libro) {
		
		this.idLibro = libro.getIdLibro();
		this.titulo = libro.getTitulo();
		this.anio =libro.getAnio();
		this.autor = libro.getAutor();
		this.imprenta = libro.getImprenta();
        this.disponibilidad = null != libro.getDisponibilidad() ? (libro.getDisponibilidad() == 1) : true;
    }
	
	public LibroBoolean(Integer idLibro, Integer anio, String titulo, String autor, String imprenta, Boolean disponibilidad) {
		this.idLibro = idLibro;
		this.anio = anio;
		this.titulo = titulo;
		this.autor = autor;
		this.imprenta = imprenta;
		this.disponibilidad = disponibilidad;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getImprenta() {
		return imprenta;
	}

	public void setImprenta(String imprenta) {
		this.imprenta = imprenta;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", anio=" + anio + ", titulo=" + titulo + ", autor=" + autor
				+ ", imprenta=" + imprenta + ", disponibilidad=" + disponibilidad + "]";
	}

}
