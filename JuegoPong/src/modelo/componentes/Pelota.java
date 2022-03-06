package modelo.componentes;

import javafx.scene.shape.Circle;

public class Pelota {

	private static final int VELOCIDAD_INICIAL = 3;
	private final double POSISION_INICIAL_X;
	private final double POSISION_INICIAL_Y;
	private final Circle CIRCULO;
	private boolean movimientoDerecha;
	private boolean movimientoAbajo;
	private int velocidad;
	private double x;
	private double y;
	
	
	public Pelota(Circle circulo) {
		
		this.CIRCULO = circulo;
		this.POSISION_INICIAL_X = circulo.getLayoutX();
		this.POSISION_INICIAL_Y = circulo.getLayoutY();
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
	
	public void posicionInicial () {
		
		
		x= POSISION_INICIAL_X;
		y = POSISION_INICIAL_Y;
		CIRCULO.setLayoutX(POSISION_INICIAL_X);
		CIRCULO.setLayoutY(POSISION_INICIAL_Y);
		
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
