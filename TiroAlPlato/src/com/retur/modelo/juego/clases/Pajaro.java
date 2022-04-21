package com.retur.modelo.juego.clases;

import java.io.File;

import com.retur.vista.VentanaJuego;

public class Pajaro extends Volador {

	private static final String URL_DISCO = "./src/resources/pajaro.png";
	private static final int DIMENSION_IMAGEN = 30;
	private static final double DANYO = 1;
	private static final int PUNTOS = 25;
	
	
	public Pajaro(Jugador jugador, VentanaJuego vj) {
		
		super(DIMENSION_IMAGEN, new File(URL_DISCO), DANYO, PUNTOS, jugador, vj);
	
	}
	
}
