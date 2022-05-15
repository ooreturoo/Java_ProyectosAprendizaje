package com.retur.pong.modelo.alertas;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {

	public static final void alertaError(String titulo, String texto) {
		
		Alert alerta = new Alert(AlertType.ERROR);
		
		alerta.setTitle(titulo);
		alerta.setHeaderText(null);
		alerta.setContentText(texto);
		
		alerta.show();

	}
	
}
