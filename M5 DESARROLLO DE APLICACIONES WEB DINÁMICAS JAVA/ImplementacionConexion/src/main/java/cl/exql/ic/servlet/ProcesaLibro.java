package cl.exql.ic.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.ic.dao.ILibroDao;
import cl.exql.ic.dao.LibroDaoImpl;
import cl.exql.ic.modelo.Libro;

@WebServlet(name = "ProcesaLibro", urlPatterns = "/")
public class ProcesaLibro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		ILibroDao libroDao = new LibroDaoImpl();
		listaLibros = libroDao.listarLibros();
		request.setAttribute("listaLibros", listaLibros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listadoLibros.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}