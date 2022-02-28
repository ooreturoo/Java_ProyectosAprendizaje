package utiles;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class PropiedadesUtil {
	private static Properties _getPropiedades(InputStream is) throws Exception {
		Properties prop = new Properties();
		prop.load(is);
		return prop;
	}
	
	public static Properties getPropiedades(String propiedades) {
		try {
			FileInputStream fis = new FileInputStream(propiedades);
			return _getPropiedades(fis);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static Properties getPropiedades(Class<?> clazz) {
		String fname = clazz.getName().replace(".", "/");
		fname += ".properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		
		try(InputStream is = loader.getResourceAsStream(fname)) {
			return _getPropiedades(is);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
	

