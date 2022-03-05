package modelo.componentes;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;
import modelo.juego.Juego;

public class Pelota {

	private static final int VELOCIDAD_INICIAL = 5;
	private final Circle CIRCULO;
	private final Canvas CANVAS;
	private boolean xDerecha;
	private boolean yAbajo;
	private int velocidad;
	private double x;
	private double y;
	
	
	public Pelota(Circle circulo, Canvas canvas) {
		
		this.CIRCULO = circulo;
		this.CANVAS = canvas;
		this.xDerecha = true;
		this.yAbajo = true;
		this.velocidad = VELOCIDAD_INICIAL;
		this.x = circulo.getLayoutX();
		this.y = circulo.getLayoutY();
		
	}
	
	public void movimientoPelota() {
		
		if(x + (CIRCULO.getRadius()*2)>= CANVAS.getWidth()) {
			
			xDerecha = false;
			
		}else if(x - CIRCULO.getRadius() <= 0) {
			
			xDerecha = true;
			
		}
		
		if(y - CIRCULO.getRadius() <= 0) {
			
			yAbajo = true;
			
		}
		
		if(y + (CIRCULO.getRadius()*2) >= CANVAS.getHeight()) {
			
		//TODO Añadir derrota.
			//yAbajo = false;
			Juego.finJuego();
			
		}else {
			
			movimiento();
			
		}
		
		//TODO Añadir colisión con Jugador
		
		
	}
	
	private void movimiento() {
		
		if(xDerecha) {
			
			x += velocidad;
			
		}else {
			
			x -= velocidad;
			
		}
		
		if(yAbajo) {
			
			y += velocidad;
			
		}else {
			
			y -= velocidad;
			
		}
		
		CIRCULO.relocate(x, y);
		
	}
	
	
	
	
	
}
