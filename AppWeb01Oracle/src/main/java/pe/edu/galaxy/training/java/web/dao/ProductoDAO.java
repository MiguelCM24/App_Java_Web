package pe.edu.galaxy.training.java.web.dao;


import java.util.List;
import pe.edu.galaxy.training.java.web.bean.Producto;

public interface ProductoDAO {

	List<Producto> listarTodos();
	
	Boolean registrar(Producto producto);
	
	
}
