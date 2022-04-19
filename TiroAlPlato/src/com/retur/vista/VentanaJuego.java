package com.retur.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class VentanaJuego {

	public static final int ANCHO_VENTANA = 1080;
	public static final int ALTO_VENTANA = 720;
	
	public final AnchorPane RAIZ;
	public final Canvas CANVAS;
	
	public VentanaJuego() {
		
		RAIZ  = new AnchorPane();
		CANVAS = new Canvas(ANCHO_VENTANA, ALTO_VENTANA);
		RAIZ.getChildren().add(CANVAS);
		
	}
		
	
}
