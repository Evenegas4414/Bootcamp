package cl.exql.generadorfactura.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.generadorfactura.modelo.Item;
import cl.exql.generadorfactura.modelo.Producto;

 
@WebServlet(name="formulario", urlPatterns ="/")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Producto> listaProductos;
	List<Item> listaItems;
	List<Integer> listaCantidades;
    
	public void init(ServletConfig config) throws ServletException {
		listaProductos = new ArrayList<Producto>();
		listaItems = new ArrayList<Item>();
		listaCantidades = new ArrayList<Integer>();
		
		listaProductos.add(new Producto("Valvula Titanio", "Valvulas de carrera", 120_000));
		listaProductos.add(new Producto("Turbo Full Carrera", "Turbo de competición multimarca", 1_700_000));
		listaProductos.add(new Producto("Kit de Freno Competición", "Juego de discos, balatas, caliper de competición", 760_000));
		listaProductos.add(new Producto("Sistema de refrigeración", "Sistema enfriamiento motor Carrera", 2_300_000));
		listaProductos.add(new Producto("Plumillas Limpiaparabrisas standar", "Plumillas para la lluvia", 10_000));		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listaProductos", listaProductos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/datos-formulario.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Item> listaItems = new ArrayList<Item>();
		List<Integer> listaCantidades = new ArrayList<Integer>();
		int i = 0;
		
		for (String cantidad : request.getParameterValues("cantidad")) {
			listaCantidades.add(Integer.parseInt(cantidad));	
		}
		
		for (Producto p : listaProductos) {			
			listaItems.add(new Item(p, listaCantidades.get(i)));
			i++;
		}		
		
		request.setAttribute("listaItems", listaItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("factura");
		dispatcher.forward(request, response);		
	}
	
	public void destroy() {

	}

}
