package com.retur.vista;

import java.io.File;

import javafx.scene.control.Button;

public abstract class VentanaMenu extends Ventana{
	
	
	protected static final int DIMENSION_FUENTE_BOTON = 30;
	protected static final int DIMENSION_FUENTE_TITULO = 50;
	
	public final Button BOTON;

	public VentanaMenu(double anchoVentana, double altoVentana) {
		super(anchoVentana, altoVentana);
		
		ESCENA.getStylesheets().add(new File("src/resources/application.css").toURI().toString());
		BOTON = crearBoton();
		RAIZ.getChildren().add(BOTON);
		
	}

	protected abstract Button crearBoton();
	protected abstract void crearTitulo();
}
