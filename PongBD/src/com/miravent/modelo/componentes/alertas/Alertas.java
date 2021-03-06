package com.miravent.modelo.componentes.alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * Crea y muestra alertas en ventanas emergentes.
 * @author Sergio
 *
 */
public class Alertas {

	/**
	 * Crea y muestra una alerta de error.
	 * @param titulo
	 * @param texto
	 */
	public static void crearAlertaError(String titulo, String texto) {
		
		Alert alerta = new Alert(AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle(titulo);
		alerta.setContentText(texto);
		alerta.showAndWait();
		
	}

	/**
	 * Crea y muestra una alerta de información.
	 * @param titulo
	 * @param texto
	 */
	public static void crearAlertaInformacion(String titulo, String texto) {
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setHeaderText(null);
		alerta.setTitle(titulo);
		alerta.setContentText(texto);
		alerta.show();
		
	}
	
}
