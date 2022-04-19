package com.retur.modelo.juego.clases;

import java.io.File;

import com.retur.vista.VentanaPrincipal;

public class Pajaro extends Volador {

	private static final String URL_DISCO = "./src/resources/pajaro.png";
	private static final int DIMENSION_IMAGEN = 30;
	private static final int DANYO = 1;
	private static final int PUNTOS = 25;
	
	
	public Pajaro(Jugador jugador, VentanaPrincipal vp) {
		
		super(DIMENSION_IMAGEN, new File(URL_DISCO), DANYO, PUNTOS, jugador, vp);
	
	}
	
}
