package com.retur.modelo.juego;


import com.retur.modelo.clases.Fondo;
import com.retur.modelo.clases.Jugador;
import com.retur.modelo.clases.Pajaro;
import com.retur.modelo.clases.Plato;
import com.retur.modelo.clases.Volador;

import javafx.scene.Cursor;
import javafx.scene.canvas.GraphicsContext;

public class Juego extends Thread{

	public static final int APS = 60;
	public static final int FPS = 60;
	public static final int CAPACIDAD_VOLADORES = 10;
	
	private final GraphicsContext GC;
	
	private Fondo fondo;
	private Jugador jugador;
	private Volador[] voladores;
	private boolean iniciado;
	
	public Juego(GraphicsContext gc) {
		
		this.fondo = new Fondo();
		this.jugador = new Jugador();
		this.voladores = new Volador[CAPACIDAD_VOLADORES];
		this.GC = gc;
		
	}
	
	@Override
	public void run() {
		iniciado = true;
		gameLoop();
	}
	
	private void gameLoop() {
		
		int fps = 0;
		long nsPorSegundo = 1000000000 / FPS;
		long ultimoFrame = System.nanoTime();
		long tiempoActual;
		long tiempoMilis = System.currentTimeMillis();
		long ultimoVolador = System.currentTimeMillis();
		double delta = 0;
		
		while(iniciado) {
			
			tiempoActual = System.nanoTime();
			
			delta += (tiempoActual - ultimoFrame) / nsPorSegundo;
			
			if(System.currentTimeMillis() - ultimoVolador >= 500) {
				
				eliminarVolador();
				generarVolador();
				ultimoVolador = System.currentTimeMillis();
				
			}
			
			if(delta >= 1) {
				
				jugador.MIRILLA.regargaDisparo();
				pintar();
				ultimoFrame = System.nanoTime();
				fps++;
				delta--;
				
			}
			
			
			
			if(System.currentTimeMillis() - tiempoMilis >= 1000) {
				
				System.out.println(fps);
				tiempoMilis = System.currentTimeMillis();
				fps = 0;
				
			}
			
		}
		
	}
	
	public void pintar() {
		
		fondo.pintar(GC);
		
		for(int i = 0; i < voladores.length; i++) {
			
			if(voladores[i] != null) {
				
				voladores[i].pintar(GC);
				
			}
			
		}
		
		jugador.MIRILLA.pintar(GC);
		
	}
	
	private void eliminarVolador() {
		
		for(int i = 0; i < CAPACIDAD_VOLADORES; i++) {
			
			Volador volador = voladores[i];
			
			if(volador != null) {
				
				if(volador.isRecorridoFinalizado()) {
					
					voladores[i] = null;
					
				}
				
			}
			
		}
		
		
	}
	
	private void generarVolador() {
		
		boolean generado = false;
		
		for(int i = 0; i < CAPACIDAD_VOLADORES && !generado; i++) {
			
			if(voladores[i] == null) {
				
				voladores[i] = voladorAleatorio();
				voladores[i].start();
				generado = true;
				
			}
			
		}
		
	}


	private Volador voladorAleatorio() {
		double num = Math.random();
		
		Volador volador = num < 0.9 ? new Plato(jugador) : new Pajaro(jugador);
		
		return volador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Volador[] getVoladores() {
		return voladores;
	}
	
}
