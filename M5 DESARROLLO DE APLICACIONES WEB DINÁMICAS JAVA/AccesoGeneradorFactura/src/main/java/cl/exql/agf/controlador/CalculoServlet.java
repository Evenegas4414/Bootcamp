package cl.exql.agf.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="factura", urlPatterns = "/factura")
public class CalculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	public void init(ServletConfig config) throws ServletException {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/factura.jsp");
		dispatcher.forward(request, response);
	}
	
	public void destroy() {

	}

}