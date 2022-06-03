package com.miravent.modelo.componentes;



import javafx.geometry.Point2D;

/**
 * Clase que representa a un jugador.
 * @author Sergio
 *
 */
public class Jugador{

	
	private Puntuacion puntuacion;
	private Pala palaJugador;
	
	public Jugador(Point2D coordenadas) {
		
		this.puntuacion = Puntuacion.INSTANCE;
		this.puntuacion.setPuntos(0);
		this.puntuacion.setRegistrado(false);
		this.palaJugador = new Pala(coordenadas);
		
	}
	

	/**
	 * Suma los puntos cada vez que se produce un golpeo del jugador a la pelota.
	 */
	public void sumarPuntosGolpeo(int puntos) {
		
		puntuacion.sumaDePuntos(puntos);
		
	}

	public Pala getPalaJugador() {
		
		return palaJugador;
		
	}

	public Puntuacion getPuntuacion() {
		return puntuacion;
	}


	
}
