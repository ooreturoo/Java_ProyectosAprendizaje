package com.retur.pong.modelo.elementos;

import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pala implements Pintable, Movible {

	private static final int VELOCIDAD = 8;
	public static final double ANCHO = 8;
	public static final double ALTO = 100;
	
	private final double X;

	private double y;
	private boolean subir;
	private boolean bajar;
	
	public Pala(Point2D coordenadas) {
		
		this.X = coordenadas.getX();
		this.y = coordenadas.getY();
		
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
