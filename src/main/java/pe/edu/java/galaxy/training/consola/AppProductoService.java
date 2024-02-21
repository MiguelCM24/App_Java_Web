package pe.edu.java.galaxy.training.consola;

import pe.edu.java.galaxy.training.clases.Producto;
import pe.edu.java.galaxy.training.servicios.ProductoService;
import pe.edu.java.galaxy.training.servicios.ProductoServiceImplBD;

public class AppProductoService {
	
	public static void main(String[] args) {
		
		ProductoService productoService= new ProductoServiceImplBD();
		
		//productoService.getProductos().forEach(System.out::println);
		for (Producto producto : productoService.getProductos()) {
			System.out.println(producto);
		}
	}

}
