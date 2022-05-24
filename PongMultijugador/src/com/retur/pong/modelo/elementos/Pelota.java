package com.retur.pong.modelo.elementos;

import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pelota implements Pintable, Movible{

	private static final int VELOCIDAD = 8;
	public static final double RADIO = 8;
	
	
	private double x;
	private double y;
	
	private boolean subir;
	private boolean derecha;
	
	
	public Pelota(Point2D coordenadas) {
		
		
		this.x = coordenadas.getX();
		this.y = coordenadas.getY();
		
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		if(y <= 0) {
			
			subir = false;
			
		}else if( y >= superficieMovimiento.getHeight()) {
			
			subir = true;
			
		}
		
		if(x <= 0) {
			
			derecha = true;
			
		}else if( x >= superficieMovimiento.getWidth()) {
			
			derecha = false;
			
		}
		
		
		
		if (subir) {
			
			y -= VELOCIDAD;
			
		}else if (!subir) {
			
			y += VELOCIDAD;
			
		}
		
		if(derecha) {
			
			x += VELOCIDAD;
			
		}else if (!derecha) {
			
			x -= VELOCIDAD;
			
		}
		
		
	}


	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillOval(x, y, RADIO*2, RADIO*2);
		
	}
	
}
