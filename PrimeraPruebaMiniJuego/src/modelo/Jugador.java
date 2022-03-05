package modelo;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Rectangle;

public class Jugador {

	private final Rectangle PALA;
	private final double COMIENZO_X;
	private final int VELOCIDAD = 5;
	private final Canvas FONDO_CANVAS;
	private boolean derecha;
	private boolean izquierda;
	private double x;
	
	public Jugador(Rectangle pala, Canvas fondoCanvas) {
		this.PALA = pala;
		this.COMIENZO_X = x;
		this.FONDO_CANVAS = fondoCanvas;
		this.x = pala.getLayoutX();

		
	}

	public double getCOMIENZO_X() {
		return COMIENZO_X;
	}	
	
	public void movimientoJugador() {
		
		
		
		if(derecha) {
			
			if(PALA.getLayoutX() + PALA.getWidth() < FONDO_CANVAS.getWidth()) {
				
				x += VELOCIDAD;
			}

			
		}
		if(izquierda) {
			
			if(PALA.getLayoutX() > 0) {
				
				x -= VELOCIDAD;
			}
			
		}
		
		PALA.setLayoutX(x);
	}
	
	

	public Rectangle getPALA() {
		return PALA;
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
