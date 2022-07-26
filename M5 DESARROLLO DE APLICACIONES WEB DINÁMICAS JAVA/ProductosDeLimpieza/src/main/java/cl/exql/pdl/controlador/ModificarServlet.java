package cl.exql.pdl.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.exql.pdl.dao.CategoriaDaoImpl;
import cl.exql.pdl.dao.ProductoDaoImpl;
import cl.exql.pdl.modelo.Categoria;
import cl.exql.pdl.modelo.Producto;

@WebServlet(name = "ModificarServlet", urlPatterns = "/modificar")
public class ModificarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductoDaoImpl pdi;
	private CategoriaDaoImpl cdi;

	public void init() throws ServletException {

		pdi = new ProductoDaoImpl();
		cdi = new CategoriaDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Producto producto = pdi.obtenerProducto(Integer.parseInt(request.getParameter("idProducto")));
		request.setAttribute("producto", producto);
		List<Categoria> listaCategorias = cdi.listarCategorias();
		request.setAttribute("listaCategorias", listaCategorias);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modificar.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Producto producto = new Producto();
		producto.setNombreProducto(request.getParameter("nombreProducto"));
		producto.setPrecioProducto(Integer.parseInt(request.getParameter("precioProducto")));
		producto.setDescripcionProducto(request.getParameter("descripcionProducto"));
		producto.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
		producto.setIdProducto(Integer.parseInt(request.getParameter("idProducto")));
		pdi.modificarProducto(producto);
		response.sendRedirect("listar");
	}
}