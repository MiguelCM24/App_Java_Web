package pe.edu.java.galaxy.training.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.java.galaxy.training.clases.Cliente;
import pe.edu.java.galaxy.training.util.BD;

public class ClienteServiceImpl implements ClienteService{

	@Override
	public List<Cliente> listar(String razonSocial) {

		String sql = "SELECT CLIENTE_ID,RAZON_SOCIAL,RUC FROM CLIENTE WHERE UPPER(RAZON_SOCIAL) LIKE UPPER(?)";
		List<Cliente> clientes = null;
		
		try {
			Connection cn = BD.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, "%"+razonSocial+"%");
			ResultSet rs = ps.executeQuery();

			clientes = new ArrayList<Cliente>();

			while (rs.next()) {
				clientes.add(new Cliente(rs.getInt("CLIENTE_ID"),rs.getString("RAZON_SOCIAL"), rs.getString("RUC")));
			}
			rs.close();
			ps.close();
			cn.close();
			return clientes;
		} catch (Exception e) {
			System.err.println("Error al consultar clientes" + e.getMessage());
			return null;
		}
	}

	@Override
	public Boolean registrar(Cliente cliente) {

		String sql = "INSERT INTO CLIENTE(CLIENTE_ID,RAZON_SOCIAL,RUC)VALUES(SEQ_CLIENTE.NEXTVAL, ?,?)";
		try {
			Connection cn = BD.getConnection();
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, cliente.getRazonSocial());
			ps.setString(2, cliente.getRuc());
			
			int x=ps.executeUpdate();

			ps.close();
			cn.close();
			return x>0;
		} catch (Exception e) {
			System.err.println("Error al registrar clientes" + e.getMessage());
			return null;
		}
	}
}
