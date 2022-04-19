package com.retur.modelo.juego;


import com.retur.modelo.juego.clases.Fondo;
import com.retur.modelo.juego.clases.Jugador;
import com.retur.modelo.juego.clases.Pajaro;
import com.retur.modelo.juego.clases.Plato;
import com.retur.modelo.juego.clases.Volador;
import com.retur.modelo.juego.comprobaciones.Comprobaciones;
import com.retur.vista.VentanaPrincipal;

import javafx.scene.canvas.GraphicsContext;

public class Juego extends Thread{

	public static final int APS = 60;
	public static final int FPS = 60;
	public static final int CAPACIDAD_VOLADORES = 10;
	
	private final GraphicsContext GC;
	private final VentanaPrincipal VP;
	private final Fondo fondo;
	private final Jugador jugador;
	private final Volador[] voladores;
	
	private int contadorFPS;
	private int contadorAPS;
	private boolean iniciado;
	private boolean derrotaJugador;
	
	public Juego(VentanaPrincipal vp) {
		
		this.fondo = new Fondo(vp);
		this.jugador = new Jugador(vp);
		this.voladores = new Volador[CAPACIDAD_VOLADORES];
		this.VP = vp;
		this.GC = vp.CANVAS.getGraphicsContext2D();
		
	}
	
	@Override
	public void run() {
		iniciado = true;
		gameLoop();
	}
	
	private void gameLoop() {
		
		long nsPorSegundoFPS = 1000000000 / FPS;
		long nsPorSegundoAPS = 1000000000 / APS;
		long ultimoFrame = System.nanoTime();
		long ultimoRender = System.nanoTime();
		long tiempoActual;
		long tiempoMilis = System.currentTimeMillis();
		long ultimoVolador = System.currentTimeMillis();
		double delta = 0;
		double renderizado = 0; 
		
		while(iniciado) {
			
			tiempoActual = System.nanoTime();
			
			delta += (tiempoActual - ultimoRender) / nsPorSegundoFPS;
			renderizado += (tiempoActual - ultimoFrame) / nsPorSegundoAPS;
			
			if(System.currentTimeMillis() - ultimoVolador >= 500) {
				
				eliminarVolador();
				generarVolador();
				ultimoVolador = System.currentTimeMillis();
				
			}
			
			while(delta >= 1) {
				
				actualizarElementos();
				ultimoRender = System.nanoTime();
				pintar();
				delta--;
				
			}
			
			while(renderizado >= 1) {
				
				
				ultimoFrame = System.nanoTime();
				renderizado--;
				
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
	
	private void finalizarJuego() {
		
		
		
	}
	
	private void actualizarElementos() {
		
		jugador.MIRILLA.regargaDisparo();
		derrotaJugador = Comprobaciones.comprobarVidaJugador();
		if(derrotaJugador) {
			
			finalizarJuego();
			
		}
		contadorAPS++;
		
	}
 
	
	private void pintar() {
		
		fondo.pintar(GC);
		
		for(int i = 0; i < voladores.length; i++) {
			
			if(voladores[i] != null) {
				
				voladores[i].pintar(GC);
				
			}
			
		}
		
		jugador.MIRILLA.pintar(GC);
		contadorFPS++;
		
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
		
		Volador volador = num < 0.9 ? new Plato(jugador,VP) : new Pajaro(jugador,VP);
		
		return volador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Volador[] getVoladores() {
		return voladores;
	}
	
}
