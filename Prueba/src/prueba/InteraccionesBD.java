package prueba;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InteraccionesBD {

	public static void registrarPuntuacion(String nombre, int puntuacion) throws SQLException {
		
		String sql = "INSERT INTO puntuacion (nombre, puntos, fecha) VALUES (?, ?, NOW())";
		PreparedStatement statement = ConexionBD
									.getConexion()
									.prepareStatement(sql);
		
		statement.setString(1, nombre);
		statement.setLong(2, puntuacion);
		
	}
	
	public static List<Registro> obtenerMejoresPuntuaciones() throws SQLException {
		
		List<Registro> lista = new LinkedList<Registro>();
		
		String sql = "SELECT nombre, MAX(puntuacion), fecha FROM puntuacion GROUP BY nombre";
		
		PreparedStatement statement = ConexionBD.getConexion().prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
			
			String nombre = result.getString(1);
			int puntuacion = result.getInt(2);
			Date fecha = result.getDate(3);
			
			lista.add(new Registro(nombre, puntuacion, fecha));
			
		}
		
		return lista;
		
	}
	
}
