package pe.edu.galaxy.training.java.web.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pe.edu.galaxy.training.java.web.bean.Producto;
import pe.edu.galaxy.training.java.web.dao.ProductoDAO;
import pe.edu.galaxy.training.java.web.dao.ProductoDAOImpl;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ProductoServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Java Web Servlet").append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost ...");
		System.out.println(request.getParameter("txtNombre"));

		Producto producto = new Producto();
		producto.setNombre(request.getParameter("txtNombre"));
		producto.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));
		producto.setCantidad(Integer.parseInt(request.getParameter("txtCantidad")));

		ProductoDAO productoDAO = new ProductoDAOImpl();

		String page = "/producto_registro.jsp";

		if (productoDAO.registrar(producto)) {
			page = "/producto_listado.jsp";
		}
		response.sendRedirect(request.getContextPath().concat(page));
	}

}
