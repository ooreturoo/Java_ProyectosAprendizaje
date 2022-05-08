package com.retur.paint.modelo.elementos.herramientas;



import com.retur.paint.modelo.elementos.RangosPintura;
import com.retur.paint.modelo.elementos.interfaces.Pintor;

import javafx.scene.ImageCursor;

public abstract class HerramientaDibujo extends Herramienta implements Pintor{
	
	
	protected boolean[][] rangoDibujo;
	protected RangosPintura rangoEnUso;
	
	public HerramientaDibujo(ImageCursor estiloCursor) {
		
		super(estiloCursor);
		
	}
	
	public void usarPrimerRango() {
		
		this.rangoEnUso = RangosPintura.PRIMER_RANGO;
		this.rangoDibujo = crearPrimerRango();
		
	}
	
	public void usarSegundoRango() {
		
		this.rangoEnUso = RangosPintura.SEGUNDO_RANGO;
		this.rangoDibujo = crearSegundoRango();
		
	}
	
	public void usarTercerRango() {
		
		
		this.rangoEnUso = RangosPintura.TERCER_RANGO;
		this.rangoDibujo = crearTercerRango();
		
	}
	
	public void usarCuartoRango() {
		
		this.rangoEnUso = RangosPintura.CUARTO_RANGO;
		this.rangoDibujo = crearCuartoRango();
		
	}
	
	public boolean[][] getRangoDibujo() {
		return rangoDibujo;
	}
	

	public RangosPintura getRangoEnUso() {
		return rangoEnUso;
	}

	public void setRangoEnUso(RangosPintura rangoEnUso) {
		this.rangoEnUso = rangoEnUso;
	}

	protected abstract boolean[][] crearPrimerRango();
	
	protected abstract boolean[][] crearSegundoRango();
	
	protected abstract boolean[][] crearTercerRango();
	
	protected abstract boolean[][] crearCuartoRango();
	

	
	
}
