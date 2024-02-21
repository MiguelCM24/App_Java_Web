package pe.edu.java.galaxy.training.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BD {

public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost:3306/cur_000134_java_web";
		//String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			
			//Class.forName("oracle.jdbc.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, "root", "1234");
			//return DriverManager.getConnection(url, "PJM2040423", "123456");

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
