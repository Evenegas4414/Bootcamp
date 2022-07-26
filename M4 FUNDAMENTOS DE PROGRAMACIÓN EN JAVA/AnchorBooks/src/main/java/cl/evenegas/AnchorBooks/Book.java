package cl.evenegas.AnchorBooks;

import java.util.List;

public class Book {

	int id;
	String author;
	String country;
	String imageLink;
	String language;
	String title;
	
	public static void imprimirListaBook(List<Book> listaBook) {
		for (Book b : listaBook) {
			System.out.println("Book [" 
					+ "id=" + b.getId() + ", "
					+ "author=" + b.getAuthor() + ", "
					+ "country=" + b.getCountry() + ", "
					+ "imageLink=" + b.getImageLink() + ", "
					+ "language=" + b.getLanguage() + ", "
					+ "title=" + b.getTitle() + "]"
			);
		}
	}
	
	public static void imprimirAutorTitulo(List<Book> listaBook) {
		for (Book b : listaBook) {
			System.out.println( b.getAuthor() + ": " + b.getTitle() );
		}
	}
	
	public static void imprimirTercerOctavo(List<Book> listaBook) {
			System.out.println("Libro número 3: " +  listaBook.get(3).getAuthor()
					+ ", " + listaBook.get(3).getTitle() 
					+ ", " + listaBook.get(3).getCountry());
			System.out.println("Libro número 8: " +  listaBook.get(8).getAuthor()
					+ ", " + listaBook.get(8).getTitle() 
					+ ", " + listaBook.get(8).getCountry());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
