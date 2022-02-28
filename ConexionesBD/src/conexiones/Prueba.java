package conexiones;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Prueba {
	public static void main(String[] args) throws SQLException {
		Connection con = Conexion.establecerConexion();
		PreparedStatement ps = con.prepareStatement("SELECT ? FROM ?");
		ps.executeQuery("first_name");
		ps.executeQuery("actor");
		ResultSet rs = ps.getResultSet();
		while(rs.next()) {
			System.out.println(rs);
		}
		
	}
}
