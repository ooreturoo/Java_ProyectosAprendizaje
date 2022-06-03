package com.retur.pong;
	
import com.retur.pong.controlador.ControladorVentanaPrincipal;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		
		try {
			
			ControladorVentanaPrincipal controladorVP = new ControladorVentanaPrincipal();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(controladorVP.VISTA_PRINCIPAL.ESCENA_INICIO);
			stage.setResizable(false);
			stage.show();
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
