package cl.evenegas.AnchorBooks;

import java.util.List;

public class BookDetail {

	int id;
	String author;
	String country;
	String imageLink;
	String language;
	String link;
	int pages;
	String title;
	int year;
	int price;
	int lastPrice;
	boolean delivery;

	public static void imprimirListaBook(List<BookDetail> listaBookDetail) {
		for (BookDetail bd : listaBookDetail) {
			System.out.println("BookDetail [" 
					+ "id=" + bd.getId() + ", "
					+ "author=" + bd.getAuthor() + ", "
					+ "country=" + bd.getCountry() + ", "
					+ "imageLink=" + bd.getImageLink() + ", "
					+ "language=" + bd.getLanguage() + ", "
					+ "link=" + bd.getLink() + ", "
					+ "pages=" + bd.getPages() + ", "
					+ "title=" + bd.getTitle() + ", "
					+ "year=" + bd.getYear() + ", "
					+ "price=" + bd.getPrice() + ", "
					+ "lastPrice=" + bd.getLastPrice() + ", "
					+ "delivery=" + bd.isDelivery() + "]"
			);
		}
	}
	
	public static void imprimirAutoresAnonimos(List<BookDetail> listaBookDetail) {
		System.out.println("Autores anónimos: ");
		System.out.println("");
		for (BookDetail bd : listaBookDetail) {
			if (bd.getAuthor().equalsIgnoreCase("Unknown")) {
			System.out.println("Autor: " + bd.getAuthor() + " - "
					+ "libro: " + bd.getTitle());
			}
		}
	}
	
	public static void imprimirDelivery(List<BookDetail> listaBookDetail) {
		System.out.println("Libros con delivery disponibles: ");
		System.out.println("");
		for (BookDetail bd : listaBookDetail) {
			if (bd.isDelivery()) {
			System.out.println("Libro: " + bd.getTitle());
			}
		}
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(int lastPrice) {
		this.lastPrice = lastPrice;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

}
