package com.retur.modelo.juego.clases;

import java.io.File;

import com.retur.vista.VentanaJuego;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fondo {

	private final String DIR_IMAGEN;
	private final Image IMAGEN;
	
	
	public Fondo(VentanaJuego vj) {
		
		this.DIR_IMAGEN = "./src/resources/cielo.jpg";
		this.IMAGEN = new Image(new File(DIR_IMAGEN).toURI().toString(),
				vj.ANCHO_VENTANA_JUEGO,
				vj.ALTO_VENTANA_JUEGO,
				false,
				false);
		
	}
	
	public void pintar(GraphicsContext gc) {
		
		gc.drawImage(IMAGEN, 0, 0);
		
	}
	
}
