package com.retur.pong.modelo.elementos;



import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Pala implements Pintable, Movible{

	private static final int VELOCIDAD = 8;
	public static final double ANCHO = 8;
	public static final double ALTO = 100;
	
	private final double COORDENADA_Y_INICIAL;
	private final double X;

	private double y;
	private boolean subir;
	private boolean bajar;
	
	public Pala(Point2D coordenadas) {
		
		this.X = coordenadas.getX();
		this.y = coordenadas.getY();
		this.COORDENADA_Y_INICIAL = y;
		
	}
	
	
	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillRect(X, y, ANCHO, ALTO);
		
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		double bajoLimite = superficieMovimiento.getHeight();
		
		if(subir && y >= 0) {
			
			y = y - VELOCIDAD < 0 ? 0 : y - VELOCIDAD;
						
		}else if(bajar && y + ALTO <= bajoLimite) {
			
			y = ((y + ALTO) + VELOCIDAD) > bajoLimite ? bajoLimite - ALTO : y + VELOCIDAD;
			
		}
		
	}
	
	
	public void golpeo(Pelota pelota) {
		
		Rectangle colisionPalaIzquierda = new Rectangle(X, y, ANCHO/2, ALTO/2);
		Rectangle colisionPalaDerecha = new Rectangle(X, (y + ALTO/2), ANCHO/2, ALTO/2);
		Rectangle colisionPelota = pelota.RANGO_COLISION;
		Bounds golpeoIzquierda = Shape.intersect(colisionPalaIzquierda, colisionPelota).getLayoutBounds();
		Bounds golpeoDerecha = Shape.intersect(colisionPalaDerecha, colisionPelota).getLayoutBounds();
		if(golpeoIzquierda.getWidth() != -1 && golpeoDerecha.getWidth() != -1) {
			
			if(golpeoIzquierda.getHeight() > golpeoDerecha.getHeight()) {
				
				golpeoIzquierda(pelota);
				
			}else {
				
				golpeoDerecha(pelota);
				
				
			}
			
		}else if(golpeoIzquierda.getWidth() != -1) {
			
			golpeoIzquierda(pelota);
			
		}else if(golpeoDerecha.getHeight() != -1){
			
			golpeoDerecha(pelota);
			
		}
		
		
	}
	
	private void golpeoIzquierda(Pelota pelota) {
		
		if(pelota.isDerecha()) {
			
			pelota.setDerecha(false);
			
		}else {
			
			pelota.setDerecha(true);
			
		}
		
		pelota.setSubir(true);
		
	}
	private void golpeoDerecha(Pelota pelota) {
		
		
		if(pelota.isDerecha()) {
			
			pelota.setDerecha(false);
			
		}else {
			
			pelota.setDerecha(true);
			
		}
		
		pelota.setSubir(false);
		
	}
	
	@Override
	public void restablecerPosicionInicial() {
		
		this.y = COORDENADA_Y_INICIAL;
		
	}



	public void setSubir(boolean subir) {
		this.subir = subir;
	}


	public void setBajar(boolean bajar) {
		this.bajar = bajar;
	}


	public boolean isSubir() {
		return subir;
	}


	public boolean isBajar() {
		return bajar;
	}



	
}
