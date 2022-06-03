package com.miravent.modelo.componentes;


import com.miravent.modelo.interfaces.Movible;
import com.miravent.modelo.interfaces.Pintable;
import com.miravent.modelo.juego.Juego;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * Clase que representa la pelota.
 * @author Sergio
 *
 */
public class Pelota implements Pintable, Movible{

	private static final double VELOCIDAD_INICIAL = 6;
	private static final double INCREMENTO_VELOCIDAD = 0.5;
	private static final int VELOCIDAD_MAXIMA = 10;
	private static final int DECREMENTO_RADIO = 2;
	private static final int RADIO_MINIMO = 8;
	
	
	public static final int RADIO_INICIAL = 19;

	
	
	private double x;
	private double y;
	
	private Rectangle rangoColision;
	private double velocidad;
	private int radio;
	private boolean subir;
	private boolean derecha;
	
	
	public Pelota(Point2D coordenadas) {
		
		this.x = coordenadas.getX();
		this.y = coordenadas.getY();
		this.radio = RADIO_INICIAL;
		this.velocidad =  VELOCIDAD_INICIAL;
		this.rangoColision = crearRangoColision();;
		
	}

	/**
	 * Crea el rango de colisión de la pelota.
	 * @return
	 */
	private Rectangle crearRangoColision() {
		
		return new Rectangle(x, y, radio * 2, radio * 2);
		
	}
	
	
	@Override
	public void mover(Canvas superficieMovimiento) {
		
		if(x <= 0) {
			
			derecha = true;
			
		}else if( (x + radio * 2) >= superficieMovimiento.getWidth()) {
			
			derecha = false;
			
		}
		
		if(y <= 0) {
			
			subir = false;
			
		}
		
		if( y + radio * 2 >= superficieMovimiento.getHeight() ) {
			
			Juego.setIniciado(false);
			
		}else {
			
			if (subir) {
				
				y -= velocidad;
				
			}else if (!subir) {
				
				y += velocidad;
				
			}
			
			if(derecha) {
				
				x += velocidad;
				
			}else if (!derecha) {
				
				x -= velocidad;
				
			}
			
		}

		
		rangoColision.relocate(x, y);
		
	}


	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillOval(x, y, radio * 2, radio * 2);
		
		
		/***Pintar Rango Colision***
		 *
		 *gc.setStroke(Color.RED);
		 *gc.strokeRect(x, y, radio*2, radio*2);
		 */
	}
	
	
	/**
	 * Incrementa la velocidad de la pelota.
	 */
	public void incrementarVelocidad() {
		
		if(velocidad < VELOCIDAD_MAXIMA) {
			
			velocidad += INCREMENTO_VELOCIDAD;
			
		}
		
	}
	
	/**
	 * Decrementa el radio de la pelota.
	 */
	public void decrementarRadio() {
		
		if(radio > RADIO_MINIMO) {
			
			radio -= DECREMENTO_RADIO;
			rangoColision = crearRangoColision();
			
		}
		
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}


	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}

	public Rectangle getRangoColision() {
		return rangoColision;
	}

	
}
