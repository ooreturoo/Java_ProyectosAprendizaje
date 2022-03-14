package modelo.componentes;

import javafx.scene.shape.Rectangle;

public class Jugador {

	
	private static final double VELOCIDAD_INICIAL = 2.5;
	private static final double INCREMENTO_VELOCIDAD = 2.5;
	private static final int VELOCIDAD_MAXIMA = 7;
	private static final int LONGITUD_MINIMA = 65;
	private static final int DECREMENTO_LONGITUD = 10;
	
	private final int LONGITUD_BASE;
	private final double POSISION_INICIAL_X;
	private final Rectangle RECTANGULO;
	
	private boolean movimientoDerecha;
	private boolean movimientoIzquierda;
	private double velocidad;
	private int puntos;
	
	public Jugador(Rectangle rectangulo) {
		
		this.RECTANGULO = rectangulo;
		this.POSISION_INICIAL_X = rectangulo.getLayoutX();
		this.LONGITUD_BASE = (int) rectangulo.getWidth();
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
	
	public void incrementarVelocidad() {
		
		if(velocidad < VELOCIDAD_MAXIMA) {
			
			velocidad += INCREMENTO_VELOCIDAD;
			
		}
		
	}
	
	public void decrementarLongitud() {
		
		if(RECTANGULO.getWidth() > LONGITUD_MINIMA) {
			
			RECTANGULO.setWidth(RECTANGULO.getWidth() - DECREMENTO_LONGITUD);
			
		}
		
	}
	
	public void sumarPuntosGolpeo() {
		
		this.puntos += 100;
		
	}

	public void resetearValores() {
		
		velocidad = VELOCIDAD_INICIAL;
		puntos = 0;
		RECTANGULO.setWidth(LONGITUD_BASE);
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
