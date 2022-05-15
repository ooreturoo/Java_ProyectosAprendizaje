package com.retur.pong.modelo.elementos;

import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pala implements Pintable, Movible {

	private static final int VELOCIDAD = 3;
	private static final double ANCHO = 15;
	private static final double ALTO = 120;
	
	private final double X;

	private double y;
	private boolean subir;
	private boolean bajar;
	
	public Pala(double xInicial, double yInicial) {
		
		this.X = xInicial;
		this.y = yInicial;
		
	}
	
	
	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillRect(X, y, ANCHO, ALTO);
		
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		double altoLimite = superficieMovimiento.getHeight();
		
		if(subir && y >= 0) {
			
			y = y - VELOCIDAD < 0 ? 0 : y - VELOCIDAD;
						
		}else if(bajar && y + ALTO <= altoLimite) {
			
			y = (y + ALTO) + VELOCIDAD > altoLimite ? altoLimite : y + VELOCIDAD;
			
		}
		
	}
	
	
}
