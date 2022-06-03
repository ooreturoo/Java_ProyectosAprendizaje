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
	
	public final Rectangle[] RANGOS_COLISION;
	private final double COORDENADA_Y_INICIAL;
	private final double X;

	private double y;
	private boolean subir;
	private boolean bajar;
	
	
	public Pala(Point2D coordenadas) {
		
		this.X = coordenadas.getX();
		this.y = coordenadas.getY();
		this.RANGOS_COLISION = crearRangosPala();
		this.COORDENADA_Y_INICIAL = y;
		
		
	}
	
	
	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillRect(X, y, ANCHO, ALTO);
		
		/***Pintar Rango Colision***
		 * 
		 * 
		 *gc.setStroke(Color.RED);
		 *gc.strokeRect(RANGOS_COLISION[0].getX(), RANGOS_COLISION[0].getY(), RANGOS_COLISION[0].getWidth(), RANGOS_COLISION[0].getHeight());
		 *gc.strokeRect(RANGOS_COLISION[1].getX(), RANGOS_COLISION[1].getY(), RANGOS_COLISION[1].getWidth(), RANGOS_COLISION[1].getHeight());
		*/
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		double bajoLimite = superficieMovimiento.getHeight();
		
		if(subir && y >= 0) {
			
			y = y - VELOCIDAD < 0 ? 0 : y - VELOCIDAD;
						
		}else if(bajar && y + ALTO <= bajoLimite) {
			
			y = ((y + ALTO) + VELOCIDAD) > bajoLimite ? bajoLimite - ALTO : y + VELOCIDAD;
			
		}
		
		RANGOS_COLISION[0].setY(y);
		RANGOS_COLISION[1].setY((y + ALTO/2));
		
	}
	
	
	public void golpeo(Pelota pelota) {
		
		Bounds golpeoSuperior = Shape.intersect(RANGOS_COLISION[0], pelota.RANGO_COLISION).getLayoutBounds();
		Bounds golpeoInferior = Shape.intersect(RANGOS_COLISION[1], pelota.RANGO_COLISION).getLayoutBounds();
		if(golpeoSuperior.getWidth() != -1 && golpeoInferior.getWidth() != -1) {
			
			if(golpeoSuperior.getHeight() > golpeoInferior.getHeight()) {
				
				golpeoIzquierda(pelota);
				
			}else {
				
				golpeoDerecha(pelota);
				
				
			}
			
		}else if(golpeoSuperior.getWidth() != -1) {
			
			golpeoIzquierda(pelota);
			
		}else if(golpeoInferior.getHeight() != -1){
			
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
	
	private Rectangle[] crearRangosPala() {
		
		Rectangle[] rangos = new Rectangle[2];
		
		rangos[0] = new Rectangle(X, y, ANCHO, ALTO/2);
		rangos[1] = new Rectangle(X, (y + ALTO/2), ANCHO, ALTO/2);
		
		return rangos;
		
	}
	
	@Override
	public void restablecerPosicionInicial() {
		
		this.y = COORDENADA_Y_INICIAL;
		RANGOS_COLISION[0].setY(y);
		RANGOS_COLISION[1].setY((y + ALTO/2));
		
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
