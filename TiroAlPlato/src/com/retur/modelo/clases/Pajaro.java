package com.retur.modelo.clases;

import java.io.File;

public class Pajaro extends Volador {

	private static final String URL_DISCO = "./src/resources/pajaro.png";
	private static final int DIMENSION_IMAGEN = 30;
	private static final int DANYO = 1;
	private static final int PUNTOS = 25;
	
	
	public Pajaro(Jugador jugador) {
		
		super(DIMENSION_IMAGEN, new File(URL_DISCO), DANYO, PUNTOS, jugador);
	
	}
	
}
