package com.retur.controlador;



import com.retur.modelo.juego.clases.Jugador;
import com.retur.vista.VentanaPuntuacion;

import javafx.stage.Stage;


/**
 * Controla el cambio de escena al acabar el juego y muestra la puntuación obtenida.
 * @author Sergio
 */
public class ControladorPuntuacion {
	
	private final VentanaPuntuacion VPNT;
	

	public ControladorPuntuacion(Stage stage) {
		
		VPNT = new VentanaPuntuacion(stage.getScene().getWidth(), stage.getScene().getHeight());

	}
	
	/**
	 * Muestra la escena con la puntuación obtenida.
	 * @param jugador Jugador que ha obtenido la puntuación.
	 * @param stage Ventana donde se cambiará la escena.
	 */
	public void mostrarPuntuacion(Jugador jugador, Stage stage) {
		
		VPNT.mostrarPuntuacion(jugador);
		stage.setScene(VPNT.ESCENA);
		
	}

	
}
