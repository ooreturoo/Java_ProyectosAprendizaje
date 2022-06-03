package com.miravent.controlador;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Controlador de la ventana inicial que se muestra al iniciar la aplicación.
 * @author Sergio
 *
 */
public class ControladorPrincipal {
	
	/**
	 * Cambia a la ventana de juego.
	 * @param event
	 */
	@FXML
	private void jugar(ActionEvent event) {
		
		//Se obtiene el stage a partir del disparador del evento.
		Node nodo =  (Node) event.getSource();
		Stage stage = (Stage) nodo.getScene().getWindow();
		
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/com/miravent/vista/VentanaJuego.fxml"));
			stage.setScene(new Scene(root));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
