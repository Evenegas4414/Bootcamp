package cl.evenegas.AnchorBooks;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class App 
{
	static String URI_BOOK = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/books";
	static String URI_BOOKDETAIL = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/bookDetail";
	
    public static void main( String[] args ) {

    	
        Client cliente1 = ClientBuilder.newClient();
        WebTarget wt1 = cliente1.target(URI_BOOK);
        Invocation.Builder builder1 = wt1.request(MediaType.APPLICATION_JSON);
        Response respuestaBook = builder1.get();
        
        List<Book> listaBook = respuestaBook.readEntity(new GenericType<List<Book>>() {});
        
        
        
        
        
        List<BookDetail> listaBookDetail = (ClientBuilder.newClient()).target(URI_BOOKDETAIL).
        		request(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<BookDetail>> () {});
        
        Book.imprimirListaBook(listaBook);
        System.out.println("");        
        Book.imprimirAutorTitulo(listaBook);
        System.out.println("");        
        Book.imprimirTercerOctavo(listaBook);
        System.out.println("");
        
        System.out.println("");
        
        
        
        BookDetail.imprimirListaBook(listaBookDetail);
        System.out.println("");
        BookDetail.imprimirAutoresAnonimos(listaBookDetail);
        System.out.println("");
        BookDetail.imprimirDelivery(listaBookDetail);
        
        
        /*
        Pruebas Book
        System.out.println(listaBook.size());
        System.out.println("Title: " + listaBook.get(0).getTitle() + " Author: " +listaBook.get(0).getAuthor());
        
        Pruebas BookDetail
        System.out.println(listaBookDetail.size());
        System.out.println("Price: " + listaBookDetail.get(0).price + " Pages: " +listaBookDetail.get(0).pages);
        */
    }
}
