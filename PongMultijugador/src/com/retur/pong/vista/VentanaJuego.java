package com.retur.pong.vista;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class VentanaJuego {

	public final Scene ESCENA_JUEGO;
	private final AnchorPane RAIZ;
	public final Canvas CANVAS;
	
	
	public VentanaJuego() {
		
		this.RAIZ = new AnchorPane();
		this.ESCENA_JUEGO = new Scene(RAIZ, VentanaPrincipal.ANCHO_VENTANA, VentanaPrincipal.ALTO_VENTANA);
		this.CANVAS = new Canvas(VentanaPrincipal.ANCHO_VENTANA, VentanaPrincipal.ALTO_VENTANA);
		
		RAIZ.getChildren().add(CANVAS);
	}
	
}
