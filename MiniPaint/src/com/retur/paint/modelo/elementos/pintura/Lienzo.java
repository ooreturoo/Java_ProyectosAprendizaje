package com.retur.paint.modelo.elementos.pintura;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Lienzo {

	private final AnchorPane ANCHOR_LIENZO;
	public final Canvas CANVAS_LIENZO;
	private final String[][] dimensionLienzo;
	
	
	
	public Lienzo(int ancho,int alto, ScrollPane zonaLienzo) {
		
		ANCHOR_LIENZO = new AnchorPane();
		ANCHOR_LIENZO.setPrefWidth(ancho);
		ANCHOR_LIENZO.setPrefHeight(alto);
		CANVAS_LIENZO = new Canvas(ancho,alto);
		
		ANCHOR_LIENZO.getChildren().add(CANVAS_LIENZO);
		//Alomejor hay que añadir el evento en el controlador, donde poder obtener los colores
		// y comprobar que el click se ha hecho encima del Canvas del lienzo.
		CANVAS_LIENZO.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				if(e.getButton() == MouseButton.PRIMARY) {
					//TODO Añadir una forma de obtener el color seleccionado.
					rellenarColorPixel((int)e.getX(),(int) e.getY(), "Primercolor");
					
				}else if(e.getButton() == MouseButton.SECONDARY){
					
					rellenarColorPixel((int)e.getX(),(int) e.getY(), "SegundoColor");
					
				}
				
				
			}
		});
		zonaLienzo.setContent(ANCHOR_LIENZO);
		
		dimensionLienzo = new String[alto][ancho];
		
	}
	
	public String obtenerColorPixel(int x, int y) {
		
		return dimensionLienzo[y][x];
		
	}
	
	public void rellenarColorPixel(int x, int y, String colorHex ) {
		
		dimensionLienzo[y][x] = colorHex;
		pintar(x, y);
		
	}
	
	
	
	private void pintar(int x, int y) {
		

		GraphicsContext gc = CANVAS_LIENZO.getGraphicsContext2D();
		gc.setFill(Color.web(dimensionLienzo[y][x]));
		gc.fillRect(x, y, 1, 1);

	}
	
	
}
