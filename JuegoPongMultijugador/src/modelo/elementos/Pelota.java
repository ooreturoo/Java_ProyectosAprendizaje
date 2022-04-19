package modelo.elementos;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

public class Pelota {

	private static final int VELOCIDAD_DEFECTO = 3;
	
	private Circle pelota;
	private boolean incrementarX;
	private boolean incrementarY;
	private int velocidad;
	private double x;
	private double y;
	
	
	public Pelota(Circle pelota) {
		
		this.pelota = pelota;
		this.velocidad = VELOCIDAD_DEFECTO;
		this.x = pelota.getLayoutX();
		this.y = pelota.getLayoutY();
		
	}
	
	public void movimientoPelota(double layoutXVentana, double layoutYVentana ,double anchoVentana,
			double alturaVentana, Jugador jugador) {
		
		if(incrementarX) {
			
			if(x < layoutXVentana+anchoVentana) {
				
				x += velocidad;
				
			}else {
				
				incrementarX = false;
				
			}
			
		}else if(!incrementarX) {
			
			if(x > layoutXVentana) {
				
				x-= velocidad;
				
			}else {
				
				incrementarX = true;
				
			}
			
			
		}
		
		if(incrementarY) {
			
			if(y < layoutYVentana+alturaVentana) {
				
				y += velocidad;
				
			}else {
				
				incrementarY = false;
				
			}
			
		}else if(!incrementarY) {
			
			if(y > layoutYVentana) {
				
				y += velocidad;
				
			}else {
				
				incrementarY = true;
				
			}
		}
		
		pelota.relocate(x, y);
		
	}


	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Circle getPelota() {
		return pelota;
	}
	
	
}
