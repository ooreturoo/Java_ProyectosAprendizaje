package com.retur.paint.modelo.elementos.herramientas;



import javafx.scene.Cursor;
import javafx.scene.ImageCursor;

public abstract class HerramientaDibujo {
	
	protected static final int DIMENSION_CURSOR = 25;

	public final Cursor ESTILO_CURSOR;
	private String color;
	private boolean[][] rangoDibujo;
	
	public HerramientaDibujo(ImageCursor estiloCursor) {
		
		ESTILO_CURSOR = estiloCursor;
		
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
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean[][] getRangoDibujo() {
		return rangoDibujo;
	}

	protected abstract boolean[][] crearPrimerRango();
	
	protected abstract boolean[][] crearSegundoRango();
	
	protected abstract boolean[][] crearTercerRango();
	
	protected abstract boolean[][] crearCuartoRango();
	

	
	
}
