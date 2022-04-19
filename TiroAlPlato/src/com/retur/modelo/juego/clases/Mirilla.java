package com.retur.modelo.juego.clases;

import java.io.File;

import com.retur.vista.VentanaPrincipal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Mirilla {

	private static final int DIMENSION_IMAGEN = 30;
	private static final double LOCALIZACION_CENTRO_MIRILLA = DIMENSION_IMAGEN / 4.0;
	private static final double DIMENSION_CENTRO_CURSOR = DIMENSION_IMAGEN / 2.0;
	private static final Image cursorJugador = new Image(new File("./src/resources/mirilla.png").toURI().toString(),
			DIMENSION_IMAGEN,
			DIMENSION_IMAGEN,
			true,
			true);
	
	private final double ANCHO_VENTANA;
	private final double ALTO_VENTANA;
	
	
	private Disparo disparo;
	private boolean disparoDisponible;
	private long ultimoDisparo;
	private double x;
	private double y;
	
	
	public Mirilla(VentanaPrincipal vp) {
		
		ANCHO_VENTANA = vp.ANCHO_VENTANA;
		ALTO_VENTANA = vp.ALTO_VENTANA;
		ultimoDisparo = System.currentTimeMillis();
		
	}
	
	
	public void mover(double x, double y) {
		
		if((x - DIMENSION_CENTRO_CURSOR) >= 0 && (x + DIMENSION_CENTRO_CURSOR) <= ANCHO_VENTANA) {
			
			this.x = x - DIMENSION_CENTRO_CURSOR;
			
		}
		
		if((y - DIMENSION_CENTRO_CURSOR) >= 0 && (y + DIMENSION_CENTRO_CURSOR) <= ALTO_VENTANA) {
			
			this.y = y - DIMENSION_CENTRO_CURSOR;
			
		}
		
	}
	
	public void regargaDisparo() {
		
		long tiempoActual = System.currentTimeMillis();
		
		if(tiempoActual - ultimoDisparo >= 100) {
			disparoDisponible = true;
		}
		
	}
	
	public void disparar() {
		
		if(disparoDisponible) {
			
			disparo = new Disparo();
			disparo.setRangoColision(crearRangoDisparo());
			disparo.start();
			disparoDisponible = false;
			ultimoDisparo = System.currentTimeMillis();
		}
		
	}
	
	public void pintar(GraphicsContext gc) {
		
		gc.setStroke(Color.DARKRED);
		gc.strokeRect((x + LOCALIZACION_CENTRO_MIRILLA), (y + LOCALIZACION_CENTRO_MIRILLA), 
				DIMENSION_CENTRO_CURSOR, DIMENSION_CENTRO_CURSOR);
		gc.drawImage(cursorJugador, x, y);
		
	}
	
	
	private Rectangle crearRangoDisparo() {
		
		return new Rectangle((x + LOCALIZACION_CENTRO_MIRILLA), (y + LOCALIZACION_CENTRO_MIRILLA), 
				DIMENSION_CENTRO_CURSOR, DIMENSION_CENTRO_CURSOR);
		
	}


	public Disparo getDisparo() {
		return disparo;
	}

	
}
