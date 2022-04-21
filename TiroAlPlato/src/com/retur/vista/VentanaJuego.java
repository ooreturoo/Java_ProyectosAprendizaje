package com.retur.vista;


import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


public class VentanaJuego {
	
	private static final int DIMENSION_FUENTE_P = 20;
	private static final int DIMENSION_FUENTE_V = 30;
	private static final double SEPARACION_LABEL = 5;

	
	public final Scene ESCENA_JUEGO;
	public final Canvas CANVAS;
	public final Label PANEL_PUNTUACION;
	public final Label PANEL_VIDAS;
	public final double ANCHO_VENTANA_JUEGO;
	public final double ALTO_VENTANA_JUEGO;
	private final AnchorPane RAIZ_JUEGO;
	
	public VentanaJuego(double ancho, double alto) {
		
		ANCHO_VENTANA_JUEGO = ancho;
		ALTO_VENTANA_JUEGO = alto;

		RAIZ_JUEGO = new AnchorPane();
		CANVAS = new Canvas(ANCHO_VENTANA_JUEGO, ALTO_VENTANA_JUEGO);
		PANEL_PUNTUACION = crearPanelPuntuacion();
		PANEL_VIDAS = crearPanelVidas();
		
		RAIZ_JUEGO.setCursor(Cursor.NONE);
		RAIZ_JUEGO.getChildren().add(CANVAS);
		RAIZ_JUEGO.getChildren().add(PANEL_PUNTUACION);
		RAIZ_JUEGO.getChildren().add(PANEL_VIDAS);
		
		ESCENA_JUEGO = new Scene(RAIZ_JUEGO);
	}
	
	private Label crearPanelPuntuacion() {
		
		Label panel = new Label();
		AnchorPane.setTopAnchor(panel, SEPARACION_LABEL);
		AnchorPane.setRightAnchor(panel, SEPARACION_LABEL);
		panel.setFont(Font.font("Arial", FontWeight.BOLD, DIMENSION_FUENTE_P));
		panel.setAlignment(Pos.CENTER_RIGHT);
		panel.setText("0");
	
		return panel;
		
	}
	
	private Label crearPanelVidas() {
		
		Label panel = new Label();
		
		panel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		panel.setTextAlignment(TextAlignment.RIGHT);
		panel.setFont(Font.font("Arial", FontWeight.BOLD, DIMENSION_FUENTE_V));
		panel.setTextFill(Color.DARKRED);
		AnchorPane.setBottomAnchor(panel, SEPARACION_LABEL);
		AnchorPane.setRightAnchor(panel, SEPARACION_LABEL);
		return panel;
		
	}

}
