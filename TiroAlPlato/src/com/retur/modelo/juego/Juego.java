package com.retur.modelo.juego;


import com.retur.modelo.juego.clases.Fondo;
import com.retur.modelo.juego.clases.Jugador;
import com.retur.modelo.juego.clases.Pajaro;
import com.retur.modelo.juego.clases.Plato;
import com.retur.modelo.juego.clases.Volador;
import com.retur.vista.VentanaJuego;

import javafx.scene.canvas.GraphicsContext;

public class Juego extends Thread{

	public static final int APS = 60;
	public static final int FPS = 60;
	public static final int CAPACIDAD_VOLADORES = 10;
	
	private final GraphicsContext GC;
	private final VentanaJuego VJ;
	private final Fondo FONDO;
	private final Jugador JUGADOR;
	private final Volador[] VOLADORES;
	
	private int contadorFPS;
	private int contadorAPS;
	private boolean iniciado;
	
	public Juego(VentanaJuego vj) {
		
		this.FONDO = new Fondo(vj);
		this.JUGADOR = new Jugador(vj);
		this.VOLADORES = new Volador[CAPACIDAD_VOLADORES];
		this.VJ = vj;
		this.GC = vj.CANVAS.getGraphicsContext2D();
		
	}
	
	@Override
	public void run() {
		iniciado = true;
		gameLoop();
	}
	
	private void gameLoop() {
		
		double nsPorSegundoFPS = 1000000000 / FPS;
		double nsPorSegundoAPS = 1000000000 / APS;
		long tiempoTranscurrido = System.nanoTime();
		long tiempoActual;
		long tiempoMilis = System.currentTimeMillis();
		long ultimoVolador = System.currentTimeMillis();
		double delta = 0;
		double renderizado = 0; 
		
		while(iniciado) {
			
			tiempoActual = System.nanoTime();
			
			delta += (tiempoActual - tiempoTranscurrido) / nsPorSegundoAPS;
			renderizado += ((tiempoActual - tiempoTranscurrido) / nsPorSegundoFPS);
			tiempoTranscurrido = tiempoActual;
			

			if(System.currentTimeMillis() - ultimoVolador >= 500) {
				
				eliminarVolador();
				generarVolador();
				ultimoVolador = System.currentTimeMillis();
				
			}
			
			while(delta >= 1) {
				
				actualizarElementos();
				delta--;
				
			}
			
			while(renderizado >= 1) {
				
				pintar();
				renderizado--;
				
			}
			
			try {
				sleep(0,(int) ((delta)*100000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			//TODO Mostrar FPS y APS en la ventada de juego.
			if(System.currentTimeMillis() - tiempoMilis >= 1000) {
				
				System.out.println("APS" + contadorAPS);
				System.out.println("FPS" + contadorFPS);
				tiempoMilis = System.currentTimeMillis();
				contadorFPS = 0;
				contadorAPS = 0;
				
			}
			
		}
		
	}
	

	
	private void actualizarElementos() {
		
		JUGADOR.MIRILLA.regargaDisparo();
		comprobacionFinalJuego();
		contadorAPS++;
		
	}
	
	private void comprobacionFinalJuego() {
		
		if (JUGADOR.getVidas() == 0) {
			
			iniciado = false;
			
		}
		
	}
 
	
	private void pintar() {
		
		FONDO.pintar(GC);
		
		for(int i = 0; i < VOLADORES.length; i++) {
			
			if(VOLADORES[i] != null) {
				
				VOLADORES[i].pintar(GC);
				
			}
			
		}
		
		JUGADOR.MIRILLA.pintar(GC);
		contadorFPS++;
		
	}
	
	private void eliminarVolador() {
		
		for(int i = 0; i < CAPACIDAD_VOLADORES; i++) {
			
			Volador volador = VOLADORES[i];
			
			if(volador != null) {
				
				if(volador.isRecorridoFinalizado()) {
					
					VOLADORES[i] = null;
					
				}
				
			}
			
		}
		
		
	}
	
	private void generarVolador() {
		
		boolean generado = false;
		
		for(int i = 0; i < CAPACIDAD_VOLADORES && !generado; i++) {
			
			if(VOLADORES[i] == null) {
				
				VOLADORES[i] = voladorAleatorio();
				VOLADORES[i].start();
				generado = true;
				
			}
			
		}
		
	}


	private Volador voladorAleatorio() {
		double num = Math.random();
		
		Volador volador = num < 0.9 ? new Plato(JUGADOR,VJ) : new Pajaro(JUGADOR,VJ);
		
		return volador;
	}

	public Jugador getJugador() {
		return JUGADOR;
	}

	public Volador[] getVoladores() {
		return VOLADORES;
	}
	
}
