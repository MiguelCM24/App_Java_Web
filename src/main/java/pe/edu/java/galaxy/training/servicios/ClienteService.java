package pe.edu.java.galaxy.training.servicios;

import java.util.List;
import pe.edu.java.galaxy.training.clases.Cliente;

public interface ClienteService {

	List<Cliente> listar(String razonSocial);

	Boolean registrar(Cliente cliente);
}
