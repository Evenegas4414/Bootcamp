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

import cl.exql.mantenedor.entidades.CursoDTO;
import cl.exql.mantenedor.entidades.FormaPagoDTO;
import cl.exql.mantenedor.facade.Facade;

@WebServlet(name = "PreInscripcion", urlPatterns = "/PreInscripcion") 
public class PreInscripcion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	List<CursoDTO> listaCursos;
	List<FormaPagoDTO> listaFormasPago;
	Facade facade;
	
	public void init(ServletConfig config) throws ServletException {

		facade = new Facade();
		listaCursos = new ArrayList<CursoDTO>();
		listaFormasPago = new ArrayList<FormaPagoDTO>();		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listaCursos = facade.obtenerCursos();
			listaFormasPago = facade.obtenerFormasDePago();			
			request.setAttribute("listaCursos", listaCursos);
			request.setAttribute("listaFormasPago", listaFormasPago);
			RequestDispatcher dispatcher =	request.getRequestDispatcher("inscripcion.jsp");
			dispatcher.forward(request, response);			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("Error: " + e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}