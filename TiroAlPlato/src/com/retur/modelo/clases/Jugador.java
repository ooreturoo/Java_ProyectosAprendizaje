package com.retur.modelo.clases;


public class Jugador{

	private static final int VIDAS_DEFECTO = 5;
	
	public final Mirilla MIRILLA;

	private double vidas;
	private int puntos;
	
	public Jugador() {
		
		MIRILLA = new Mirilla();
	
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
