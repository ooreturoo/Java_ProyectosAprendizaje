package com.retur.paint.modelo.elementos.herramientas;



import com.retur.paint.modelo.elementos.interfaces.Pintor;

import javafx.scene.ImageCursor;

public abstract class HerramientaDibujo extends Herramienta implements Pintor{
	
	protected static final int DIMENSION_CURSOR = 25;

	protected boolean[][] rangoDibujo;
	
	public HerramientaDibujo(ImageCursor estiloCursor) {
		
		super(estiloCursor);
		
	}
	
	public void usarPrimerRango() {
		
		this.rangoDibujo = crearPrimerRango();
		
	}
	
	public void usarSegundoRango() {
		
		this.rangoDibujo = crearSegundoRango();
		
	}
	
	public void usarTercerRango() {
		
		this.rangoDibujo = crearTercerRango();
		
	}
	
	public void usarCuartoRango() {
		
		this.rangoDibujo = crearCuartoRango();
		
	}
	
	public boolean[][] getRangoDibujo() {
		return rangoDibujo;
	}

	protected abstract boolean[][] crearPrimerRango();
	
	protected abstract boolean[][] crearSegundoRango();
	
	protected abstract boolean[][] crearTercerRango();
	
	protected abstract boolean[][] crearCuartoRango();
	

	
	
}
