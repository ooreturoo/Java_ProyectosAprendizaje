package conexiones;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.Properties;
import properties.PropertiesUtil;

public class Conexion {
	private static Properties prop = null;
	
	static {
		Path path = Paths.get("./PropertiesUtil.properties");
		if(Files.notExists(path)) {
			PropertiesUtil.crearProperties();
		}
		prop = PropertiesUtil.getProperties(path.toString());
		String drv = prop.getProperty("driver");
		drv.getClass();
	}
	
	
	
	
	public static Connection establecerConexion() {
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		//String driver = prop.getProperty("driver");
	
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
}
