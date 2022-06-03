package prueba;

import java.sql.SQLException;
import java.util.List;

public class Prueba {

	public static void main(String[] args) {
		
		try {
			
			List<Registro> lista = InteraccionesBD.obtenerMejoresPuntuaciones();
			
			lista.stream().forEach(System.out::println);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
}
