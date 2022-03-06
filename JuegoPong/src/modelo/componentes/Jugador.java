package modelo.componentes;

import javafx.scene.shape.Rectangle;

public class Jugador {

	
	private final Rectangle RECTANGULO;
	private static final int VELOCIDAD_INICIAL = 3;
	private final double POSISION_INICIAL_X;
	
	private boolean movimientoDerecha;
	private boolean movimientoIzquierda;
	private int velocidad;
	private int puntos;
	
	public Jugador(Rectangle rectangulo) {
		
		this.RECTANGULO = rectangulo;
		this.POSISION_INICIAL_X = rectangulo.getLayoutX();
		this.velocidad = VELOCIDAD_INICIAL;
		
	}
	
	public void movimientoJugador() {
		
		double x = RECTANGULO.getLayoutX();
		
		if(movimientoDerecha) {
			
			x += velocidad; 
			
		}
		
		if(movimientoIzquierda) {
			
			x -= velocidad;
			
		}
		
		RECTANGULO.setLayoutX(x);
		
	}
	
	public void sumarPuntosGolpeo() {
		
		this.puntos += 100;
		
	}

	public void posicionInicial() {
		
		RECTANGULO.setLayoutX(POSISION_INICIAL_X);
		
	}
	
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Rectangle getRECTANGULO() {
		return RECTANGULO;
	}

	public void setMovimientoDerecha(boolean movimientoDerecha) {
		this.movimientoDerecha = movimientoDerecha;
	}

	public void setMovimientoIzquierda(boolean movimientoIzquierda) {
		this.movimientoIzquierda = movimientoIzquierda;
	}
	
	
}
