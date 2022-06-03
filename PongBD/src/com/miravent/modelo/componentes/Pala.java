package com.miravent.modelo.componentes;


import com.miravent.modelo.interfaces.Movible;
import com.miravent.modelo.interfaces.Pintable;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Pala implements Pintable, Movible{

	private static final double VELOCIDAD_INICIAL = 4.5;
	private static final double INCREMENTO_VELOCIDAD = 2.5;
	private static final int VELOCIDAD_MAXIMA = 9;
	private static final int LONGITUD_MINIMA = 65;
	private static final int DECREMENTO_LONGITUD = 10;
	
	public static final double ANCHO = 8;
	public static final double LONGITUD_INICIAL = 100;
	
	private final double COORDENADA_X_INICIAL;
	private final double Y;

	private double x;
	private Rectangle[] rangosColision;
	private boolean derecha;
	private boolean izquierda;
	private double velocidad;
	private double longitud;
	
	
	public Pala(Point2D coordenadas) {
		
		this.Y = coordenadas.getY();
		this.x = coordenadas.getX();
		this.COORDENADA_X_INICIAL = x;
		this.velocidad = VELOCIDAD_INICIAL;
		this.longitud = LONGITUD_INICIAL;
		this.rangosColision = crearRangosPala();
		
		
	}
	
	
	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillRect(x, Y, longitud, ANCHO);
		
		//***Pintar Rango Colision***
		 //gc.setStroke(Color.RED);
		// gc.strokeRect(rangosColision[0].getX(), rangosColision[0].getY(), rangosColision[0].getWidth(), rangosColision[0].getHeight());
		 //gc.strokeRect(rangosColision[1].getX(), rangosColision[1].getY(), rangosColision[1].getWidth(), rangosColision[1].getHeight());
		
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		double largoLimite = superficieMovimiento.getWidth();
		
		if(izquierda && x >= 0) {
			
			x = x - velocidad < 0 ? 0 : x - velocidad;
						
		}else if(derecha && x + longitud <= largoLimite) {
			
			x = ((x + longitud) + velocidad) > largoLimite ? largoLimite - longitud : x + velocidad;
			
		}
		
		rangosColision[0].setX(x);
		rangosColision[1].setX(x + longitud/2);
		
	}
	
	
	public boolean golpeo(Pelota pelota) {
		
		boolean golpeado = false;
		
		Bounds golpeoIzquierda = Shape.intersect(rangosColision[0], pelota.getRangoColision()).getLayoutBounds();
		Bounds golpeoDerecha = Shape.intersect(rangosColision[1], pelota.getRangoColision()).getLayoutBounds();
		if(golpeoIzquierda.getHeight() != -1 && golpeoDerecha.getHeight() != -1) {
			
			if(golpeoIzquierda.getWidth() > golpeoDerecha.getWidth()) {
				
				golpeoIzquierda(pelota);
				
			}else {
				
				golpeoDerecha(pelota);
				
				
			}
			
			golpeado = true;
			
		}else if(golpeoIzquierda.getWidth() != -1) {
			
			golpeoIzquierda(pelota);
			
			golpeado = true;
			
		}else if(golpeoDerecha.getHeight() != -1){
			
			golpeoDerecha(pelota);
			
			golpeado = true;
			
		}
		
		return golpeado;
		
	}
	
	private void golpeoIzquierda(Pelota pelota) {
		
		pelota.setDerecha(false);
		
		pelota.setSubir(true);
		
	}
	
	private void golpeoDerecha(Pelota pelota) {
		
		pelota.setDerecha(true);
		
		pelota.setSubir(true);
		
	}
	
	private Rectangle[] crearRangosPala() {
		
		Rectangle[] rangos = new Rectangle[2];
		
		rangos[0] = new Rectangle(x, Y, longitud/2, ANCHO);
		rangos[1] = new Rectangle((x + longitud/2), Y, longitud/2, ANCHO);
		
		return rangos;
		
	}
	
	public void incrementarVelocidad() {
		
		if(velocidad < VELOCIDAD_MAXIMA) {
			
			velocidad += INCREMENTO_VELOCIDAD;
			
		}
		
	}
	
	public void decrementarLongitud() {
		
		if(longitud > LONGITUD_MINIMA) {
			
			longitud -= DECREMENTO_LONGITUD;
			rangosColision = crearRangosPala();
			
		}
		
	}
	
	@Override
	public void restablecerPosicionInicial() {
		
		this.x = COORDENADA_X_INICIAL;
		resetearValores();
		
	}
	
	public void resetearValores() {
		
		velocidad = VELOCIDAD_INICIAL;
		longitud = LONGITUD_INICIAL;
		rangosColision = crearRangosPala();
		
	}


	public boolean isDerecha() {
		return derecha;
	}


	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}


	public boolean isIzquierda() {
		return izquierda;
	}


	public void setIzquierda(boolean izquierda) {
		this.izquierda = izquierda;
	}

	
	
}
