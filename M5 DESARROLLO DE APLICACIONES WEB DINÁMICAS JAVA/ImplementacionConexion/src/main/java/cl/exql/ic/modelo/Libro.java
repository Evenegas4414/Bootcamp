package cl.exql.ic.modelo;

public class Libro {
	
	private int numeroLibro;
	private String nombreLibro;
	private String autorLibro;
	
	public Libro() {
		
	}
	
	public Libro(int numeroLibro, String nombreLibro, String autorLibro) {
		this.numeroLibro = numeroLibro;
		this.nombreLibro = nombreLibro;
		this.autorLibro = autorLibro;
	}

	public int getNumeroLibro() {
		return numeroLibro;
	}

	public void setNumeroLibro(int numeroLibro) {
		this.numeroLibro = numeroLibro;
	}

	public String getNombreLibro() {
		return nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public String getAutorLibro() {
		return autorLibro;
	}

	public void setAutorLibro(String autorLibro) {
		this.autorLibro = autorLibro;
	}
}
