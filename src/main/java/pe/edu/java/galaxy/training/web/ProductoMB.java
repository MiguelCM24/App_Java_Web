package pe.edu.java.galaxy.training.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.java.galaxy.training.clases.Producto;
import pe.edu.java.galaxy.training.servicios.ProductoService;
import pe.edu.java.galaxy.training.servicios.ProductoServiceImplBD;

@ManagedBean(name="productoMB")
@SessionScoped
public class ProductoMB {

	private List<Producto> productos;
	
	private Producto producto;
	
	ProductoService productoService = new ProductoServiceImplBD();
	
	public ProductoMB(){
		this.producto = new Producto();
		this.buscar();
	}
	
	public void buscar() {
		System.out.println(this.producto.getNombre());
		this.productos=productoService.buscar(this.producto.getNombre());		
	}

	public String nuevo() {
		return "producto_registro";
	}
	
	public String editar(Producto producto) {
		this.producto = this.productoService.findByCodigo(producto.getCodigo());
		return "producto_registro";
	}
	
	public String eliminar(Producto producto) {
		if (this.productoService.eliminar(producto)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exito al Eliminar"));
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al Eliminar"));
		}
		
		//this.producto = new Producto();
		this.buscar();
		return "producto_listado";
	}
	
	public String cancelar() {
		this.producto = new Producto();
		this.buscar();
		return "producto_listado";
	}
	
	public void grabar() {
		if (producto.getCodigo()>0) {
			if(this.productoService.actualizar(producto)){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exito al actualizar"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al actualizar"));
			}
		} else {
			if(this.productoService.insertar(producto)){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Exito al registrar"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error al registrar"));
			}
		}
	}
	
	public void listar() {
		 setProductos(productoService.getProductos());	
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
