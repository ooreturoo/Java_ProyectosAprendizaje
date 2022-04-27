package com.retur.paint.modelo.elementos.pintura;

import javafx.scene.control.Button;

public class ColorSeleccionado {

	
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

	public void seleccionar() {
		
		seleccionado = true;
		botonColorSeleccionado.getStyleClass().add("botonColorSeleccionado");
		
	}
	
	public void deseleccionar() {
		
		seleccionado = false;
		botonColorSeleccionado.getStyleClass().add("botonColor");
		
	}
	
}
