package cl.exql.pdl.controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.pdl.dao.ProductoDaoImpl;
import cl.exql.pdl.modelo.Producto;

@WebServlet(name = "EliminarServlet", urlPatterns="/eliminar")
public class EliminarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	private ProductoDaoImpl pdi;

	public void init() throws ServletException {

		pdi = new ProductoDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Producto producto = pdi.obtenerProducto(Integer.parseInt(request.getParameter("idProducto")));
		request.setAttribute("producto", producto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("eliminar.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		pdi.eliminarProducto(Integer.parseInt(request.getParameter("idProducto")));
		response.sendRedirect("listar");
	}
}