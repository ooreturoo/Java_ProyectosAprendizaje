package com.retur.vista;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public abstract class Ventana {

	public final double ANCHO_VENTANA;
	public final double ALTO_VENTANA;
	protected final AnchorPane RAIZ;
	public final Scene ESCENA;
	
	
	public Ventana(double anchoVentana, double altoVentana) {
		
		ANCHO_VENTANA = anchoVentana;
		ALTO_VENTANA = altoVentana;
		RAIZ = new AnchorPane();
		ESCENA = new Scene(RAIZ, anchoVentana, altoVentana);
		
	}
	
}
