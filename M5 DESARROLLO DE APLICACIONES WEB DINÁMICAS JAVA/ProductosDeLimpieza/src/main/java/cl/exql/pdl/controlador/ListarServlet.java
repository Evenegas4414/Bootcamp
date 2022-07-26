package cl.exql.pdl.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.pdl.dao.ProductoCategoriaDaoImpl;
import cl.exql.pdl.modelo.ProductoCategoria;

@WebServlet(name = "ListarServlet", urlPatterns="/listar")
public class ListarServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
	
	private ProductoCategoriaDaoImpl pcdi;

	public void init() throws ServletException {
		
		pcdi = new ProductoCategoriaDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<ProductoCategoria> listaProductoCategoria = pcdi.listarProductoCategoria();
		request.setAttribute("listaProductoCategoria", listaProductoCategoria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}