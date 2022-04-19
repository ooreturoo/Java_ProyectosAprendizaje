package com.retur.vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

public class VentanaPrincipal {

	public final double ANCHO_VENTANA;
	public final double ALTO_VENTANA;
	public final AnchorPane RAIZ;
	public final Canvas CANVAS;
	
	
	public VentanaPrincipal(AnchorPane anchor) {
		RAIZ  = anchor;
		ANCHO_VENTANA = RAIZ.getWidth();
		ALTO_VENTANA = RAIZ.getHeight();
		CANVAS = new Canvas(ANCHO_VENTANA, ALTO_VENTANA);
		RAIZ.getChildren().add(CANVAS);
		
	}
		
	
}
