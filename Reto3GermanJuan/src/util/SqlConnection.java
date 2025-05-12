package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	private static String url = "jdbc:mysql://localhost:3306/tienda";
	private static String user = "newuser";
	private static String passwd = "izquierdo";
	private static Connection con;
	
	public static Connection abirConexion() {
		try {
			con = DriverManager.getConnection(url, user, passwd);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void cierraConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
