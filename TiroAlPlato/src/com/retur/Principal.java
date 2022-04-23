package com.retur;
	

import com.retur.controlador.ControladorPrincipal;
import com.retur.controlador.ControladorPuntuacion;
import com.retur.modelo.juego.clases.Jugador;
import com.retur.vista.VentanaJuego;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Principal extends Application {
	
	
	@Override
	public void start(Stage stage) {
		try {
		
			/*
			 * Se le asigna un primera escena vacía para poder luego obtener las medidas que se le asignan a las escenas
			 * por defecto a partir del tamaño del stage.
			 */
			stage.setScene(new Scene(new AnchorPane()));
			//Se maximiza la ventana.
			stage.setMaximized(true);
			stage.show();
			
			//Se crea un objeto del controlador de la ventana principal y se muestra en el stage.
			new ControladorPrincipal(stage).mostrarVentanaPrincipal(stage);
			
			//TODO Para comprobar la ventana de puntuacion.
			//ControladorPuntuacion controlador = new ControladorPuntuacion(stage);
			//controlador.mostrarPuntuacion(new Jugador(new VentanaJuego(stage.getScene().getWidth(), stage.getScene().getHeight())));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
