package com.retur.modelo.juego.clases;

import com.retur.vista.VentanaJuego;

public class Jugador{

	private static final int VIDAS_MAXIMAS = 5;
	
	public final Mirilla MIRILLA;

	private double vidas;
	private int puntos;
	
	public Jugador(VentanaJuego vj) {
		
		MIRILLA = new Mirilla(vj);
		vidas = VIDAS_MAXIMAS;
	
	}
	
	public void aumentarVidas(double vidasObtenidas) {
		
		if(vidas < VIDAS_MAXIMAS ) {
			
			vidas = (vidas + vidasObtenidas) > VIDAS_MAXIMAS ? VIDAS_MAXIMAS : vidas + vidasObtenidas;
			
		}
		
	}
	
	
	public void reducirVidas(double vidasPerdidas) {
		
		if(vidas > 0) {
			
			vidas = (vidas - vidasPerdidas) <= 0 ? 0 : vidas - vidasPerdidas;
			
		}
		
	}
	
	public void aumentarPuntos(int puntos) {
		
		puntos += puntos;
		
	}
	

	public double getVidas() {
		return vidas;
	}
	
	
	public void setVidas(double vidas) {
		this.vidas = vidas;
	}
	
	
	public int getPuntos() {
		return puntos;
	}
	
	
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	
	
}
