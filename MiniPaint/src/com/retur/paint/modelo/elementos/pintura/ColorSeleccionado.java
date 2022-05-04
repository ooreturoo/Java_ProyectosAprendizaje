package com.retur.paint.modelo.elementos.pintura;

import com.retur.paint.modelo.elementos.interfaces.Seleccionable;

import javafx.scene.control.Button;

public class ColorSeleccionado implements Seleccionable{

	
	private Button botonColorSeleccionado;
	private String color;
	private boolean seleccionado;
	
	public ColorSeleccionado(Button botonColorSeleccionado,String color) {
		
		this.botonColorSeleccionado = botonColorSeleccionado;
		this.color = color;
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	
	@Override
	public void seleccionado() {
		
		seleccionado = true;
		botonColorSeleccionado.getStyleClass().add(CLASE_SELECCIONADO);
		
	}

	@Override
	public void deseleccionado() {
		
		seleccionado = false;
		botonColorSeleccionado.getStyleClass().add("botonColor");
		
	}
	
}
