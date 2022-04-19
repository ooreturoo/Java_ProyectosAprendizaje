package com.retur.modelo.juego.clases;

import java.io.File;

import com.retur.vista.VentanaPrincipal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fondo {

	private final String DIR_IMAGEN;
	private final double ALTO;
	private final double ANCHO;
	private final Image IMAGEN;
	
	
	public Fondo(VentanaPrincipal vp) {
		
		this.ANCHO = vp.ANCHO_VENTANA;
		this.ALTO = vp.ALTO_VENTANA;
		this.DIR_IMAGEN = "./src/resources/cielo.jpg";
		this.IMAGEN = new Image(new File(DIR_IMAGEN).toURI().toString(), ANCHO, ALTO , false, false);
		
	}
	
	public void pintar(GraphicsContext gc) {
		
		gc.drawImage(IMAGEN, 0, 0);
		
	}
	
}
