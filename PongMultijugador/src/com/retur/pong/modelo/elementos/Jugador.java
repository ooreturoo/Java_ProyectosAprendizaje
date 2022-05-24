package com.retur.pong.modelo.elementos;

import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Jugador implements Pintable, Movible{

	private static final int VIDAS = 3;
	
	private String nombre;
	private int vidas;
	private Pala palaJugador;
	
	public Jugador(String nombre, Point2D coordenadas) {
		
		this.nombre = nombre;
		this.vidas = VIDAS;
		this.palaJugador = new Pala(coordenadas);
		
	}
	
	public void reducirVida() {
		
		if(vidas != 0) {
			
			vidas--;
			
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getVidas() {
		return vidas;
	}

	public Pala getPalaJugador() {
		return palaJugador;
	}

	@Override
	public void mover(Canvas superficieMovimiento) {
		
		palaJugador.mover(superficieMovimiento);
		
	}

	@Override
	public void pintar(GraphicsContext gc) {
		
		palaJugador.pintar(gc);
		
	}
	
	
	
}
