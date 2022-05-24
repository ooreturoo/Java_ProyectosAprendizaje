package com.retur.paint.modelo.funciones;

import com.retur.paint.modelo.elementos.pintura.ColorSeleccionado;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ApoyoControladores {

	
	/**
	 * Pinta el Canvas que se encuentra en el interior del botón del color almacenado en el
	 * texto asignado al botón.
	 * @param colorSeleccionado
	 */
	public static void pintarCanvasBotones(Button boton) {
		
		Canvas canvasBoton = (Canvas) boton.getGraphic();
		String color = boton.getText();
		GraphicsContext gc = canvasBoton.getGraphicsContext2D();
		gc.setFill(Color.web(color));
		gc.fillRect(0,0,canvasBoton.getWidth(),canvasBoton.getHeight());
		
	}
	
	/**
	 * Pinta el Canvas que se encuentra en el interior del botón del color almacenado en el
	 * objeto obtenido por parámetro.
	 * @param colorSeleccionado
	 */
	public static void pintarCanvasBotones(ColorSeleccionado colorSeleccionado) {
		
		double ancho = colorSeleccionado.MUESTREO_COLOR.getWidth();
		double alto = colorSeleccionado.MUESTREO_COLOR.getHeight();
		GraphicsContext gc = colorSeleccionado.MUESTREO_COLOR.getGraphicsContext2D();
		gc.setFill(colorSeleccionado.getColor());
		gc.fillRect(2,2,ancho-4, alto-4);
		gc.setStroke(Color.web("#6C6D6D"));
		gc.strokeRect(0, 0, colorSeleccionado.MUESTREO_COLOR.getWidth(),colorSeleccionado.MUESTREO_COLOR.getHeight());
		
	}
	
	
	
}
