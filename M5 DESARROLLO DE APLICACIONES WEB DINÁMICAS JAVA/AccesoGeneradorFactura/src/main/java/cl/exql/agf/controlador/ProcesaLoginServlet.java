package cl.exql.agf.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name="login", urlPatterns = "/")
public class ProcesaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String USER = "admin";
	private final String PASS = "admin";
	
	public void init(ServletConfig config) throws ServletException {	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestLogin = "";
		String requestPass = "";
		
		PrintWriter out = response.getWriter();
		
		requestLogin = request.getParameter("usuario");
		requestPass = request.getParameter("contrasenia");
		
	
		if(!USER.contentEquals(requestLogin) || !PASS.contentEquals(requestPass)) {
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Usuario o password incorrecto');");
		out.println("location='';");
		out.println("</script>");
		}else {
			
		HttpSession sesionUsuario = request.getSession(true);
		sesionUsuario.setAttribute("Nombre", requestLogin);
		out.println("<script type=\"text/javascript\">");
		out.println("location='formulario';");
		out.println("</script>");
		}

		
	}
	
	public void destroy() {

	}

}
