package com.retur.pong.modelo.elementos;


import javafx.geometry.Point2D;

public class Jugador{

	private static final int VIDAS = 3;
	
	private String nombre;
	private int vidas;
	private Pala palaJugador;
	
	public Jugador(String nombre, Point2D coordenadas) {
		
		this.nombre = nombre;
		this.vidas = VIDAS;
		this.palaJugador = new Pala(coordenadas);
		
	}
	
	public void reducirVida() {
		
		if(vidas != 0) {
			
			vidas--;
			
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getVidas() {
		return vidas;
	}

	public Pala getPalaJugador() {
		return palaJugador;
	}

	
}
