package com.retur.paint.modelo.objetos;

public class ColorSeleccionado {

	
	
	private String color;
	private boolean seleccionado;
	
	public ColorSeleccionado(String color) {
		
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

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
}
