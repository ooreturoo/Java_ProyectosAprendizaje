package com.retur.vista;


import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class VentanaJuego extends Ventana {
	
	private static final int DIMENSION_FUENTE_P = 20;
	private static final int DIMENSION_FUENTE_V = 30;
	private static final int SEPARACION_HORIZONTAL = 10;
	private static final int SEPARACION_VERTICAL = 25;
	
	
	public final Canvas CANVAS;
	
	
	public VentanaJuego(double ancho, double alto) {
		
		super(ancho, alto);
		
		
		CANVAS = new Canvas(ANCHO_VENTANA, ALTO_VENTANA);
		RAIZ.setCursor(Cursor.NONE);
		
		RAIZ.getChildren().add(CANVAS);

	}
	
	
	public void pintarPanelVidas(double vidas) {
		
		GraphicsContext gc = CANVAS.getGraphicsContext2D();
		
		gc.setFont(Font.font("Arial", FontWeight.BOLD, DIMENSION_FUENTE_V));
		gc.setFill(Color.DARKRED);
		gc.setTextAlign(TextAlignment.RIGHT);
		gc.fillText("VIDAS: " + vidas, ANCHO_VENTANA - SEPARACION_HORIZONTAL, ALTO_VENTANA - SEPARACION_VERTICAL);
		
		
	}
	
	public void pintarPanelPuntuacion(String puntuacion) {
		
		GraphicsContext gc = CANVAS.getGraphicsContext2D();
		
		gc.setFont(Font.font("Arial", FontWeight.BOLD, DIMENSION_FUENTE_P));
		gc.setFill(Color.BLACK);
		gc.setTextAlign(TextAlignment.RIGHT);
		gc.fillText(puntuacion, ANCHO_VENTANA - SEPARACION_HORIZONTAL, SEPARACION_VERTICAL);
		
		
	}

}
