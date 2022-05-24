package com.retur.pong.controlador;

import com.retur.pong.modelo.juego.Juego;
import com.retur.pong.vista.VentanaJuego;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorJuego{

	public final VentanaJuego VENTANA_JUEGO;
	private final Juego JUEGO;
	
	public ControladorJuego(String nombreJ1, String nombreJ2) {
		
		
		this.VENTANA_JUEGO = new VentanaJuego();
		this.JUEGO = new Juego(VENTANA_JUEGO.CANVAS, nombreJ1, nombreJ2);
		eventosMovimientoJugadores();
		JUEGO.start();
		
	}
	
	private void eventosMovimientoJugadores() {
		
		VENTANA_JUEGO.ESCENA_JUEGO.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				
				if(event.getCode().equals(KeyCode.W) ) {
					
					if(JUEGO.JUGADOR1.getPalaJugador().isBajar()) {
						
						JUEGO.JUGADOR1.getPalaJugador().setBajar(false);
						
					}
					
					JUEGO.JUGADOR1.getPalaJugador().setSubir(true);;
					
				} else if(event.getCode().equals(KeyCode.S) ) {
					
					if(JUEGO.JUGADOR1.getPalaJugador().isSubir()) {
						
						JUEGO.JUGADOR1.getPalaJugador().setSubir(false);
						
					}
					
					JUEGO.JUGADOR1.getPalaJugador().setBajar(true);
					
				} else if (event.getCode().equals(KeyCode.UP)) {
					
					if(JUEGO.JUGADOR2.getPalaJugador().isBajar()) {
						
						JUEGO.JUGADOR2.getPalaJugador().setBajar(false);
						
					}
					
					JUEGO.JUGADOR2.getPalaJugador().setSubir(true);;
					
				} else if (event.getCode().equals(KeyCode.DOWN)) {
					
					if(JUEGO.JUGADOR2.getPalaJugador().isSubir()) {
						
						JUEGO.JUGADOR2.getPalaJugador().setSubir(false);
						
					}
					
					JUEGO.JUGADOR2.getPalaJugador().setBajar(true);
					
				}
				
			}
			
		});
		
		VENTANA_JUEGO.ESCENA_JUEGO.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
			
				if(event.getCode().equals(KeyCode.W) ) {
					
					JUEGO.JUGADOR1.getPalaJugador().setSubir(false);
					
				} else if(event.getCode().equals(KeyCode.S) ) {
					
					JUEGO.JUGADOR1.getPalaJugador().setBajar(false);
					
				} else if (event.getCode().equals(KeyCode.UP)) {
					
					JUEGO.JUGADOR2.getPalaJugador().setSubir(false);
					
				} else if (event.getCode().equals(KeyCode.DOWN)) {
					
					JUEGO.JUGADOR2.getPalaJugador().setBajar(false);
					
				}
				
			}
			
		});
		
		
	}
	
}
