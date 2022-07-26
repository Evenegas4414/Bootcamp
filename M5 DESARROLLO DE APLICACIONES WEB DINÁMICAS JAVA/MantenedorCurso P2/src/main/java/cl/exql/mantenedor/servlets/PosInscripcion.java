package cl.exql.mantenedor.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.mantenedor.entidades.InscripcionDTO;
import cl.exql.mantenedor.facade.Facade;

@WebServlet(name = "PosInscripcion", urlPatterns = "/PosInscripcion")
public class PosInscripcion extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Facade facade;

	public void init(ServletConfig config) throws ServletException {

		facade = new Facade();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InscripcionDTO dto = new InscripcionDTO();

		dto.setNombre(request.getParameter("nombre"));
		dto.setTelefono(request.getParameter("telefono"));
		dto.setIdCurso(request.getParameter("idCurso"));
		dto.setIdFormaPago(request.getParameter("idFormaPago"));

		try {
			facade.registrarInscripcion(dto);
			request.setAttribute("inscripcion", dto);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("/PreConfirmacion");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
