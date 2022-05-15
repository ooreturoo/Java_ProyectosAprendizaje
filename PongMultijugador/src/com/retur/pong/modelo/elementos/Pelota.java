package com.retur.pong.modelo.elementos;

import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Pelota implements Pintable, Movible{

	private static final int VELOCIDAD = 6;
	private static final double RADIO = 5;
	
	
	private double x;
	private double y;
	
	private boolean subir;
	private boolean derecha;
	
	
	public Pelota(double xInicial, double yInicial) {
		
		this.x = xInicial;
		this.y = yInicial;
		
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		
		
	}


	@Override
	public void pintar(GraphicsContext gc) {
		
		
		
	}
	
}
