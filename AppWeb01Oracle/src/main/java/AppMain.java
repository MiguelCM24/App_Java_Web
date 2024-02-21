import java.time.LocalDate;
import java.util.List;

import pe.edu.galaxy.training.java.web.bean.Producto;
import pe.edu.galaxy.training.java.web.dao.ProductoDAO;
import pe.edu.galaxy.training.java.web.dao.ProductoDAOImpl;

public class AppMain {

	public static void main(String[] args) {
		
		System.out.println("Ok");
		
		System.out.println(LocalDate.now());

		ProductoDAO productoDAO = new ProductoDAOImpl();
		//productoDAO.listarTodos().forEach(System.out::println);

		
		Producto producto= new Producto();
		producto.setNombre("Televisor Panasonic 69");
		producto.setPrecio(11_000.00);
		producto.setCantidad(1);
		
		productoDAO.registrar(producto);
		
		
		List<Producto> productos= productoDAO.listarTodos();
		for (Producto prod: productos) {
			System.out.println(prod);
		}
		
	}

}
