package modelo.componentes;

import javafx.scene.shape.Circle;

public class Pelota {

	private static final double VELOCIDAD_INICIAL = 2.5;
	private static final double INCREMENTO_VELOCIDAD = 0.5;
	private static final int VELOCIDAD_MAXIMA = 6;
	private static final int DECREMENTO_RADIO = 2;
	private static final int RADIO_MINIMO = 11;
	
	private final double RADIO_BASE;
	private final double POSISION_INICIAL_X;
	private final double POSISION_INICIAL_Y;
	
	private final Circle CIRCULO;
	private boolean movimientoDerecha;
	private boolean movimientoAbajo;
	private double velocidad;
	private double x;
	private double y;
	
	
	public Pelota(Circle circulo) {
		
		this.CIRCULO = circulo;
		this.POSISION_INICIAL_X = circulo.getLayoutX();
		this.POSISION_INICIAL_Y = circulo.getLayoutY();
		this.RADIO_BASE = circulo.getRadius();
		this.movimientoDerecha = true;
		this.movimientoAbajo = true;
		this.velocidad = VELOCIDAD_INICIAL;
		this.x = POSISION_INICIAL_X;
		this.y = POSISION_INICIAL_Y;
		
	}
	
	
	
	public void movimientoPelota() {
		
		if(movimientoDerecha) {
			
			x += velocidad;
			
		}else {
			
			x -= velocidad;
			
		}
		
		if(movimientoAbajo) {
			
			y += velocidad;
			
		}else {
			
			y -= velocidad;
			
		}
		
		CIRCULO.relocate(x, y);
		
	}
	
	public void resetearValores () {
		
		
		x= POSISION_INICIAL_X;
		y = POSISION_INICIAL_Y;
		velocidad = VELOCIDAD_INICIAL;
		CIRCULO.setRadius(RADIO_BASE);
		CIRCULO.setLayoutX(POSISION_INICIAL_X);
		CIRCULO.setLayoutY(POSISION_INICIAL_Y);
		
	}
	
	public void incrementarVelocidad() {
		
		if(velocidad < VELOCIDAD_MAXIMA) {
			
			velocidad += INCREMENTO_VELOCIDAD;
			
		}
		
	}
	
	public void decrementarRadio() {
		
		if(CIRCULO.getRadius() > RADIO_MINIMO) {
			
			CIRCULO.setRadius(CIRCULO.getRadius() - DECREMENTO_RADIO);
			
		}
		
	}

	public Circle getCIRCULO() {
		return CIRCULO;
	}

	public void setxDerecha(boolean xDerecha) {
		this.movimientoDerecha = xDerecha;
	}

	public void setyAbajo(boolean yAbajo) {
		this.movimientoAbajo = yAbajo;
	}
	
	
	
	
	
}
