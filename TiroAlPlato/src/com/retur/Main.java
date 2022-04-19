package com.retur;
	

import com.retur.controlador.ControladorJuego;
import com.retur.modelo.juego.Juego;
import com.retur.vista.VentanaPrincipal;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			AnchorPane anchor = new AnchorPane();
			Scene scene = new Scene(anchor, 1080,720);
			stage.setScene(scene);
			//stage.setMaximized(true);
			stage.show();
			VentanaPrincipal vp = new VentanaPrincipal(anchor);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			scene.setCursor(Cursor.NONE);
			Juego juego = new Juego(vp);
			ControladorJuego.asignarEventos(vp,juego);
			//Añadir menu inicial
			juego.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
