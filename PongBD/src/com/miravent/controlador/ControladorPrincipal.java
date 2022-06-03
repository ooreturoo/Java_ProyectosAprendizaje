package com.miravent.controlador;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorPrincipal {
	
	@FXML
	private void jugar(ActionEvent event) {
		
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
