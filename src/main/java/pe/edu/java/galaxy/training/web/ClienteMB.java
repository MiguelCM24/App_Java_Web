package pe.edu.java.galaxy.training.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.java.galaxy.training.clases.Cliente;
import pe.edu.java.galaxy.training.servicios.ClienteService;
import pe.edu.java.galaxy.training.servicios.ClienteServiceImpl;

@ManagedBean(name = "clienteMB")
@SessionScoped
public class ClienteMB {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Cliente cliente = new Cliente();
	private ClienteService clienteService = new ClienteServiceImpl();
	private String prmRazonSocial;

	public void listar() {
		clientes = clienteService.listar(this.prmRazonSocial);
		//clientes.forEach(System.out::println);
	}

	public String nuevo() {
		cliente = new Cliente();
		return "cliente_registro";
	}

	public String cancelar() {
		cliente = new Cliente();
		return "cliente_listado";
	}

	public void registrar() {
		Boolean sw = clienteService.registrar(cliente);
		if (sw) {
			System.out.println("Cliente registrado");

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Cliente registrado"));
		}
	}

	public List<Cliente> getClientes() {
		this.listar();
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getPrmRazonSocial() {
		return prmRazonSocial;
	}

	public void setPrmRazonSocial(String prmRazonSocial) {
		this.prmRazonSocial = prmRazonSocial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
