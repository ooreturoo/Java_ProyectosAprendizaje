package com.retur.pong.modelo.juego;

import com.retur.pong.modelo.elementos.Jugador;
import com.retur.pong.modelo.elementos.Pelota;
import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Juego {

	private static final int FPS = 60;
	private static final int APS = 60;
	
	private final Canvas ZONA_JUEGO;
	private final Jugador JUGADOR1;
	private final Jugador JUGADOR2;
	private final Pelota PELOTA;
	
	private boolean iniciado = true;
	
	public Juego(Canvas zonaJuego, String nombreJ1, String nombreJ2) {
		
		this.ZONA_JUEGO = zonaJuego;
		//TODO Introducir posiciones de comienzo de jugadores calculandolo con la zona de juego.
		this.JUGADOR1 = new Jugador(nombreJ1, , );
		this.JUGADOR2 = new Jugador(nombreJ2, , );
		this.PELOTA = new Pelota( , );
		
		
	}
	
	
	private void bucleJuego() {
		
		double nsPorSegundoFPS = 1000000000/FPS;
		double nsPorSegundoAPS = 1000000000/APS;
		
		double render = 0;
		double delta = 0;
	
		long tiempoActual;
		long tiempoTranscurrido = System.nanoTime();
		long tiempoMilis = System.currentTimeMillis();
		
		while(iniciado) {
			
			tiempoActual = System.nanoTime();
			long diferenciaTiempo = tiempoTranscurrido - tiempoActual;
			
			delta += diferenciaTiempo / nsPorSegundoAPS;
			render += diferenciaTiempo / nsPorSegundoFPS;
			diferenciaTiempo = tiempoActual;
			
			while(delta >= 1) {
				
				PELOTA.mover(ZONA_JUEGO);
				delta--;
				
			}
			
			while(render >= 1) {
				
				pintarTodo();
				render--;
				
			}
			
			
			
			
		}
		
	}
	
	private void pintarTodo() {
		
		GraphicsContext gc = ZONA_JUEGO.getGraphicsContext2D();
		
		gc.setFill(Color.GREY);
		gc.fillRect( 0, 0, ZONA_JUEGO.getWidth(), ZONA_JUEGO.getHeight());
		
		PELOTA.pintar(gc);
		JUGADOR1.pintar(gc);
		JUGADOR2.pintar(gc);
		
	}


	
	
}
