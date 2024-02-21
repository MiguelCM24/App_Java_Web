package pe.edu.galaxy.training.java.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.galaxy.training.java.web.bean.Producto;
import pe.edu.galaxy.training.java.web.util.BDConnection;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public List<Producto> listarTodos() {

		try {
			String sql = "select codigo, nombre,precio,cantidad from producto";

			Connection cn = BDConnection.getConnection();

			PreparedStatement ps = cn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Producto> productos = new ArrayList<>();

			Producto producto;
			while (rs.next()) {

				// Metodo 1
				producto = new Producto();
				producto.setCodigo(rs.getInt("codigo"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCantidad(rs.getInt("cantidad"));
				productos.add(producto);

				// Metodo 2
				/*
				 * productos.add(new Producto(rs.getInt("codigo"), rs.getString("nombre"),
				 * rs.getDouble("precio"), rs.getInt("cantidad")));
				 */
			}

			rs.close();
			ps.close();
			cn.close();

			return productos;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

	}

	@Override
	public Boolean registrar(Producto producto) {
		try {
			String sql = "insert into producto(codigo,nombre,precio,cantidad) values(SEQ_PRODUCTO.nextval, ?,?,?)";
			Connection cn = BDConnection.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, producto.getNombre());
			ps.setDouble(2, producto.getPrecio());
			ps.setInt(3, producto.getCantidad());

			ps.executeUpdate();
			ps.close();
			cn.close();

			return true;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

}
