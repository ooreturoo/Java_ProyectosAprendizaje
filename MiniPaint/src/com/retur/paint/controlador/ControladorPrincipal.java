package com.retur.paint.controlador;



import com.retur.paint.objetos.Lienzo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;

public class ControladorPrincipal {
	
	private Lienzo lienzo;
	
	@FXML
	private MenuItem nuevoLienzo;
	
	@FXML
	private ScrollPane zonaLienzo;
	
	@FXML
	private void crearLienzo(ActionEvent e) {
		
		lienzo = new Lienzo(500, 500, zonaLienzo);
		
		
	};
	
	
}
