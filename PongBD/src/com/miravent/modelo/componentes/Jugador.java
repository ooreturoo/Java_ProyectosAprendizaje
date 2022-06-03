package com.miravent.modelo.componentes;



import javafx.geometry.Point2D;

public class Jugador{

	
	private int puntos;
	private Pala palaJugador;
	
	public Jugador(Point2D coordenadas) {
		
		this.puntos = 0;
		this.palaJugador = new Pala(coordenadas);
		
	}
	
	public void resetear() {
		
		puntos = 0;
		palaJugador.resetearValores();
		
	}
	
	public void sumarPuntosGolpeo() {
		
		this.puntos += 100;
		
	}

	public Pala getPalaJugador() {
		
		return palaJugador;
		
	}

	public int getPuntos() {
		return puntos;
	}

	
}
