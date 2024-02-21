package pe.edu.java.galaxy.training.servicios;

import java.util.List;
import pe.edu.java.galaxy.training.clases.Producto;

public interface ProductoService {
		
	List<Producto> getProductos();
	
	List<Producto> buscar(String nombre);
	
	Producto getProducto(Long id);
	
	Producto findByCodigo(Long codigo);
	
	boolean insertar(Producto producto);
	
	boolean actualizar(Producto producto);
	
	boolean eliminar (Producto producto);
}
