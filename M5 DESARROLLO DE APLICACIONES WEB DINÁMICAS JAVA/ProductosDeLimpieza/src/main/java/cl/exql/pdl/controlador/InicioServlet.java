package cl.exql.pdl.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InicioServlet", urlPatterns = "/")
public class InicioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String EMAIL = "admin@email.cl";
	private final String PASS = "admin";

	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/inicio.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestEmail = "";
		String requestPass = "";
		requestEmail = request.getParameter("correo");
		requestPass = request.getParameter("contra");
		PrintWriter out = response.getWriter();		
		if (EMAIL.equals(requestEmail) && PASS.equals(requestPass)) {
			response.sendRedirect("listar"); 
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Correo electrónico o contraseña incorrectas.');");
			out.println("location='';");
			out.println("</script>");
		}
	}
}