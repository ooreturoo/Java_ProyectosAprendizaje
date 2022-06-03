package com.miravent.modelo.componentes.alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {

	public static void crearAlertaError(String titulo, String texto) {
		
		Alert alerta = new Alert(AlertType.ERROR);
		alerta.setHeaderText(null);
		alerta.setTitle(titulo);
		alerta.setContentText(texto);
		alerta.show();
		
	}

	public static void crearAlertaInformacion(String titulo, String texto) {
		
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setHeaderText(null);
		alerta.setTitle(titulo);
		alerta.setContentText(texto);
		alerta.show();
		
	}
	
}
