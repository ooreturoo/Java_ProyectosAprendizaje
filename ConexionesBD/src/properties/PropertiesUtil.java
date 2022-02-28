package properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost/akira";
	
	
	public static void crearProperties() {
		Properties prop = new Properties();
		
		prop.setProperty("driver", DRIVER);
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		prop.setProperty("url", URL);
		
		try {
			FileOutputStream fos = new FileOutputStream("PropertiesUtil.properties");
			prop.store(fos, "Archivo Properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	public static Properties getProperties(String nombreArchivo) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(nombreArchivo);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
}
	
