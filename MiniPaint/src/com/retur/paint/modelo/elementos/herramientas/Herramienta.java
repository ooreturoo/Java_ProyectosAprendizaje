package com.retur.paint.modelo.elementos.herramientas;

import com.retur.paint.modelo.elementos.interfaces.Seleccionable;

import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;

public abstract class Herramienta implements Seleccionable{

	public final Cursor ESTILO_CURSOR;
	protected Button botonHerramienta;
	
	public Herramienta(ImageCursor estiloCursor) {
		
		ESTILO_CURSOR = estiloCursor;
		
	}
	
	public final void init(Button botonHerramienta) {
		
		this.botonHerramienta = botonHerramienta;
		
	}
	
	
}
