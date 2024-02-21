package pe.edu.galaxy.training.java.web.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BDConnection {

	public static Connection getConnection() {

		// String url = "jdbc:mysql://localhost:3306/bd_producto";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {

			Class.forName("oracle.jdbc.OracleDriver");
			// return DriverManager.getConnection(url, "root", "123456");
			return DriverManager.getConnection(url, "CURS-000134-JAVAWEB", "123456");

		} catch (Exception e) {
			System.err.println("Error al conectar BD " + e.getMessage());
			return null;
		}
	}

	public static Connection getConnection(String url, String user, String psw) {
		try {

			return DriverManager.getConnection(url, user, psw);

		} catch (Exception e) {
			System.err.println("Error al conectar BD " + e.getMessage());
			return null;
		}
	}
}
