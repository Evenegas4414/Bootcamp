package cl.exql.mantenedor.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.mantenedor.entidades.InscripcionDTO;
import cl.exql.mantenedor.facade.Facade;

@WebServlet(name = "PreListarInscripciones", urlPatterns = "/") //Inicia en la url = "/"
public class PreListarInscripciones extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	List<InscripcionDTO> listaInscripcion;
	Facade facade;

	public void init(ServletConfig config) throws ServletException {

		facade = new Facade();
		listaInscripcion = new ArrayList<InscripcionDTO>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			listaInscripcion = facade.obtieneInscripciones();
			request.setAttribute("listaInscripcion", listaInscripcion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listarInscripciones.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("Error: " + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
