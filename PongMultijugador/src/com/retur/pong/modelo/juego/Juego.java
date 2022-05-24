package com.retur.pong.modelo.juego;

import com.retur.pong.modelo.elementos.Jugador;
import com.retur.pong.modelo.elementos.Pala;
import com.retur.pong.modelo.elementos.Pelota;
import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.beans.binding.IntegerBinding;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Juego extends Thread{

	private static final int FPS = 60;
	private static final int APS = 60;
	
	private final Canvas ZONA_JUEGO;
	public final Jugador JUGADOR1;
	public final Jugador JUGADOR2;
	private final Pelota PELOTA;
	
	private boolean iniciado;
	
	public Juego(Canvas zonaJuego, String nombreJ1, String nombreJ2) {
		
		this.ZONA_JUEGO = zonaJuego;
		//TODO Introducir posiciones de comienzo de jugadores calculandolo con la zona de juego.
		
		this.JUGADOR1 = new Jugador(nombreJ1, posInicioJ1());
		this.JUGADOR2 = new Jugador(nombreJ2, posInicioJ2());
		this.PELOTA = new Pelota(posInicioPelota());
		
		
	}
	
	@Override
	public void run() {
		
		iniciado = true;
		bucleJuego();
		
		
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
			
			//Almacena el tiempo de la vuelta del bucle.
			tiempoActual = System.nanoTime();
			/*
			 * Almacenamos la cantidad de Frames y de Actualizaciones que corresponden dependiendo
			 * del tiempo transcurrido entre vueltas de bucle para obtener las cantidades límites
			 * establecidas.
			 */
			delta += (tiempoActual - tiempoTranscurrido) / nsPorSegundoAPS;
			render += ((tiempoActual - tiempoTranscurrido) / nsPorSegundoFPS);
			tiempoTranscurrido = tiempoActual;
			

			
			/*
			 * Cuando el valor de delta corresponda a una actualización o más se ejecutará el búcle
			 * actualizando los elementos la cantidad de veces almacenadas.
			 */
			while(delta >= 1) {
				
				movimientoElementos();
				delta--;
				
			}
			
			/*
			 * Cuando el valor de delta corresponda a una impresión o más se ejecutará el búcle
			 * dibujando los elementos la cantidad de veces almacenadas.
			 */
			while(render >= 1) {
				
				pintarTodo();
				render--;
				
			}
			
			//Se duerme el hilo para aumentar la eficiencia y reducir el consumo de recursos.
			
			try {
				sleep(0,(int) ((delta)*100000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void movimientoElementos() {
		
		PELOTA.mover(ZONA_JUEGO);
		JUGADOR1.mover(ZONA_JUEGO);
		JUGADOR2.mover(ZONA_JUEGO);
		
	}
	
	private void pintarTodo() {
		
		GraphicsContext gc = ZONA_JUEGO.getGraphicsContext2D();
		
		gc.setFill(Color.GREY);
		gc.fillRect( 0, 0, ZONA_JUEGO.getWidth(), ZONA_JUEGO.getHeight());
		
		double mitadX = ZONA_JUEGO.getWidth()/2;
		gc.strokeLine(mitadX, 0, mitadX, ZONA_JUEGO.getHeight());
		PELOTA.pintar(gc);
		JUGADOR1.pintar(gc);
		JUGADOR2.pintar(gc);
		
	}
	
	private Point2D posInicioJ1() {
		
		double x = ZONA_JUEGO.getWidth()/12;
		double y = (ZONA_JUEGO.getHeight()/2) - (Pala.ALTO/2);
		
		return new Point2D(x, y);
		
	}
	
	private Point2D posInicioJ2() {
		
		double x = ZONA_JUEGO.getWidth() - ZONA_JUEGO.getWidth()/12;
		double y = (ZONA_JUEGO.getHeight()/2) - (Pala.ALTO/2);
		
		return new Point2D(x, y);
		
	}
	
	private Point2D posInicioPelota() {
		
		double x = ZONA_JUEGO.getWidth()/2  - Pelota.RADIO;
		double y = ZONA_JUEGO.getHeight()/2 - Pelota.RADIO;
		
		return new Point2D(x, y);
		
	}
	


	
	
}
