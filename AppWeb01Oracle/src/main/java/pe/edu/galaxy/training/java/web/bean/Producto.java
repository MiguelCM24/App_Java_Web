package pe.edu.galaxy.training.java.web.bean;

public class Producto {

	private Integer codigo;
	private String	nombre;
	private Double  precio;
	private Integer cantidad;
	private String	estado;
	
	public Producto() {
		super();
	}

	public Producto(Integer codigo, String nombre, Double precio, Integer cantidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", cantidad=" + cantidad
				+ ", estado=" + estado + "]";
	}
}
