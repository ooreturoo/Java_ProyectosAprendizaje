package com.miravent.modelo.componentes;


/**
 * Clase singleton que representa la puntuación del jugador.
 * @author Sergio
 *
 */
public class Puntuacion {

	public static final Puntuacion INSTANCE = new Puntuacion();
	
	private int puntos;
	
	private boolean registrado;
	
	private Puntuacion () {}
	
	
	/**
	 * Suma la puntuación a la puntuación actual.
	 * @param puntos
	 */
	public void sumaDePuntos(int puntos) {
		
		this.puntos += puntos;
		
	}
	
	/**
	 * Restablece los valores a su valor por defecto.
	 */
	public void resetearValores() {
		
		this.puntos = 0;
		this.registrado = false;
		
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}
	
	
	
	
	
}
