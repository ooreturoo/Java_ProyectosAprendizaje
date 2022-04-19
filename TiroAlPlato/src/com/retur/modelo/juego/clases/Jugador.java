package com.retur.modelo.juego.clases;

import com.retur.vista.VentanaPrincipal;

public class Jugador{

	private static final int VIDAS_MAXIMAS = 5;
	
	public final Mirilla MIRILLA;

	private double vidas;
	private int puntos;
	
	public Jugador(VentanaPrincipal vp) {
		
		MIRILLA = new Mirilla(vp);
	
	}
	
	public void aumentarVidas(double vidasObtenidas) {
		
		if(vidas < VIDAS_MAXIMAS ) {
			
			vidas = (vidas + vidasObtenidas) > VIDAS_MAXIMAS ? VIDAS_MAXIMAS : vidas + vidasObtenidas;
			
		}
		
	}
	
	public void reducirVidas(double vidasPerdidas) {
		
		if(vidas > 0) {
			
			vidas = (vidas - vidasPerdidas) < 0 ? 0 : vidas - vidasPerdidas;
			
		}
		
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
