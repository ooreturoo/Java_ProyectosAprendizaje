package com.retur.modelo.juego.clases;

import java.io.File;

import com.retur.vista.VentanaJuego;

public class Plato extends Volador {
	
	private static final String URL_DISCO = "./src/resources/plato.png";
	private static final int DIMENSION_IMAGEN = 30;
	private static final double DANYO = 0.25;
	private static final int PUNTOS = 50;
	

	public Plato(Jugador jugador, VentanaJuego vj) {
		
		super(DIMENSION_IMAGEN, new File(URL_DISCO), DANYO, PUNTOS, jugador, vj);
		
	}

	
}
