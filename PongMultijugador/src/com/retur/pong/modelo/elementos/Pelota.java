package com.retur.pong.modelo.elementos;




import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pelota implements Pintable, Movible{

	private static final int VELOCIDAD = 8;
	public static final double RADIO = 8;
	
	private final Point2D COORDENADAS_INICIALES;
	public final Rectangle RANGO_COLISION;
	
	private double x;
	private double y;
	
	private boolean subir;
	private boolean derecha;
	
	
	public Pelota(Point2D coordenadas) {
		
		this.COORDENADAS_INICIALES = coordenadas;
		this.x = coordenadas.getX();
		this.y = coordenadas.getY();
		this.RANGO_COLISION = new Rectangle(x, y, RADIO*2, RADIO*2);
		
	}


	@Override
	public void mover(Canvas superficieMovimiento) {
		
		if(y <= 0) {
			
			subir = false;
			
		}else if( (y + RADIO) >= superficieMovimiento.getHeight()) {
			
			subir = true;
			
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
		
		RANGO_COLISION.relocate(x, y);
		
	}


	@Override
	public void restablecerPosicionInicial() {
		
		this.x = COORDENADAS_INICIALES.getX();
		this.y = COORDENADAS_INICIALES.getY();
		
	}


	@Override
	public void pintar(GraphicsContext gc) {
		
		gc.setFill(Color.AQUA);
		gc.fillOval(x, y, RADIO*2, RADIO*2);
		
	}

	

	public boolean isSubir() {
		return subir;
	}


	public boolean isDerecha() {
		return derecha;
	}


	public void setSubir(boolean subir) {
		this.subir = subir;
	}


	public void setDerecha(boolean derecha) {
		this.derecha = derecha;
	}


	public double getX() {
		return x;
	}
	
	

	
}
