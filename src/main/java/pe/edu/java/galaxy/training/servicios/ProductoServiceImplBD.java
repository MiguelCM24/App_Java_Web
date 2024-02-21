package pe.edu.java.galaxy.training.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pe.edu.java.galaxy.training.clases.Producto;
import pe.edu.java.galaxy.training.util.BD;

public class ProductoServiceImplBD implements ProductoService {

	@Override
	public List<Producto> getProductos() {

		String sql = "select codigo, nombre, precio, cantidad, estado " + "from producto where estado='1'";
		List<Producto> productos = null;

		try {
			Connection cn = BD.getConnection();
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			productos = new ArrayList<Producto>();
			while (rs.next()) {
				productos.add(new Producto(rs.getLong("codigo"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getInt("cantidad")));
			}
			rs.close();
			st.close();
			cn.close();
			return productos;
		} catch (Exception e) {
			System.err.println("Error al consultar productos" + e.getMessage());
			return null;
		}
	}

	@Override
	public Producto findByCodigo(Long codigo) {
		String sql = "select codigo, nombre, precio, cantidad, estado " + "from producto where codigo= ? and estado='1'";

		try {
			Connection cn = BD.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setLong(1, codigo);
			ResultSet rs = ps.executeQuery();

			Producto producto = new Producto();

			if (rs.next()) {
				producto = new Producto(rs.getLong("codigo"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getInt("cantidad"));
			}
			rs.close();
			ps.close();
			cn.close();
			return producto;
		} catch (Exception e) {
			System.err.println("Error al buscar productos" + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean insertar(Producto producto) {
		String sql = "insert into producto(nombre, precio, cantidad) " + "values(?,?,?)";

		try (Connection cn = BD.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, producto.getNombre());
			ps.setDouble(2, producto.getPrecio());
			ps.setInt(3, producto.getCantidad());

			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			System.err.println("Error al insertar producto" + e.getMessage());
			return false;
		}
	}

	@Override
	public List<Producto> buscar(String nombre) {
		String sql = "select codigo, nombre, precio, cantidad, estado" + " from producto where upper(nombre) like upper(?) and estado='1'";

		List<Producto> productos = null;

		try {
			Connection cn = BD.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "%" + nombre + "%");
			ResultSet rs = ps.executeQuery();
			productos = new ArrayList<Producto>();

			while (rs.next()) {
				productos.add(new Producto(rs.getLong("codigo"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("cantidad")));
			}

			rs.close();
			ps.close();
			cn.close();

			return productos;

		} catch (Exception e) {
			System.err.println("Error al buscar productos" + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean actualizar(Producto producto) {
		String sql = "update producto set nombre=?, precio=?, cantidad=? where codigo=?";

		try (Connection cn = BD.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {

			ps.setString(1, producto.getNombre());
			ps.setDouble(2, producto.getPrecio());
			ps.setInt(3, producto.getCantidad());
			ps.setLong(4, producto.getCodigo());

			ps.executeUpdate();

			return true;
			
		} catch (Exception e) {
			System.err.println("Error al insertar producto" + e.getMessage());
			return false;
		}
	}

	@Override
	public Producto getProducto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminar(Producto producto) {
		String sql = "delete from producto where codigo = ? and estado='1'";

		try {
			Connection cn = BD.getConnection(); 
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setLong(1, producto.getCodigo());
			ps.executeUpdate();

			return true;

		} catch (Exception e) {
			System.err.println("Error al eliminar producto" + e.getMessage());
			return false;
		}
	}

}
