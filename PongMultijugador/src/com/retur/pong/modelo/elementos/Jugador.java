package com.retur.pong.modelo.elementos;

import com.retur.pong.modelo.interfaces.Movible;
import com.retur.pong.modelo.interfaces.Pintable;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Jugador implements Pintable, Movible{

	private static final int VIDAS = 3;
	
	private String nombre;
	private int vidas;
	private Pala palaJugador;
	
	public Jugador(String nombre, double x, double y) {
		
		this.nombre = nombre;
		this.vidas = VIDAS;
		this.palaJugador = new Pala(x, y);
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pintar(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
