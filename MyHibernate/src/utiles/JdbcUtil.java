package utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcUtil {
	private static Connection con = null;
	private static Properties prop = null;
	
	static {//Establecer el Driver.
		prop = PropiedadesUtil.getPropiedades(JdbcUtil.class);
		String drv = prop.getProperty("drv");
		drv.getClass();
	}
	
	public static Connection getConnection() {//Establecer conexion.
		try {
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String psw = prop.getProperty("psw");
			con = DriverManager.getConnection(url,user,psw);
			return con;
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	public static void closeClonnection(ResultSet rs, PreparedStatement pstm, Connection con) {//Cerrar conexiones.
		try {
			if(rs != null) {
				rs.close();	
			}
			if(pstm != null) {
				pstm.close();
			}
			if(con !=null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
