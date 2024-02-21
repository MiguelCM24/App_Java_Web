package pe.edu.java.galaxy.training.clases;

public class Cliente {

	private Integer id;
	private String razonSocial;
	private String ruc;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String razonSocial) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
	}
	
	public Cliente(Integer id, String razonSocial, String ruc) {
		super();
		this.id = id;
		this.razonSocial = razonSocial;
		this.ruc=ruc;
	}

	public Integer getId() {
		return id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", razonSocial=" + razonSocial + "]";
	}

}
