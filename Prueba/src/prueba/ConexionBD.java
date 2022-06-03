package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	private static final String URL = "jdbc:mysql://localhost:3306/pong";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection conexion;
	
	static {
		
		try {
			
			conexion = DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void cerrarConexion() throws SQLException {
		
		conexion.close();
		
	}

	public static Connection getConexion() {
		return conexion;
	}

	
	
}
