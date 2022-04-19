package com.retur.modelo.clases;

import java.io.File;

import com.retur.vista.VentanaJuego;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fondo {

	private final String DIR_IMAGEN;
	private final int ALTO;
	private final int ANCHO;
	private final Image IMAGEN;
	
	
	public Fondo() {
		
		this.ALTO = VentanaJuego.ALTO_VENTANA;
		this.ANCHO = VentanaJuego.ANCHO_VENTANA;
		this.DIR_IMAGEN = "./src/resources/cielo.jpg";
		this.IMAGEN = new Image(new File(DIR_IMAGEN).toURI().toString(), ANCHO, ALTO , false, false);
		
	}
	
	public void pintar(GraphicsContext gc) {
		
		gc.drawImage(IMAGEN, 0, 0);
		
	}
	
}
