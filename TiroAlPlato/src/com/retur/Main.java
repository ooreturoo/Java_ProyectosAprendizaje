package com.retur;
	

import com.retur.controlador.ControladorJuego;
import com.retur.modelo.juego.Juego;
import com.retur.vista.VentanaJuego;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			VentanaJuego vj = new VentanaJuego();
			Scene scene = new Scene(vj.RAIZ);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.setCursor(Cursor.NONE);
			Juego juego = new Juego(vj.CANVAS.getGraphicsContext2D());
			ControladorJuego.asignarEventos(vj,juego);
			juego.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
