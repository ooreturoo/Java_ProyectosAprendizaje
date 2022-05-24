package com.retur.paint.modelo.elementos.pintura;

import com.retur.paint.modelo.elementos.interfaces.Seleccionable;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ColorSeleccionado implements Seleccionable{

	
	public final Button BOTON_COLOR_SELEC;
	public final Canvas MUESTREO_COLOR;
	private Color color;
	private boolean seleccionado;
	
	public ColorSeleccionado(Button botonColorSeleccionado,Color color) {
		
		this.BOTON_COLOR_SELEC = botonColorSeleccionado;
		this.MUESTREO_COLOR = (Canvas) botonColorSeleccionado.getGraphic();
		this.color = color;
		
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	
	@Override
	public void seleccionado() {
		
		seleccionado = true;
		BOTON_COLOR_SELEC.getStyleClass().remove(ELEMENTO_DESELECCIONADO);
		BOTON_COLOR_SELEC.getStyleClass().add(ELEMENTO_SELECCIONADO);
		
	}

	@Override
	public void deseleccionado() {
		
		seleccionado = false;
		BOTON_COLOR_SELEC.getStyleClass().remove(ELEMENTO_SELECCIONADO);
		BOTON_COLOR_SELEC.getStyleClass().add(ELEMENTO_DESELECCIONADO);
		
	}
	
}
