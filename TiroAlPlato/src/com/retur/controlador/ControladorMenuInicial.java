package com.retur.controlador;


import com.retur.vista.VentanaPrincipal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladorMenuInicial {

	private final VentanaPrincipal VP;
	private final Stage STAGE;
	
	public ControladorMenuInicial(Stage stage) {
		
		STAGE = stage;
		VP = new VentanaPrincipal((AnchorPane) STAGE.getScene().getRoot());
		eventoInicioJuego();
		
	}
	
	private void eventoInicioJuego() {
		
		VP.BOTON_START.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				
				Node nodo = (Node) e.getTarget();
				Stage stage = (Stage) nodo.getScene().getWindow();
				ControladorJuego controlador = new ControladorJuego(stage);
				stage.setScene(controlador.VJ.ESCENA_JUEGO);
				controlador.iniciarJuego();
				
			}
		});
		
	}
	
}
