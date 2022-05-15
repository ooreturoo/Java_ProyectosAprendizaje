package com.retur.pong.controlador;

import com.retur.pong.modelo.juego.Juego;
import com.retur.pong.vista.VentanaJuego;

public class ControladorJuego{

	public final VentanaJuego VENTANA_JUEGO;
	private final Juego JUEGO;
	
	public ControladorJuego(String nombreJ1, String nombreJ2) {
		
		
		this.VENTANA_JUEGO = new VentanaJuego();
		this.JUEGO = new Juego(VENTANA_JUEGO.CANVAS, nombreJ1, nombreJ2);
		
	}
	
}
